import java.sql.*;

public class MyDBConnection {
    public static void main(String[] args) {

        String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=HZZX";
        String USERNAME = "wyf";
        String PASSWORD = "123456";
        Statement st = null;
        Connection conn = null;
        ResultSet rs;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
