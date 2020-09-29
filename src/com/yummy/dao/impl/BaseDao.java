package com.yummy.dao.impl;

import com.yummy.util.DataSourceUtilByXSR;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public abstract class BaseDao {

    QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行增删改SQL语句
     *
     * @param sql  要执行的SQL语句，可以是增加，删除，修改
     * @param args 要填充的占位符的参数
     * @return 修改的记录条数
     */
    public int update(String sql, Object... args) {
        Connection conn = DataSourceUtilByXSR.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询并获得一个bean对象
     *
     * @param type 查询获得的bean对象的Class类型
     * @param sql  查询的SQL语句
     * @param args 填充占位符的参数
     * @return 将查询结果封装成bean对象并返回
     */
    public <T> T getInstance(Class<T> type, String sql, Object... args) {
        Connection conn = DataSourceUtilByXSR.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Map<String, Object> getValueMap(String sql, Object...args){
        Connection conn = DataSourceUtilByXSR.getConnection();
        try {
            return queryRunner.query(conn, sql, new MapHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Map<String, Object>> listValMap(String sql, Object...args){
        Connection conn = DataSourceUtilByXSR.getConnection();
        try {
            return queryRunner.query(conn, sql, new MapListHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询获得多个结果并存放在List集合中
     *
     * @param type 查询获得的bean对象的Class类型
     * @param sql  查询的SQL语句
     * @param args 填充占位符的参数
     * @return 将查询结果存放在List集合中并返回
     */
    public <T> List<T> listInstances(Class<T> type, String sql, Object... args) {
        Connection conn = DataSourceUtilByXSR.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询单行单列的单个数据
     *
     * @param sql
     * @param args
     * @return
     */
    public Object getSingleValue(String sql, Object... args) {
        Connection conn = DataSourceUtilByXSR.getConnection();

        try {
            return queryRunner.query(conn, sql, new ScalarHandler<>(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
