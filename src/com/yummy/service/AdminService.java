package com.yummy.service;

import com.yummy.entity.Dish;
import com.yummy.entity.Users;

import java.util.List;

/**
 * @author xsr
 * @email 2974112544
 * admin
 * */
public interface AdminService{
    /**
     * admin login
     * @param phone
     * @param password
     * return
     */
    default Users login(String phone,String password){
        return null;
    }
    /**
     * admin register
     * @param user
     * return
     *
     */
    default Boolean register(Users user){
        return false;
    }
    /**
     * admin updateMessage
     * @param user
     * return
     */
    default boolean updateMess(Users user){
        return false;
    }
    /**
     * admin queryAllUsers
     * @param admin
     * return
     */
    default List<Users> adminQueryAllUsers(String admin){
        return null;
    }
    /**
     * admin deleteUsers
     * @param phone
     * return
     */
    default boolean deleteUser(String phone){
        return false;
    }

    /**
     *
     * @param strings
     * @return
     */
    default boolean deleteAllUsers(String[] strings){
        return false;
    }
}
