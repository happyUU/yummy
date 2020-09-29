package com.yummy.dao.impl;


import com.yummy.dao.IFoodDao;
import com.yummy.entity.Food;
import com.yummy.entity.Hall;
import com.yummy.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

;

public class FoodDaoImpl implements IFoodDao {
    private QueryRunner qr = new QueryRunner(DBUtil.getDs());


    public List<Food> findAllFoods() {
        String select_sql = "select *  from dishtype";
        List<Food> foods = null;

        try {
            foods = qr.query(select_sql, new BeanListHandler<Food>(Food.class));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    public List<Food> findByTypeName(String foodName) {
        String select_sql = "select *  from dishtype where typename=?";
        List<Food> foods = null;

        try {
            foods = qr.query(select_sql, new BeanListHandler<Food>(Food.class),foodName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    public Food findById(String foodid) {
        String select_sql = "select *  from dishoper where dishid=?";
        Food food = null;

        try {
            food = qr.query(select_sql, new BeanHandler<Food>(Food.class),foodid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return food;
    }



    public List<Hall> findAllHalls() {
        String select_sql = "select *  from hall";
        List<Hall> halls = null;

        try {
            halls = qr.query(select_sql, new BeanListHandler<Hall>(Hall.class));
            /*for (Hall hall:halls) {
                System.out.println(hall);
            }*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return halls;
    }

    public List<Hall> findByHalllName(String hallName) {
        String select_sql = "select *  from hall where name=?";
        List<Hall> halls = null;

        try {
            halls = qr.query(select_sql, new BeanListHandler<Hall>(Hall.class),hallName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return halls;
    }

    public List<Hall> findByHallId(String hallid) {
        String select_sql = "select *  from hallid where hallid=?";
        List<Hall> hall = null;

        try {
            hall = qr.query(select_sql, new BeanListHandler<Hall>(Hall.class),hallid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hall;
    }

    public Hall findHallByHallId(String hallid){
        String select_sql = "select *  from hall where hallid=?";
        Hall hall = null;

        try {
            hall = qr.query(select_sql, new BeanHandler<Hall>(Hall.class),hallid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hall;
    }


}
