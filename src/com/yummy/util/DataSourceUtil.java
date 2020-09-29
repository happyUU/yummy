package com.yummy.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Gp
 * @email 13767654524@163.com
 * @create 2020/9/5 15:50
 */
public class DataSourceUtil {

    private static DataSource dataSource;

    // 每条连接为线程私有, 在关闭连接时请务必调用其 remove 方法
    private static final ThreadLocal<Connection> tl = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = DataSourceUtil.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (tl.get() == null) {
            try {
                tl.set(dataSource.getConnection());
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tl.get();
    }

    public static void removeConnection() {
        tl.remove();
    }

}
