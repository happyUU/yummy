package com.yummy.entity;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-14 12:44
 */
public class UserAddress {
    private String addressId;
    private String recName;
    private String recPhone;
    private Province province;
    private City city;
    private County county;
    private String detailAddress;

    @Override
    public String toString() {
        return "UserAddress{" +
                "addressId='" + addressId + '\'' +
                ", recName='" + recName + '\'' +
                ", recPhone='" + recPhone + '\'' +
                ", province=" + province +
                ", city=" + city +
                ", county=" + county +
                ", detailAddress='" + detailAddress + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getAddrString(){
        StringBuilder addrSb = new StringBuilder();
        addrSb.append(this.province.getName()).append(" ");
        addrSb.append(this.city.getName()).append(" ");
        addrSb.append(this.county.getName()).append(" ");
        addrSb.append(this.detailAddress);
        return addrSb.toString();
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    private String userId;

    public UserAddress() {
    }

    public UserAddress(String recName, String recPhone, Province province, City city, County county, String detailAddress, String userId) {
        this.recName = recName;
        this.recPhone = recPhone;
        this.province = province;
        this.city = city;
        this.county = county;
        this.detailAddress = detailAddress;
        this.userId = userId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public String getRecPhone() {
        return recPhone;
    }

    public void setRecPhone(String recPhone) {
        this.recPhone = recPhone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
