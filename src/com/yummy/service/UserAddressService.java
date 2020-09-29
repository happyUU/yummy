package com.yummy.service;

import com.yummy.entity.Page;
import com.yummy.entity.UserAddress;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-17 9:19
 */
public interface UserAddressService {
    Page<UserAddress> page(int pageNow, int pageSize, String userId);

    UserAddress getUserAddressById(String id);

    int updateUserAddress(UserAddress userAddress);

    int deleteUserAddressById(String id);

    int saveUserAddress(UserAddress userAddress);

    int deleteUserAddressByUserId(String userId);

}
