package com.yummy.dao.impl;

import com.yummy.dao.ProductDao;
import com.yummy.entity.Product;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-14 16:29
 */
public class ProductDaoImpl extends BaseDao implements ProductDao {

    @Override
    public int saveProduct(Product product) {
        String sql = "INSERT INTO `tb_product`(`id`,`name`,`price`,`pic_path`,`desc`,`type`) VALUES(?,?,?,?,?,?)";
        return update(sql, product.getProductId(), product.getName(), product.getPrice(),
                product.getImg_path(),product.getDesc(), product.getType());
    }

    @Override
    public int deleteProductById(String id) {
        String sql = "DELETE FROM `tb_product` WHERE `id`=?";
        return update(sql, id);
    }

    @Override
    public int updateProduct(Product product) {
        String sql = "UPDATE `tb_product` SET `name`=?,`price`=?,`pic_path`=?,`desc`=?,`type`=? WHERE `id`=?";
        return update(sql, product.getName(), product.getPrice(), product.getImg_path(), product.getDesc(), product.getType(), product.getProductId());
    }

    @Override
    public Product getProductById(String id) {
        String sql = "SELECT `id` `productId`,`name` `name`,`price` `price`,`pic_path` `img_path`,`desc` `desc`,`type` type FROM `tb_product` WHERE `id`=?";
        return getInstance(Product.class, sql, id);
    }

    @Override
    public List<Product> listProductsByType(String type) {
        String sql = "SELECT `id` `productId`,`name` `name`,`price` `price`,`pic_path` `img_path`,`desc` `desc`,`type` `type` FROM `tb_product` WHERE `type`=?";
        return listInstances(Product.class, sql, type);
    }

    @Override
    public Integer countProductByType(String type) {
        String sql = "SELECT COUNT(*) FROM `tb_product` WHERE `type`=?";
        Number count = (Number) getSingleValue(sql, type);
        return count.intValue();
    }

    @Override
    public List<Product> listProductsForPageInType(int begin, int pageSize, String type) {
        String sql = "SELECT `id` `productId`,`name` `name`,`price` `price`,`pic_path` `img_path`,`desc` `desc`,`type` `type` FROM `tb_product` " +
                "WHERE `type`=? limit ?,?";
        return listInstances(Product.class, sql, type, begin, pageSize);
    }
}
