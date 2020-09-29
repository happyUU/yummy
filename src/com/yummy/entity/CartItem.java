package com.yummy.entity;

import java.math.BigDecimal;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-14 16:06
 */
public class CartItem {
    private String id;
    private String name;
    private String img_path;
    private String type;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;

    @Override
    public String toString() {
        return "CartItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", img_path='" + img_path + '\'' +
                ", type='" + type + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    /**
     * 提供一个静态方法 将商品对象转换成购物车商品对象
     * @param product
     * @return
     */
    public static CartItem castToCartItem(Product product){
        return castToCartItem(product, 1);
    }

    public static CartItem castToCartItem(Product product, Integer count){
        CartItem cartItem = new CartItem();

        cartItem.setId(product.getProductId());
        cartItem.setName(product.getName());
        cartItem.setPrice(product.getPrice());
        cartItem.setCount(count);
        cartItem.setImg_path(product.getImg_path());
        cartItem.setType(product.getType());
        cartItem.setTotalPrice(product.getPrice().multiply(new BigDecimal(count)));

        return cartItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        setTotalPrice(getPrice().multiply(new BigDecimal(count)));
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CartItem() {
    }

    public CartItem(String id, String name, Integer count, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = price.multiply(new BigDecimal(count));
    }
}
