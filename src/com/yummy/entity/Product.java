package com.yummy.entity;

import java.math.BigDecimal;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-14 15:42
 */
public class Product {
    private String productId;
    private String name;
    private BigDecimal price;
    private String img_path;
    private String desc;
    private String type;

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", img_path='" + img_path + '\'' +
                ", desc='" + desc + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Product(String productId, String name, BigDecimal price, String img_path, String desc, String type) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.img_path = img_path;
        this.desc = desc;
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public Product() {
    }

}
