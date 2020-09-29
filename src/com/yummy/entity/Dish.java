package com.yummy.entity;

import com.yummy.dishkind.ChineseStyleDishKindEnum;
import com.yummy.dishkind.WesternStyleDishKindEnum;

/**
 * @author Gp
 * @email 13767654524@163.com
 * @create 2020/9/7 8:58
 */
public class Dish {

    /*// 该菜品对应的菜系标号
    private Integer id;

    // 菜名
    private String name;

    // 存放图片 URL 地址
    private String imageURL;

    // 菜品描述
    private String description;

    // 库存
    private Integer stock;

    public Dish() {
    }

    public Dish(Integer id, String imageURL, String description, Integer stock) {
        this.id = id;
        if (id > 200) {
            this.name = WesternStyleDishKindEnum.getDishType(id);
        }
        else {
            this.name = ChineseStyleDishKindEnum.getDishType(id);
        }
        this.imageURL = imageURL;
        this.description = description;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }*/
    private String firstbelong;  //中西
    private String dishid;       //菜品id
    private String typename;     //菜系名
    private String disname;      //菜品名
    private String disprice;
    private String dispic;
    private String describe;
    private String oper;

    public Dish() {
    }

    public String getFirstbelong() {
        return firstbelong;
    }

    public void setFirstbelong(String firstbelong) {
        this.firstbelong = firstbelong;
    }

    public String getDishid() {
        return dishid;
    }

    public void setDishid(String dishid) {
        this.dishid = dishid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getDisname() {
        return disname;
    }

    public void setDisname(String disname) {
        this.disname = disname;
    }

    public String getDisprice() {
        return disprice;
    }

    public void setDisprice(String disprice) {
        this.disprice = disprice;
    }

    public String getDispic() {
        return dispic;
    }

    public void setDispic(String dispic) {
        this.dispic = dispic;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "firstbelong='" + firstbelong + '\'' +
                ", dishid='" + dishid + '\'' +
                ", typename='" + typename + '\'' +
                ", disname='" + disname + '\'' +
                ", disprice='" + disprice + '\'' +
                ", dispic='" + dispic + '\'' +
                ", describe='" + describe + '\'' +
                ", oper='" + oper + '\'' +
                '}';
    }
}
