package com.yummy.service.impl;

import com.yummy.dao.AdminDao;
import com.yummy.entity.Users;
import com.yummy.factory.BeanFactory;
import com.yummy.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService{
    private AdminDao adminDao;
    public AdminServiceImpl(){
        adminDao = BeanFactory.getInstance("adminDao");
    }

    /**
     * admin login
     * @param phone
     * @param password
     * @return
     */
    @Override
    public Users login(String phone, String password) {
        return adminDao.Login(phone,password);
    }

    /**
     * admin register
     * @param user
     * @return
     */
    @Override
    public Boolean register(Users user) {
        return adminDao.register(user);
    }

    /**
     * admin update
     * @param user
     * @return
     */
    @Override
    public boolean updateMess(Users user) {
        return adminDao.updateMess(user);
    }

    /**
     *
     * @param admin
     * @return
     */
    @Override
    public List<Users> adminQueryAllUsers(String admin) {
        return adminDao.queryAllUsers(admin);
    }

    /**
     *
     * @param phone
     * @return
     */
    @Override
    public boolean deleteUser(String phone) {
        return adminDao.deleteUser(phone);
    }

    /**
     *
     * @param strings
     * @return
     */
    @Override
    public boolean deleteAllUsers(String[] strings) {
        return adminDao.deleteAllUsers(strings);
    }
}
