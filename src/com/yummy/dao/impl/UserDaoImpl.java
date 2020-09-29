package com.yummy.dao.impl;

import com.yummy.dao.UserDao;
import com.yummy.entity.Users;
import com.yummy.util.DataSourceUtilByXSR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Gp
 * @email 13767654524@163.com
 * @create 2020/9/7 9:16
 */
public class UserDaoImpl implements UserDao {

    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    //public volatile static UserDaoImpl userDao;
    /*private volatile static UserDaoImpl instance;

    private UserDaoImpl() {
        instance = BeanFactory.getInstance("userdao");
    }

    public static UserDao getInstance() {
        if (instance == null) {
            synchronized (UserDaoImpl.class) {
                if (instance == null) {
                    instance = new UserDaoImpl();
                }
            }
        }
        return instance;
    }*/
    private void setNull() {
        if (connection != null) {
            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean registerCheck(String phone){
        try{
            connection = DataSourceUtilByXSR.getConnection();
            pstmt = connection.prepareStatement("select phone from users where phone=?");
            pstmt.setString(1,phone);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return false;
            }
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            //函数调用完毕务必使用方法释放
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }
    @Override
    public Users login(String phone, String password) {
        connection = DataSourceUtilByXSR.getConnection();
        String sql = "select * from users where phone=?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, phone);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String pwd = rs.getString("password");
                if (password.equals(pwd)){
                    Users user = new Users();
                    user.setPhone(rs.getString("phone"));
                    user.setPassword(password);
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setAdmin(rs.getString("admin"));
                    user.setPaypswd(rs.getString("paypswd"));
                    return user;
                }
            }
            return null;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            // 请务必在每次连接释放前调用此方法
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }

    @Override
    public boolean register(Users user) {
        connection = DataSourceUtilByXSR.getConnection();
        String sql = "insert into users (phone,password,name,email,paypswd) values(?,?,?,?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,user.getPhone());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getName());
            pstmt.setString(4,user.getEmail());
            pstmt.setString(5,user.getPaypswd());
            int count = pstmt.executeUpdate();
            if(count>0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return  false;
        }finally {
            // 请务必在每次连接释放前调用此方法
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
        return false;
    }

    /*@Override
    public boolean updatePassword(String password) {
        connection = DataSourceUtil.getConnection();
        String sql = "update users set password=?";
        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,password);
            int count = pstmt.executeUpdate();
            if(count>0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            // 请务必在每次连接释放前调用此方法
            DataSourceUtil.removeConnection();
            setNull();
        }
        return false;
    }*/
    /**
     * 更新个人信息
     * 根据前台针对性修改
     * throws SQPException
     * */
    public boolean updateMessage(Users user) {
        connection = DataSourceUtilByXSR.getConnection();
        String sql = "select * from users where phone = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,user.getPhone());
            rs = pstmt.executeQuery();
            if(rs.next()){
                Users cacheUser = new Users();
                cacheUser.setPhone(rs.getString("phone"));
                cacheUser.setPassword(user.getPassword()==null?rs.getString("password"):user.getPassword());
                cacheUser.setName(user.getName()==null?rs.getString("name"):user.getName());
                cacheUser.setEmail(user.getEmail()==null?rs.getString("email"):user.getEmail());
                cacheUser.setPaypswd(user.getPaypswd()==null?rs.getString("paypswd'"):user.getPaypswd());

                pstmt = connection.prepareStatement("update users set (password,name,email,paypswd) values (?,?,?,?)");
                pstmt.setString(1,cacheUser.getPassword());
                pstmt.setString(2,cacheUser.getName());
                pstmt.setString(3,cacheUser.getEmail());
                pstmt.setString(4,cacheUser.getPaypswd());
                int count = pstmt.executeUpdate();
                if(count>0){
                    return true;
                }
                return false;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return  false;
        }finally {
            // 请务必在每次连接释放前调用此方法
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }
}
