package com.yummy.dao;

import com.yummy.entity.Users;

import java.util.List;

/**
 * @author xsr
 * @email 2974112544
 * admin entity
 */
public interface AdminDao{
    /**
     * admin login
     * @param phone
     * @param password
     */
    default Users Login(String phone,String password){
        return null;
    }

    /**
     * admin register
     * @param user
     * @return
     */
    default boolean register(Users user){
        return false;
    }

    /**
     *
     * @param user
     * @return
     */
    default boolean updateMess(Users user){
        return false;
    }

    /**
     *
     * @param admin
     * @return
     */
    default List<Users> queryAllUsers(String admin){
        return null;
    }
    /**
     *
     * @param phone
     * @return
     */
    default boolean deleteUser(String phone){
        return false;
    }
    default boolean deleteAllUsers(String[] strings){
        return false;
    }
}
