package com.yummy.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Gp
 * @email 13767654524@163.com
 * @create 2020/9/5 15:50
 */
public class DataSourceUtilByXSR {

    private static DataSource dataSource;

    // 每条连接为线程私有, 在关闭连接时请务必调用其 remove 方法
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    static {
        dataSource = new ComboPooledDataSource();
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
