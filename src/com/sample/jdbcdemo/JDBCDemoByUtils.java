package com.sample.jdbcdemo;

/**
 * @Auther:Yue
 * @Date:2019/11/19
 * @Description:com.sample.jdbcdemo
 * @version:1.0
 */

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 通过JDBC工具类进行增删改查操作
 * @author ShiXiaoyu
 *
 */
public class JDBCDemoByUtils {

    private static String sqlStatement;

    public static void main(String[] args) throws Exception {
        //通过工具类获取数据库连接对象
        Connection con = JDBCUtils.getConnection();
        //通过连接创建数据库执行对象
        Statement sta = con.createStatement();
        //为查询的结果集准备接收对象
        ResultSet rs = null;
        //查询
        sqlStatement = "SELECT * FROM sample_user_user";


        qry(sta, sqlStatement, rs);
        //增加
        sqlStatement = "INSERT INTO sample_user_user(user_name,user_password,user_email) VALUES('小三','123','865082441@qq.com')";
        System.out.println("新增执行结果:"+update(sta,sqlStatement)+" 新增成功");
        //修改
        sqlStatement="UPDATE sample_user_user SET user_name='修改后danclan' WHERE id = '1'";
        System.out.println("修改执行结果:"+update(sta,sqlStatement)+" 修改成功");
        //删除
        sqlStatement = "DELETE FROM sample_user_user WHERE id = '6'";
        System.out.println("删除执行结果:"+update(sta,sqlStatement)+" 删除成功");

        JDBCUtils.closeResource(rs, sta, con);
    }

    /**
     * 查询
     * @param sta
     * @param sql
     * @param rs
     * @throws SQLException
     */
    private static void qry(Statement sta, String sql, ResultSet rs) throws SQLException {
        rs = sta.executeQuery(sql);
        System.out.println("数据库查询功能:");
        while (rs.next()) {
            System.out.print("用户id:"+rs.getObject("id")+" ");
            System.out.print("用户名："+rs.getObject("user_name")+" ");
            System.out.print("密码:"+rs.getObject("user_password")+" ");
            System.out.println("邮箱:"+rs.getObject("user_email")+" ");

        }
    }

    /**
     * 增加
     * 删除
     * 修改
     *
     * @param sta
     * @param sql
     * @return
     * @throws SQLException
     */
    private static int update(Statement sta, String sql) throws SQLException {
        return sta.executeUpdate(sql);
    }
}
