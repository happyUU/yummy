package com.yummy.entity;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-09 15:56
 */
public class OrderItem {
    private String itemId;
    private String itemName;
    private String img_path;
    private BigDecimal itemPrice;
    private  Integer itemCount;
    private BigDecimal totalPrice;
    private String orderId;

    private String productId;

    public static OrderItem castToOrderItem(CartItem cartItem){
        OrderItem orderItem = new OrderItem();

        orderItem.setProductId(cartItem.getId());
        orderItem.setItemName(cartItem.getName());
        orderItem.setImg_path(cartItem.getImg_path());
        orderItem.setItemPrice(cartItem.getPrice());
        orderItem.setItemCount(cartItem.getCount());
        orderItem.setTotalPrice(cartItem.getTotalPrice());

        String productId = cartItem.getId();
        String timeLongString = System.currentTimeMillis() + "";
        String itemId = productId.substring(productId.length()-3) + (timeLongString).substring(timeLongString.length() - 5);
        orderItem.setItemId(itemId);

        return orderItem;
    }

    private static String getRandomItemId(){
        StringBuilder itemIdBuilder = new StringBuilder();
        String dateStr = System.currentTimeMillis() + "";
        Random random = new Random();
        itemIdBuilder.append(dateStr.substring(dateStr.length() - 5)).append(random.nextInt(300));

        return itemIdBuilder.toString();
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId='" + itemId + '\'' +
                ", productId='" + productId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemCount=" + itemCount +
                ", totalPrice=" + totalPrice +
                ", orderId='" + orderId + '\'' +
                '}';
    }


    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderItem() {
    }
}
