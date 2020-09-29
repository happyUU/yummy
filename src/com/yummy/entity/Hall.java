package com.yummy.entity;

public class Hall {
    private String firstbelong;
    private String hallid;
    private String name;
    private String avgprice;
    private String address;
    private String picture;
    private String telphone;
    private String decribe;
    private String dishid;

    public Hall() {
    }

    public Hall(String firstbelong, String hallid, String name, String avgprice, String address, String picture, String telphone, String decribe, String dishid) {
        this.firstbelong = firstbelong;
        this.hallid = hallid;
        this.name = name;
        this.avgprice = avgprice;
        this.address = address;
        this.picture = picture;
        this.telphone = telphone;
        this.decribe = decribe;
        this.dishid = dishid;
    }

    public String getFirstbelong() {
        return firstbelong;
    }

    public void setFirstbelong(String firstbelong) {
        this.firstbelong = firstbelong;
    }

    public String getHallid() {
        return hallid;
    }

    public void setHallid(String hallid) {
        this.hallid = hallid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvgprice() {
        return avgprice;
    }

    public void setAvgprice(String avgprice) {
        this.avgprice = avgprice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getDecribe() {
        return decribe;
    }

    public void setDecribe(String decribe) {
        this.decribe = decribe;
    }

    public String getDishid() {
        return dishid;
    }

    public void setDishid(String dishid) {
        this.dishid = dishid;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "firstbelong='" + firstbelong + '\'' +
                ", hallid='" + hallid + '\'' +
                ", name='" + name + '\'' +
                ", avgprice='" + avgprice + '\'' +
                ", address='" + address + '\'' +
                ", picture='" + picture + '\'' +
                ", telphone='" + telphone + '\'' +
                ", decribe='" + decribe + '\'' +
                ", dishid='" + dishid + '\'' +
                '}';
    }
}
