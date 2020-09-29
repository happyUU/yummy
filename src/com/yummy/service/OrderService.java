package com.yummy.service;

import com.yummy.entity.Order;
import com.yummy.entity.OrderItem;
import com.yummy.entity.Page;
import com.yummy.entity.UserAddress;

import java.util.List;

/**
 * @author Gp
 * @email 13767654524@163.com
 * @create 2020/9/5 15:54
 */
public interface OrderService {
    /**
     * 查询所有订单
     * @return
     */
    List<Order> listOrder(String userId);

    /**
     * 根据订单 ID 查询订单
     * @param id
     * @return
     */
    Order getOrderById(String id);

    /**
     * 创建订单
     * @param items
     * @param userId
     * @return
     */
    boolean createOrder(List<OrderItem> items, UserAddress userReceiving, String userId);

    /**
     * 根据订单 ID 删除订单
     * @param id
     * @return
     */
    boolean deleteOrderById(String id);

    boolean updateOrder(Order order);

    Page<Order> page(String userId, int pageNow, int pageSize);


}
