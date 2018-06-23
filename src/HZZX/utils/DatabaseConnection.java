package HZZX.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/*
将数据库连接封装
 */
public class DatabaseConnection {

    private static Connection conn = null;

    public static Connection getConnection() {
        try {

            String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=HZZX";
            String USERNAME = "wyf";
            String PASSWORD = "123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //加载驱动
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); //得到连接

            System.out.println("已成功连接数据库...");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}