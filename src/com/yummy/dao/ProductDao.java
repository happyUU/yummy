package com.yummy.dao;

import com.yummy.entity.Product;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-14 16:29
 */
public interface ProductDao {

    int saveProduct(Product product);

    int deleteProductById(String id);

    int updateProduct(Product product);

    /**
     * 根据id查找商品
     *
     * @param id
     * @return
     */
    Product getProductById(String id);

    /**
     * 查找指定类型的商品集合
     *
     * @param type
     * @return
     */
    List<Product> listProductsByType(String type);

    /**
     * 查找指定类型的商品数目 结果为一行一列的单一值
     *
     * @param type 指定的类型
     * @return 商品数目
     */
    Integer countProductByType(String type);

    /**
     * 查找分页所需的指定类型的商品集合
     *
     * @param begin    获取该位置以后的记录
     * @param pageSize 要获取的记录条目数
     * @param type     指定的类型
     * @return 返回记录构成的集合
     */
    List<Product> listProductsForPageInType(int begin, int pageSize, String type);


}
