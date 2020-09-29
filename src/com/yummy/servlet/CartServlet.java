package com.yummy.servlet;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yummy.entity.*;
import com.yummy.service.ProductService;
import com.yummy.service.impl.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 与购物车、商品相关的servlet
 *
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-14 16:24
 */
@WebServlet(urlPatterns = {"*.cart"})
public class CartServlet extends BaseServlet {

    private final ProductService productService = new ProductServiceImpl();

    protected void refreshCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String str = request.getParameter("map");
        Gson gson = new Gson();
        Map<String, Object> valMap = gson.fromJson(str, new TypeToken<HashMap<String, Object>>() {
        }.getType());

        String[] checkedItems = ((String) valMap.get("checked")).split("-");
        String[] items = ((String) valMap.get("items")).split("-");
        String[] counts = ((String) valMap.get("counts")).split("-");
        Cart cart = getCartFromRequest(request);

        cart.clearCart();
        cart.clearCheckedCart();

        for (int i = 1; i < items.length; i++) {
            Product product = productService.getProductById(items[i]);
            cart.add(CartItem.castToCartItem(product, Integer.parseInt(counts[i])));
        }
        cart.setCheckedCartItems(checkedItems);

        request.getSession().setAttribute("cart", cart);
    }

    /**
     * 改方法获取购物车信息，并将改购物车信息封装到Message对象中以json字符串方式返回
     *
     * @param request
     * @param response
     * @throws Exception
     */
    protected void showCart(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //从session域中获取购物车对象
        Cart cart = getCartFromRequest(request);

        //将结果封装成Message对象并以json字符串方式返回
        Message message = Message.success("已获取购物车").add("cart", cart);
        response.getWriter().write(new Gson().toJson(message));

    }

    protected void toOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameter("itemIds").split("-");

        //从session域中获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //若购物车对象为空，则创建购物车对象并放入到session域中
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
            response.sendRedirect("/pages/cart.jsp");
        }

        cart.checked(ids);
        request.getSession().setAttribute("cart", cart);

        response.sendRedirect(request.getContextPath() + "/pages/manager/order.jsp");
    }

    private Cart getCartFromRequest(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        return cart;
    }

    /**
     * 从请求中获取商品id，并将该id对应商品添加到购物车
     *
     * @param request
     * @param response
     * @throws Exception
     */
    protected void addCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //从请求域中获取商品id 并查找到该id对应商品信息
        String id = request.getParameter("product_id");
        Product product = productService.getProductById(id);
        //将商品对象转换成购物车商品对象
        CartItem cartItem = CartItem.castToCartItem(product);

        Cart cart = getCartFromRequest(request);
        //将购物车商品对象添加入购物车
        cart.add(cartItem);

        //返回Message
        Message message = Message.success("已商品添加至购物车").add("CartItem", cartItem);
        response.getWriter().write(new Gson().toJson(message));

    }

    /**
     * 获取商品信息的分页
     *
     * @param request
     * @param response
     * @throws Exception
     */
    protected void listProductsForPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //获得三种商品对应的分页信息
        Page<Product> cookerPage = productService.pageInType(1, 8, "cooker");
        Page<Product> fruitsPage = productService.pageInType(1, 8, "fruits");
        Page<Product> snacksPage = productService.pageInType(1, 8, "snacks");

        //将分页信息全部添加入Message中并返回给前端页面
        Message message = Message.success("获取商品集合")
                .add("cookerPage", cookerPage)
                .add("fruitsPage", fruitsPage)
                .add("snacksPage", snacksPage);
        response.getWriter().write(new Gson().toJson(message));
    }

    /**
     * 删除购物车商品  批量删除或单个删除
     *
     * @param request
     * @param response
     * @throws Exception
     */
    protected void deleteCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /*
            1、从请求域中获取由商品id连成的字符串 多个id之间以-连接
            2、将该字符串分割成字符串数组，每个字串即一个商品id
         */
        String[] ids = request.getParameter("itemIds").split("-");

        Cart cart = getCartFromRequest(request);

        //循环从购物车对象中删除每一个购物车商品对象
        for (String id : ids) {
            cart.remove(id);
        }

        Message message = Message.success("已移除商品").add("cart", cart);
        response.getWriter().write(new Gson().toJson(message));
    }

}
