package com.yummy.service;

import com.yummy.entity.Users;

/**
 * @author Gp
 * @email 13767654524@163.com
 * @create 2020/9/5 15:31
 */
public interface UserService {

    /**
     * 登录验证, 否则没有权限访问
     * @param username
     * @param password
     * @return
     */
    default Users login(String username, String password){return null;}
    /**
     * 注册前验证
     * @param phone
     * @return
     */
    default boolean registerCheck(String phone){return false;}
    /**
     * 注册
     * @param user
     * @return
     * */
    default boolean register(Users user){return false;}
    /**
     * 信息更新
     * @param user
     * @return
     */
    default boolean update(Users user){return false;}
}
