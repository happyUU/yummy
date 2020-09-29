package com.yummy.servlet;

import com.google.gson.Gson;
import com.yummy.entity.*;
import com.yummy.service.OrderService;
import com.yummy.service.UserAddressService;
import com.yummy.service.impl.OrderServiceImpl;
import com.yummy.service.impl.UserAddressServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-13 19:18
 */
@WebServlet(urlPatterns = {"*.order"})
public class OrderServlet extends BaseServlet {

    private final OrderService orderService = new OrderServiceImpl();
    private final UserAddressService userAddressService = new UserAddressServiceImpl();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Message message = null;
        String addressId = request.getParameter("address_id");

        Users users = (Users) request.getSession().getAttribute("user");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart == null){
            System.out.println("Cart is null!");
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        UserAddress userAddress = userAddressService.getUserAddressById(addressId);
        List<OrderItem> orderItemList = createOrderItems(cart);

        if(orderService.createOrder(orderItemList, userAddress, users.getPhone())){
            cart.deleteCartItemsChecked();
            request.getSession().setAttribute("cart", cart);
            message = Message.success("订单创建成功").add("cart", cart);
        }else {
            message = Message.failed("订单创建失败");
        }

        response.getWriter().write(new Gson().toJson(message));

    }

    private List<OrderItem> createOrderItems(Cart cart){

        Map<String, CartItem> cartItemMap = cart.getCheckedCartItems();
        List<OrderItem> orderItemList = new ArrayList<>();
        for(Map.Entry<String, CartItem> entry : cartItemMap.entrySet()){
            orderItemList.add(OrderItem.castToOrderItem(entry.getValue()));
        }

        return orderItemList;
    }

    protected void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Message message = null;

        String orderId = request.getParameter("order_id");

        if(orderService.deleteOrderById(orderId)){
            message = Message.success("订单关闭");
        }else {
            message = Message.failed("订单关闭过程中出现异常");
        }



        response.getWriter().write(new Gson().toJson(message));

    }

    protected void getCartItems(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
            response.sendRedirect(request.getContextPath() + "/pages/shopping.jsp");
        }

        Map<String, CartItem> cartItemMap = cart.getCheckedCartItems();

        Message message = Message.success("已获取选中商品，准备创建订单").add("cartItems", cartItemMap);

        response.getWriter().write(new Gson().toJson(message));

    }

    protected void listOrders(HttpServletRequest request, HttpServletResponse response) throws Exception{
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        Users users = (Users) request.getSession().getAttribute("user");
        
        Page<Order> page = orderService.page(users.getPhone(), pageNow, pageSize);

        response.getWriter().write(new Gson().toJson(page));

    }

    protected void getOrderInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String orderId = request.getParameter("orderId");
        Order order = orderService.getOrderById(orderId);

       // Message message = Message.success("成功获取订单信息");


        response.getWriter().write(new Gson().toJson(order));
    }

}
