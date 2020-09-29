package com.yummy.service.impl;

import com.yummy.dao.OrderDao;
import com.yummy.dao.OrderItemDao;
import com.yummy.dao.impl.OrderDaoImpl;
import com.yummy.dao.impl.OrderItemDaoImpl;
import com.yummy.entity.Order;
import com.yummy.entity.OrderItem;
import com.yummy.entity.Page;
import com.yummy.entity.UserAddress;
import com.yummy.service.OrderService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-13 18:12
 */
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao = new OrderDaoImpl();
    private final OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public List<Order> listOrder(String userId) {
        List<Order> orders = orderDao.listOrderByUserId(userId);
        fillOrderItems(orders);
        return orders;
    }

    @Override
    public Order getOrderById(String id) {
        Order order = orderDao.getOrderById(id);
        fillOrderItems(order);
        return order;
    }

    @Override
    public boolean createOrder(List<OrderItem> items, UserAddress userReceiving, String userId){
        Order order = new Order();

        BigDecimal totalPrice = new BigDecimal(0);
        BigDecimal orderCarriage = new BigDecimal(0);
        BigDecimal orderPrice = new BigDecimal(0);
        BigDecimal actuallyPaid = new BigDecimal(0);

        for (OrderItem item : items) {
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        if(totalPrice.intValue() < 200){
            orderCarriage = orderCarriage.add(new BigDecimal(10));
        }
        orderPrice = orderPrice.add(totalPrice).add(orderCarriage);
        actuallyPaid = actuallyPaid.add(orderPrice);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setOrderId(getRandomOrderId(userId));
        order.setCreateTime(simpleDateFormat.format(new Date()));
        order.setItemTotalPrice(totalPrice);
        order.setOrderPrice(orderPrice);
        order.setOrderCarriage(orderCarriage);
        order.setActuallyPaid(actuallyPaid);
        order.setUserId(userId);
        order.setReceivingName(userReceiving.getRecName());
        order.setReceivingPhone(userReceiving.getRecPhone());
        order.setReceivingAddr(userReceiving.getAddrString());
        order.setOrderStatue(100);

        for (OrderItem item : items) {
            item.setOrderId(order.getOrderId());
            orderItemDao.saveOrderItem(item);
        }

        return orderDao.saveOrder(order) > 0;
    }

    private String getRandomOrderId(String userId){
        StringBuilder orderIdBuilder = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = simpleDateFormat.format(System.currentTimeMillis());
        orderIdBuilder.append(dateStr).append(userId);
        return orderIdBuilder.toString();
    }

    public boolean saveOrder(Order order) {
        return orderDao.saveOrder(order) > 0;
    }

    @Override
    public boolean deleteOrderById(String id) {
        return orderDao.deleteOrderById(id) >= 1;
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderDao.updateOrder(order) > 0;
    }

    @Override
    public Page<Order> page(String userId, int pageNow, int pageSize) {
        Page<Order> page = new Page<>();
        page.setPageSize(pageSize);
        int itemCount = orderDao.countOrderByUserId(userId);
        page.setItemCount(itemCount);
        page.setPageNow(pageNow);

        int begin = (pageNow - 1) * pageSize;
        if((pageNow - 1) % pageSize > 0){
            begin++;
        }
        List<Order> orders = orderDao.listOrderForPageByUserId(userId, begin, pageSize);
        fillOrderItems(orders);
        page.setItems(orders);
        page.setUrl("");

        return page;
    }

    private void fillOrderItems(Order order){
        order.setOrderItems(orderItemDao.listOrderItemByOrderId(order.getOrderId()));
    }
    private void fillOrderItems(List<Order> orders){
        for (Order order : orders) {
            fillOrderItems(order);
        }
    }
}
