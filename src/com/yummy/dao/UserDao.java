package com.yummy.dao;

import com.yummy.entity.Users;

/**
 * @author Gp
 * @email 13767654524@163.com
 * @create 2020/9/7 9:15
 */

public interface UserDao {
    default Users login(String username, String password){
        return null;
    }
    default boolean registerCheck(String phone){return false;}
    default boolean register(Users user){
        return false;
    }
    /*default boolean updatePassword(String password){
        return false;
    }*/
    default boolean updateMessage(Users user){
        return false;
    }

}
