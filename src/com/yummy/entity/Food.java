package com.yummy.entity;

public class Food {
    private String firstbelong;
    private String dishid;
    private String typename;
    private String disname;
    private String disprice;
    private String dispic;
    private String describe;
    private String oper;
    public Food() {
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
        return "Food{" +
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
