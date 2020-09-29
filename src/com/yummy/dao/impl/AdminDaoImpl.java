package com.yummy.dao.impl;

import com.yummy.dao.AdminDao;
import com.yummy.entity.Users;
import com.yummy.util.DataSourceUtilByXSR;
import net.sf.json.JSONArray;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xsr
 * @email 2974112544
 * @createTime 2020/9/19 10:06
 */
public class AdminDaoImpl implements AdminDao{
    private Connection con = null;
    private PreparedStatement pstmt;
    private ResultSet res;

    /**
     * close function
     */
    private void setNull() {
        if (con != null) {
            try {
                con.close();
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
        if (res != null) {
            try {
                res.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * login
     * @param phone
     * @param password
     * @return
     */
    @Override
    public Users Login(String phone, String password) {
        String sql = "select * from users where phone=?";
        try{
            con = DataSourceUtilByXSR.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,phone);
            res = pstmt.executeQuery();
            if(res.next()){
                if(password.equals(res.getString("password"))){
                    Users user = new Users();
                    user.setPhone(res.getString("phone"));
                    user.setPassword(password);
                    user.setName(res.getString("name"));
                    user.setEmail(res.getString("email"));
                    user.setAdmin(res.getString("admin"));
                    user.setPaypswd(res.getString("paypswd"));
                    return user;
                }
            }
            return null;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }

    /**
     * 管理员注册界面
     * @param user
     * @return
     */
    @Override
    public boolean register(Users user) {
        String sql = "insert into users(phone,password,name,email,admin,paypswd) values(?,?,?,?,?,?)";
        try {
            con = DataSourceUtilByXSR.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,user.getPhone());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getName());
            pstmt.setString(4,user.getEmail());
            pstmt.setString(5,user.getAdmin());
            pstmt.setString(6,user.getPaypswd());
            int count = pstmt.executeUpdate();
            if(count>0){
                return true;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            //方法结束后务必调用方法释放线程
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }

    /**
     * admin updateMess ,the same as users
     * @param user
     * @return
     */
    @Override
    public boolean updateMess(Users user) {
        String sql = "select * from users where phone = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,user.getPhone());
            res = pstmt.executeQuery();
            if(res.next()){
                Users cacheUser = new Users();
                cacheUser.setPhone(res.getString("phone"));
                cacheUser.setPassword(user.getPassword()==null?res.getString("password"):user.getPassword());
                cacheUser.setName(user.getName()==null?res.getString("name"):user.getName());
                cacheUser.setEmail(user.getEmail()==null?res.getString("email"):user.getEmail());
                cacheUser.setPaypswd(user.getPaypswd()==null?res.getString("paypswd'"):user.getPaypswd());

                pstmt = con.prepareStatement("update users set (password,name,email,paypswd) values (?,?,?,?)");
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

    @Override
    public List<Users> queryAllUsers(String admin) {
        String sql = "select * from users where admin<?";
        List<Users> list = new ArrayList<>();
        try{
            con = DataSourceUtilByXSR.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,admin);
            res = pstmt.executeQuery();
            while(res.next()){
                Users user = new Users();
                user.setPhone(res.getString("phone"));
                user.setPassword(res.getString("password"));
                user.setName(res.getString("name"));
                user.setEmail(res.getString("email"));
                user.setAdmin(res.getString("admin"));
                user.setPaypswd(res.getString("paypswd"));
                //System.out.println(user);
                list.add(user);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            // 请务必在每次连接释放前调用此方法
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }

    @Override
    public boolean deleteUser(String phone) {
        String sql = "delete from users where phone=?";
        try{
            con = DataSourceUtilByXSR.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,phone);
            int count = pstmt.executeUpdate();
            if(count>0){
                return true;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            // 请务必在每次连接释放前调用此方法
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }

    @Override
    public boolean deleteAllUsers(String[] phones) {
        String sql = "delete from users where phone=?";
        boolean flag = true;
        try{
            con = DataSourceUtilByXSR.getConnection();
            pstmt = con.prepareStatement(sql);
            for(int i=0;i<phones.length;i++){
                pstmt.setString(1,phones[i]);
                pstmt.addBatch();
            }
            int[] count = pstmt.executeBatch();
            for(int i=0;i<count.length;i++){
                if(count[i]<=0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("删除成功");
                return true;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            // 请务必在每次连接释放前调用此方法
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }
}
