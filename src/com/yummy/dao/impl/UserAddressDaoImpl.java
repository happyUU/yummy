package com.yummy.dao.impl;

import com.yummy.dao.UserAddressDao;
import com.yummy.entity.District;
import com.yummy.entity.UserAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-17 8:26
 */
public class UserAddressDaoImpl extends BaseDao implements UserAddressDao {
    @Override
    public List<UserAddress> listUserAddressByUserId(String userId) {
        String sql = "SELECT `id` `addressId`,`rec_name` `recName`,`rec_phone` `recPhone`,`addr_province_id` `provinceId`" +
                ",`addr_city_id` `cityId`,`addr_county_id` `countyId`,`addr_detail` `detailAddress`,`user_id` `userId` " +
                "FROM `tb_rec_address` WHERE `user_id`=?";
        List<UserAddress> userAddressList = new ArrayList<>();
        List<Map<String, Object>> valMap = listValMap(sql, userId);
        for (Map<String, Object> map : valMap) {
            UserAddress userAddress = castValMapToUserAddress(map);
            userAddressList.add(userAddress);
        }

        return userAddressList;
    }

    @Override
    public UserAddress getUserAddressById(String id) {
        String sql = "SELECT `id` `addressId`,`rec_name` `recName`,`rec_phone` `recPhone`,`addr_province_id` `provinceId`" +
                ",`addr_city_id` `cityId`,`addr_county_id` `countyId`,`addr_detail` `detailAddress`,`user_id` `userId` " +
                "FROM `tb_rec_address` WHERE `id`=?";
        Map<String, Object> valMap = getValueMap(sql, id);

        return castValMapToUserAddress(valMap);
    }

    private UserAddress castValMapToUserAddress(Map<String, Object> valMap){
        UserAddress userAddress = new UserAddress();
        District district = District.getInstance();
        userAddress.setAddressId((String) valMap.get("addressId"));
        userAddress.setRecName((String) valMap.get("recName"));
        userAddress.setRecPhone((String) valMap.get("recPhone"));
        userAddress.setUserId((String) valMap.get("userId"));
        userAddress.setDetailAddress((String) valMap.get("detailAddress"));
        userAddress.setProvince(district.getProvinces().get(valMap.get("provinceId")));
        userAddress.setCity(district.getCitiesByProvinceId(String.valueOf(valMap.get("provinceId"))).get(valMap.get("cityId")));
        userAddress.setCounty(district.getCountiesByCityId(String.valueOf(valMap.get("cityId"))).get(valMap.get("countyId")));
        return userAddress;
    }

    @Override
    public int updateUserAddress(UserAddress userAddress) {
        String sql = "UPDATE `tb_rec_address` SET `rec_name`=?,`rec_phone`=?,`addr_province_id`=?," +
                "`addr_city_id`=?,`addr_county_id`=?,`addr_detail`=? WHERE `id`=?";
        return update(sql, userAddress.getRecName(), userAddress.getRecPhone(),userAddress.getProvince().getId(),
                userAddress.getCity().getId(),userAddress.getCounty().getId(), userAddress.getDetailAddress(), userAddress.getAddressId());
    }

    @Override
    public int deleteUserAddressById(String id) {
        String sql = "DELETE FROM `tb_rec_address` WHERE `id`=?";
        return update(sql, id);
    }

    @Override
    public int deleteUserAddressByUserId(String userId) {
        String sql = "DELETE FROM `tb_rec_address` WHERE `user_id`=?";
        return update(sql, userId);
    }

    @Override
    public int saveUserAddress(UserAddress userAddress) {
        String sql = "INSERT INTO `tb_rec_address`(`id`,`rec_name`,`rec_phone`,`addr_province_id`,`addr_city_id`" +
                ",`addr_county_id`,`addr_detail`,`user_id`) VALUES(?,?,?,?,?,?,?,?)";
        return update(sql, userAddress.getAddressId(), userAddress.getRecName(), userAddress.getRecPhone(),userAddress.getProvince().getId(),
                userAddress.getCity().getId(), userAddress.getCounty().getId(),userAddress.getDetailAddress(), userAddress.getUserId());
    }

    @Override
    public int countUserAddressByUserId(String userId) {
        String sql = "SELECT COUNT(*) FROM `tb_rec_address` WHERE `user_id`=?";
        Number count = (Number) getSingleValue(sql, userId);
        return count.intValue();
    }

    @Override
    public List<UserAddress> listUserAddressForPageByUserId(int begin, int pageSize, String userId) {
        String sql = "SELECT `id` `addressId`,`rec_name` `recName`,`rec_phone` `recPhone`,`addr_province_id` `provinceId`" +
                ",`addr_city_id` `cityId`,`addr_county_id` `countyId`,`addr_detail` `detailAddress`,`user_id` `userId` " +
                "FROM `tb_rec_address` WHERE `user_id`=? LIMIT ?,?";
        List<Map<String, Object>> valMap = listValMap(sql, userId, begin, pageSize);
        List<UserAddress> userAddressList = new ArrayList<>();
        for (Map<String, Object> map : valMap) {
            userAddressList.add(castValMapToUserAddress(map));
        }
        return userAddressList;
    }
}
