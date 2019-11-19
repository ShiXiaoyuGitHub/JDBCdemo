package com.sample.jdbcdemo;

/**
 * @Auther:Yue
 * @Date:2019/11/19
 * @Description:PACKAGE_NAME
 * @version:1.0
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
/**
 * JDBC连接数据库和关闭资源工具类
 * @author limeng
 *
 */
public class JDBCUtils {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/sample_library?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
    private static String user = "root";
    private static String password = "123456";

    // 1. 获取驱动
    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. 创建连接
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("数据库连接成功" + conn);
        return conn;
    }

    // 3. 关闭连接
    public static void closeResource(ResultSet rs, Statement sta, Connection con) throws SQLException {
        if (rs != null) {
            rs.close();
        }

        if (sta != null) {
            sta.close();
        }

        if (con != null) {
            con.close();
        }
    }

    public static void main(String[] args) {
        try {
            getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
