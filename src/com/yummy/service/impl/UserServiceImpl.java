package com.yummy.service.impl;

import com.yummy.dao.UserDao;
import com.yummy.dao.impl.UserDaoImpl;
import com.yummy.entity.Users;
import com.yummy.factory.BeanFactory;
import com.yummy.service.UserService;

/**
 * @author Gp
 * @email 13767654524@163.com
 * @create 2020/9/5 15:34
 */
public class UserServiceImpl implements UserService {

    //public volatile static UserService userService;
    private UserDao userDao;

    public UserServiceImpl(){
        userDao = BeanFactory.getInstance("userdao");
    }
    /*private UserServiceImpl() {
        userDao = UserDaoImpl.getInstance();

        userService = BeanFactory.getInstance("userService");
    }*/
    /*public static UserService getUserService() {
        if (userService == null) {
            synchronized (UserServiceImpl.class) {
                if (userService == null) {
                    userService = new UserServiceImpl();
                }
            }
        }
        return userService;
    }*/

    @Override
    public Users login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public boolean registerCheck(String phone) {
        return userDao.registerCheck(phone);
    }

    @Override
    public boolean register(Users user) {
        return userDao.register(user);
    }

    @Override
    public boolean update(Users user) {
        return userDao.updateMessage(user);
    }
}
