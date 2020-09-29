package com.yummy.util;



import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {

  private static DataSource ds=new ComboPooledDataSource();
    public static Connection getConn(){
        try {
            return  ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static DataSource getDs(){
        return  ds;
    }

}
