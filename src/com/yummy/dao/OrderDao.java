package com.yummy.dao;

import com.yummy.entity.Order;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-07 14:42
 */
public interface OrderDao {

    Order getOrderById(String id);

    int saveOrder(Order order);

    int deleteOrderById(String id);

    int updateOrder(Order order);

    List<Order> listOrderByUserId(String userId);

    int countOrderByUserId(String userId);

    List<Order> listOrderForPageByUserId(String userId, int begin, int pageSize);

}
