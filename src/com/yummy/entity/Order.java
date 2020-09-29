package com.yummy.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Gp
 * @email 13767654524@163.com
 * @create 2020/9/7 8:39
 */
public class Order {
    private String orderId;
    private String createTime;
    private BigDecimal itemTotalPrice;
    private BigDecimal orderCarriage;
    private BigDecimal orderPrice;
    private BigDecimal actuallyPaid;
    //待支付（100） 待发货（200）  待签收（300）   已签收（400）   已关闭（500）   已完成（600）
    private Integer orderStatue;
    private String receivingName;
    private String receivingPhone;
    private  String receivingAddr;
    private String userId;

    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(String orderId, String createTime, BigDecimal itemTotalPrice, BigDecimal orderCarriage, BigDecimal orderPrice, BigDecimal actuallyPaid, Integer orderStatue, String receivingName, String receivingPhone, String receivingAddr, String userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.itemTotalPrice = itemTotalPrice;
        this.orderCarriage = orderCarriage;
        this.orderPrice = orderPrice;
        this.actuallyPaid = actuallyPaid;
        this.orderStatue = orderStatue;
        this.receivingName = receivingName;
        this.receivingPhone = receivingPhone;
        this.receivingAddr = receivingAddr;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", itemTotalPrice=" + itemTotalPrice +
                ", orderCarriage=" + orderCarriage +
                ", orderPrice=" + orderPrice +
                ", actuallyPaid=" + actuallyPaid +
                ", orderStatue=" + orderStatue +
                ", receivingName='" + receivingName + '\'' +
                ", receivingPhone='" + receivingPhone + '\'' +
                ", receivingAddr='" + receivingAddr + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime){
        this.createTime = createTime;
    }

    public BigDecimal getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(BigDecimal itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    public BigDecimal getOrderCarriage() {
        return orderCarriage;
    }

    public void setOrderCarriage(BigDecimal orderCarriage) {
        this.orderCarriage = orderCarriage;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getActuallyPaid() {
        return actuallyPaid;
    }

    public void setActuallyPaid(BigDecimal actuallyPaid) {
        this.actuallyPaid = actuallyPaid;
    }

    public Integer getOrderStatue() {
        return orderStatue;
    }

    public void setOrderStatue(Integer orderStatue) {
        this.orderStatue = orderStatue;
    }

    public String getReceivingName() {
        return receivingName;
    }

    public void setReceivingName(String receivingName) {
        this.receivingName = receivingName;
    }

    public String getReceivingPhone() {
        return receivingPhone;
    }

    public void setReceivingPhone(String receivingPhone) {
        this.receivingPhone = receivingPhone;
    }

    public String getReceivingAddr() {
        return receivingAddr;
    }

    public void setReceivingAddr(String receivingAddr) {
        this.receivingAddr = receivingAddr;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
