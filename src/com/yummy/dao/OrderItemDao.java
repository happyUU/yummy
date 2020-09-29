package com.yummy.dao;

import com.yummy.entity.OrderItem;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-13 16:17
 */
public interface OrderItemDao {

    int saveOrderItem(OrderItem orderItem);

    int deleteOrderItemById(String id);

    int deleteOrderItemByOrderId(String orderId);

    int updateOrderItem(OrderItem orderItem);

    OrderItem getOrderItemById(String id);

    List<OrderItem> listOrderItemByOrderId(String orderId);

    List<OrderItem> listOrderItemForPageByOrderId(int begin, int pageSize, String orderId);

    int countOrderItemByOrderId(String orderId);

}
