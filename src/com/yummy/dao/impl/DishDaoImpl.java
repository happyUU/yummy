package com.yummy.dao.impl;

import com.yummy.dao.DishDao;
import com.yummy.entity.Dish;
import com.yummy.factory.BeanFactory;
import com.yummy.util.DataSourceUtilByXSR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDaoImpl implements DishDao{
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet res = null;

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

    @Override
    public boolean addDish(Dish dish) {
        String sql = "insert into dishType (firstbelong,dishid,typename,dishname,dishprice,dishpic,dishdescribe) values(?,?,?,?,?,?,?)";
        try{
            con = DataSourceUtilByXSR.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,dish.getFirstbelong());
            pstmt.setString(2,dish.getDishid());
            pstmt.setString(3,dish.getTypename());
            pstmt.setString(4,dish.getDisname());
            pstmt.setString(5,dish.getDisprice());
            pstmt.setString(6,dish.getDispic());
            pstmt.setString(7,dish.getDescribe());
            int count = pstmt.executeUpdate();
            if(count>0){
                return true;
            }
            return false;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            //完成务必调用方法关闭线程
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }

    @Override
    public boolean subDish(String id) {
        String sql = "delete dishType where dishid=?";
        try{
            con = DataSourceUtilByXSR.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,id);
            int count = pstmt.executeUpdate();
            if(count>0){
                return true;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            //执行完毕务必先调用方法释放
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }

    @Override
    public boolean updateDish(Dish dish) {
        String sql = "update dishType set dishname=?,dishprice=?,dispic=?,dishdescribe=?";
        try {
            con = DataSourceUtilByXSR.getConnection();
            pstmt = con.prepareStatement("select dishname,dishprice,dishpic,dishdescribe from dishType where dishid=?");
            pstmt.setString(1, dish.getDishid());
            res = pstmt.executeQuery();
            if (res.next()) {
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, dish.getDisname() == null ? res.getString("disname") : dish.getDisname());
                pstmt.setString(2, dish.getDisprice() == null ? res.getString("dishprice") : dish.getDisprice());
                pstmt.setString(3, dish.getDispic() == null ? res.getString("dispic") : dish.getDispic());
                pstmt.setString(4, dish.getDescribe() == null ? res.getString("derscribe") : dish.getDescribe());

                int count = pstmt.executeUpdate();
                if (count > 0) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            //执行完毕务必先调用方法释放
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }
    @Override
    public Dish selectDish(String id) {
        String sql = "select * from dishType where dishid=?";
        Dish dish = new Dish();
        try{
            con = DataSourceUtilByXSR.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,id);
            res = pstmt.executeQuery();
            if(res.next()){
                dish.setFirstbelong(res.getString("firstbelong"));
                dish.setDishid(res.getString("dishid"));
                dish.setTypename(res.getString("typename"));
                dish.setDisname(res.getString("disname"));
                //dish.setDisprice(res.getString("dishprice"));
                dish.setDispic(res.getString("dispic"));
                dish.setDescribe(res.getString("describe"));
                return dish;
            }
            return null;
        }catch (SQLException e){
            e.printStackTrace();
            return dish;
        }finally {
            //执行完毕务必先调用方法释放
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }

    @Override
    public List<Dish> selectMultipleDish(String name) {
        String sql = "select * from dishtype where typename=?";
        List<Dish> list = new ArrayList<Dish>();

        try {
            con = DataSourceUtilByXSR.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,name);
            res = pstmt.executeQuery();
            while (res.next()){
                Dish dish = new Dish();
                dish.setFirstbelong(res.getString("firstbelong"));
                dish.setDishid(res.getString("dishid"));
                dish.setTypename(res.getString("typename"));
                dish.setDisname(res.getString("disname"));
                //dish.setDisprice(res.getString("dishprice"));
                dish.setDispic(res.getString("dispic"));
                dish.setDescribe(res.getString("describe"));
                list.add(dish);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            //执行完毕务必先调用方法释放
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }

    @Override
    public List<Dish> selectAllDish() {
        String sql = "select * from dishtype ";
        List<Dish> list = new ArrayList<Dish>();

        try {
            con = DataSourceUtilByXSR.getConnection();
            pstmt = con.prepareStatement(sql);
            res = pstmt.executeQuery();
            while (res.next()){
                Dish dish = new Dish();
                dish.setFirstbelong(res.getString("firstbelong"));
                dish.setDishid(res.getString("dishid"));
                dish.setTypename(res.getString("typename"));
                dish.setDisname(res.getString("disname"));
                //dish.setDisprice(res.getString("dishprice"));
                dish.setDispic(res.getString("dispic"));
                dish.setDescribe(res.getString("describe"));
                list.add(dish);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            //执行完毕务必先调用方法释放
            DataSourceUtilByXSR.removeConnection();
            setNull();
        }
    }

    @Override
    public boolean deleteAllCheck(String[] dish) {
        String sql = "delete from dishtype where dishid=?";
        boolean flag = true;
        try{
            con = DataSourceUtilByXSR.getConnection();
            pstmt = con.prepareStatement(sql);
            for(int i=0;i<dish.length;i++){
                pstmt.setString(1,dish[i]);
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
    /* public static void main(String[] args) {
        DishDaoImpl dishDao = new DishDaoImpl();
        *//*Dish dish = dishDao.selectDish("10000");
        System.out.println(dish);
        String jsonObject = JSONObject.fromObject(dish).toString();
        System.out.println(jsonObject);*//*
        //List<Dish> list = dishDao.selectAllDish();
        //List<Dish> list = dishDao.selectMultipleDish("川菜");
        Dish dish = dishDao.selectDish("chuan01");

        //System.out.println(list);
        System.out.println(dish);
    }*/
}
