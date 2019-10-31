package apitest.utils;

import apitest.config.TestConfig;

import java.sql.*;

public class MySQLUtil {
    private static Connection Conn;
    public static Connection getConnection() {

        try {

            Class.forName(TestConfig.JDBC_DRIVER); // 加载驱动

            System.out.println("加载驱动成功!!!");
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        try {

            //通过DriverManager类的getConenction方法指定三个参数,连接数据库
            Conn = DriverManager.getConnection(TestConfig.DB_URL,TestConfig.USER,TestConfig.PASSWORD);
            System.out.println("连接数据库成功!!!");

            //返回连接对象
            return Conn;

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
}