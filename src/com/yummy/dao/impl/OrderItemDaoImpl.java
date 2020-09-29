package com.yummy.dao.impl;

import com.yummy.dao.OrderItemDao;
import com.yummy.entity.OrderItem;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-13 16:17
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO `tb_order_item`(`item_id`,`item_name`,`item_img_path` ,`item_price`,`item_count`,`total_price`,`order_id`) " +
                "VALUES(?,?,?,?,?,?,?)";
        return update(sql, orderItem.getItemId(), orderItem.getItemName(),orderItem.getImg_path(), orderItem.getItemPrice(),
                orderItem.getItemCount(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public int deleteOrderItemById(String id) {
        String sql = "DELETE FROM `tb_order_item` WHERE `item_id`=?";
        return update(sql, id);
    }

    @Override
    public int deleteOrderItemByOrderId(String orderId) {
        String sql = "DELETE FROM `tb_order_item` WHERE `order_id`=?";
        return update(sql, orderId);
    }

    @Override
    public int updateOrderItem(OrderItem orderItem) {
        String sql = "UPDATE `tb_order_item` SET `item_name`=?,`item_img_path`=?, `item_price`=?,`item_count`=?,`total_price`=?" +
                " WHERE `item_id`=?";
        return update(sql, orderItem.getItemName(),orderItem.getImg_path(), orderItem.getItemPrice(), orderItem.getItemCount(),
                orderItem.getTotalPrice(), orderItem.getItemId());
    }

    @Override
    public OrderItem getOrderItemById(String id) {
        String sql = "SELECT `item_id` itemId,`item_name` itemName,`item_img_path` img_path,`item_price` itemPrice,`item_count` itemCount," +
                "`total_price` totalPrice,`order_id` orderId FROM `tb_order_item` WHERE `item_id`=?";
        return getInstance(OrderItem.class, sql, id);
    }

    @Override
    public List<OrderItem> listOrderItemByOrderId(String orderId) {
        String sql = "SELECT `item_id` itemId,`item_name` itemName,`item_img_path` img_path,`item_price` itemPrice,`item_count` itemCount," +
                "`total_price` totalPrice,`order_id` orderId FROM `tb_order_item` WHERE `order_id`=?";
        return listInstances(OrderItem.class, sql, orderId);
    }

    @Override
    public List<OrderItem> listOrderItemForPageByOrderId(int begin, int pageSize, String orderId) {
        String sql = "SELECT `item_id` itemId,`item_name` itemName,`item_img_path` img_path,`item_price` itemPrice,`item_count` itemCount," +
                "`total_price` totalPrice,`order_id` orderId FROM `tb_order_item` WHERE `order_id`=? LIMIT ?,?";
        return listInstances(OrderItem.class, sql, orderId, begin, pageSize);
    }

    @Override
    public int countOrderItemByOrderId(String orderId) {
        String sql = "SELECT COUNT(*) FROM `tb_order_item` WHERE `order_id`=?";
        Number countItem = (Number) getSingleValue(sql, orderId);
        return countItem.intValue();
    }
}
