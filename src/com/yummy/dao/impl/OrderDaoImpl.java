package com.yummy.dao.impl;

import com.yummy.dao.OrderDao;
import com.yummy.entity.Order;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-07 14:43
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO `tb_order`(`order_id`,`create_time`,`item_total_price`," +
                "`order_carriage`,`order_price`,`actually_paid`,`order_statue`,`receiving_name`,`receiving_phone`,`receiving_addr`,`user_id`)\n" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //从前端或者自己模拟一个日期格式，转为String即可
//        String dateStr = format.format(order.getCreateTime());
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getItemTotalPrice(), order.getOrderCarriage(),
                order.getOrderPrice(), order.getActuallyPaid(), order.getOrderStatue(), order.getReceivingName(),
                order.getReceivingPhone(), order.getReceivingAddr(), order.getUserId());
    }

    @Override
    public int deleteOrderById(String id) {
        String sql = "DELETE FROM tb_order WHERE order_id=?";
        return update(sql, id);
    }

    @Override
    public int updateOrder(Order order) {
        String sql = "UPDATE tb_order SET `item_total_price`=?,`order_carriage`=?,`order_price`=?," +
                "`actually_paid`=?,`order_statue`=?,`receiving_name`=?,`receiving_phone`=?," +
                "`receiving_addr`=? WHERE order_id=?";
        return update(sql, order.getItemTotalPrice(), order.getOrderCarriage(), order.getOrderPrice(),
                order.getActuallyPaid(), order.getOrderStatue(), order.getReceivingName(), order.getReceivingPhone(),
                order.getReceivingAddr(), order.getOrderId());
    }

    @Override
    public List<Order> listOrderByUserId(String userId) {
        String sql = "SELECT `order_id` orderId, `create_time` createTime,`item_total_price` itemTotalPrice," +
                "`order_carriage` orderCarriage,`order_price` orderPrice,`actually_paid` actuallyPaid," +
                "`order_statue` orderStatue,`receiving_name` receivingName,`receiving_phone` receivingPhone," +
                "`receiving_addr` receivingAddr,`user_id` userId FROM tb_order WHERE user_id=?";
        return listInstances(Order.class, sql, userId);
    }

    @Override
    public int countOrderByUserId(String userId) {
        String sql = "SELECT COUNT(*) FROM tb_order WHERE user_id=?";
        Number countOrder = (Number) getSingleValue(sql, userId);
        return countOrder.intValue();
    }

    @Override
    public List<Order> listOrderForPageByUserId(String userId, int begin, int pageSize) {
        String sql = "SELECT `order_id` orderId, `create_time` createTime,`item_total_price` itemTotalPrice," +
                "`order_carriage` orderCarriage,`order_price` orderPrice,`actually_paid` actuallyPaid," +
                "`order_statue` orderStatue,`receiving_name` receivingName,`receiving_phone` receivingPhone," +
                "`receiving_addr` receivingAddr,`user_id` userId FROM tb_order WHERE user_id=? LIMIT ?,?";
        return listInstances(Order.class, sql, userId, begin, pageSize);
    }

    @Override
    public Order getOrderById(String id) {
        String sql = "SELECT `order_id` orderId, `create_time` createTime,`item_total_price` itemTotalPrice,`order_carriage` orderCarriage," +
                "`order_price` orderPrice,`actually_paid` actuallyPaid,`order_statue` orderStatue,`receiving_name` receivingName," +
                "`receiving_phone` receivingPhone,`receiving_addr` receivingAddr,`user_id` userId FROM tb_order WHERE order_id=?";

        return getInstance(Order.class, sql, id);
    }


}
