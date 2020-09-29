package com.yummy.service.impl;

import com.yummy.dao.ProductDao;
import com.yummy.dao.impl.ProductDaoImpl;
import com.yummy.entity.Page;
import com.yummy.entity.Product;
import com.yummy.service.ProductService;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-15 14:22
 */
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> listProductsByType(String type) {
        return productDao.listProductsByType(type);
    }

    @Override
    public List<Product> listProducts() {
        return null;
    }

    @Override
    public Product getProductById(String id) {
        return productDao.getProductById(id);
    }

    @Override
    public Page<Product> pageInType(int pageNo, int pageSize, String type) {
        //创建空的分页对象
        Page<Product> page = new Page<>();
        //设置分页大小
        page.setPageSize(pageSize);
        //从数据库中获得该分页的记录条数
        Integer pageItemCount = productDao.countProductByType(type);
        //设置分页的记录条数
        page.setItemCount(pageItemCount);

        //设置当前分页页面号
        page.setPageNow(pageNo);
        //计算要显示的记录的起始值
        int begin = (page.getPageNow() - 1) * pageSize;

        //设置分页条请求的url地址
        page.setUrl("listProductsForPage.cart");

        //得到并设置该页的记录
        List<Product> products = productDao.listProductsForPageInType(begin, pageSize, type);
        page.setItems(products);
        return page;
    }

    @Override
    public int saveProduct(Product product) {
        return productDao.saveProduct(product);
    }

    @Override
    public int deleteProductById(String id) {
        return productDao.deleteProductById(id);
    }

    @Override
    public int updateProduct(Product product) {
        return productDao.updateProduct(product);
    }
}
