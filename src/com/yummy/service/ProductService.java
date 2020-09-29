package com.yummy.service;

import com.yummy.entity.Page;
import com.yummy.entity.Product;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-15 14:22
 */
public interface ProductService {

    /**
     * 得到指定商品类型的商品集合
     * @param type  商品类型
     * @return  商品集合
     */
    List<Product> listProductsByType(String type);

    /**
     * 得到所有商品的集合
     * @return
     */
    List<Product> listProducts();

    /**
     * 根据id得到某一商品的对象
     * @param id
     * @return
     */
    Product getProductById(String id);

    /**
     * 得到指定商品类型的商品分页信息
     * @param pageNo    当前页面号
     * @param pageSize  每页显示商品条目数
     * @param type      商品类型
     * @return   返回该类型对应的商品分页对象
     */
    Page<Product> pageInType(int pageNo, int pageSize, String type);

    /**
     * 保存商品对象
     * @param product
     * @return
     */
    int saveProduct(Product product);

    /**
     * 根据id删除商品
     * @param id
     * @return
     */
    int deleteProductById(String id);

    /**
     * 更新商品信息
     * @param product
     * @return
     */
    int updateProduct(Product product);

}
