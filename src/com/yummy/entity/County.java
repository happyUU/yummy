package com.yummy.entity;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-18 9:36
 */
public class County{
    private String id;
    private String name;
    private String cityId;

    public County() {
    }

    @Override
    public String toString() {
        return "County{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cityId='" + cityId + '\'' +
                '}';
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

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public County(String id, String name, String cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }
}
