package com.yummy.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-14 16:05
 */
public class Cart {

    private boolean emptyCart = true;
    private Integer checkedTotalCount = 0;
    private BigDecimal checkedTotalPrice = new BigDecimal("0.00");

    private final Map<String, CartItem> cartItems = new HashMap<>();
    private final Map<String, CartItem> checkedCartItems = new HashMap<>();

    public BigDecimal getCheckedTotalPrice() {
        return checkedTotalPrice;
    }

    public void setCheckedTotalPrice(BigDecimal checkedTotalPrice) {
        this.checkedTotalPrice = checkedTotalPrice;
    }

    public void setCheckedCartItems(String[] items) {
        for (String item : items) {
            if("".equals(item)) continue;
            CartItem cartItem = this.cartItems.get(item);
            this.checkedCartItems.put(item, cartItem);
        }
    }

    public Map<String, CartItem> getCheckedCartItems(){
        return checkedCartItems;
    }

    public void checked(String[] ids){
        this.checkedCartItems.clear();
        BigDecimal checkedTotalPrice = new BigDecimal("0.00");
        for (String id : ids) {
            CartItem cartItem = this.cartItems.get(id);
            checkedTotalPrice = checkedTotalPrice.add(new BigDecimal(String.valueOf(cartItem.getTotalPrice())));
            checkedCartItems.put(id, cartItem);
        }
        setCheckedTotalPrice(checkedTotalPrice);
    }

    public boolean isEmptyCart() {
        return emptyCart;
    }

    public void setEmptyCart(boolean emptyCart) {
        this.emptyCart = emptyCart;
    }

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public Cart() {
    }

    /**
     * 为购物车添加购物车商品对象 存放到map中
     * 若已存在 则原有购物车对象count++
     * @param cartItem
     */
    public void add(CartItem cartItem){
        CartItem item = cartItems.get(cartItem.getId());
        if(item == null){
            cartItems.put(cartItem.getId(), cartItem);
        }else{
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
        emptyCart = false;
    }

    /**
     * 根据商品id移除购物车商品
     * @param id
     * @return
     */
    public CartItem remove(String id){
        CartItem res = cartItems.remove(id);
        if(checkedCartItems.containsKey(id)){
            checkedCartItems.remove(id);
            this.checkedTotalPrice = this.checkedTotalPrice.subtract(res.getTotalPrice());
            this.checkedTotalCount -= res.getCount();
        }
        emptyCart = cartItems.isEmpty();
        return res;
    }

    public void deleteItem(String id){
        cartItems.remove(id);
    }

    public void deleteCartItemsChecked(){
        for(Map.Entry<String, CartItem> entry: checkedCartItems.entrySet()){
            cartItems.remove(entry.getKey());
        }
        this.emptyCart = cartItems.isEmpty();
        clearCheckedCart();
    }

    public void clearCart(){
        cartItems.clear();
        this.emptyCart = true;
    }

    public void clearCheckedCart(){
        checkedCartItems.clear();
        checkedTotalPrice = new BigDecimal("0.00");
        checkedTotalCount = 0;
    }
}
