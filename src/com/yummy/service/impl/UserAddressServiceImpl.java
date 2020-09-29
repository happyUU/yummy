package com.yummy.service.impl;

import com.yummy.dao.UserAddressDao;
import com.yummy.dao.impl.UserAddressDaoImpl;
import com.yummy.entity.District;
import com.yummy.entity.Page;
import com.yummy.entity.UserAddress;
import com.yummy.service.UserAddressService;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-17 9:19
 */
public class UserAddressServiceImpl implements UserAddressService {

    private final UserAddressDao userAddressDao = new UserAddressDaoImpl();

    @Override
    public Page<UserAddress> page(int pageNow, int pageSize, String userId) {
        Page<UserAddress> page = new Page<>();
        page.setPageSize(pageSize);

        int countItems = userAddressDao.countUserAddressByUserId(userId);
        page.setItemCount(countItems);
        page.setPageNow(pageNow);

        int begin = (page.getPageNow() - 1) * pageSize;
        List<UserAddress> userAddresses = userAddressDao.listUserAddressForPageByUserId(begin, pageSize, userId);
        page.setItems(userAddresses);

        page.setUrl("");

        return page;
    }

    @Override
    public UserAddress getUserAddressById(String id) {
        UserAddress userAddress = userAddressDao.getUserAddressById(id);
        District district = District.getInstance();

        return userAddress;
    }

    @Override
    public int updateUserAddress(UserAddress userAddress) {
        return userAddressDao.updateUserAddress(userAddress);
    }

    @Override
    public int deleteUserAddressById(String id) {
        return userAddressDao.deleteUserAddressById(id);
    }

    @Override
    public int saveUserAddress(UserAddress userAddress) {
        String timeStr = System.currentTimeMillis() + "";
        String id = timeStr.substring(timeStr.length() - 6);
        userAddress.setAddressId(id);
        return userAddressDao.saveUserAddress(userAddress);
    }

    @Override
    public int deleteUserAddressByUserId(String userId) {
        return userAddressDao.deleteUserAddressByUserId(userId);
    }
}
