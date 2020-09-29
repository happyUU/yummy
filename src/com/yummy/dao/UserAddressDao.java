package com.yummy.dao;

import com.yummy.entity.UserAddress;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-17 8:25
 */
public interface UserAddressDao {

    List<UserAddress> listUserAddressByUserId(String userId);

    UserAddress getUserAddressById(String id);

    int updateUserAddress(UserAddress userAddress);

    int deleteUserAddressById(String id);

    int deleteUserAddressByUserId(String userId);

    int saveUserAddress(UserAddress userAddress);

    int countUserAddressByUserId(String userId);

    List<UserAddress> listUserAddressForPageByUserId(int begin, int pageSize, String userId);

}
