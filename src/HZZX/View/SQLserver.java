package HZZX.View;

import sun.applet.Main;

import javax.swing.*;
import java.sql.*;


/*
采用单例模式
 */

public class SQLserver {

    Connection ct;
    PreparedStatement ps;
    ResultSet rs;
    String user, pwd, pow;


    String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=HZZX";
    String USERNAME = "wyf";
    String PASSWORD = "123456";

    String name;

    /*
     * 将此类设置为单例模式。
     * 1、私有化构造函数
     * 2、创建对象
     * 3、设置一个用来获取实例的public方法。
     */
    private SQLserver() {

    }

    private static final SQLserver ss = new SQLserver();

    public static SQLserver getInstance() {
        return ss;

    }

    //将连接数据库的方法封装为一个方法
    public void ConnectSQL() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //加载驱动

            ct = DriverManager.getConnection(URL, USERNAME, PASSWORD); //得到连接

            System.out.println("已成功连接数据库...");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //注册用户的方法
    public void UserRegis(String a, String b) {
        try {
            ps = ct.prepareStatement("insert into Operator values(?,?)");
            ps.setString(1, a);
            ps.setString(2, b);

            //执行
            int i = ps.executeUpdate();
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "注册成功", "提示消息", JOptionPane.WARNING_MESSAGE);
                System.out.println("注册成功");
            } else {
                JOptionPane.showMessageDialog(null, "注册失败", "提示消息", JOptionPane.ERROR_MESSAGE);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //	登录验证方法
    public void SQLverify1(String a, String b) {
        try {
            ps = ct.prepareStatement("select * from Operator where Sacc=? and Spwd=?");
            ps.setString(1, a);
            ps.setString(2, b);

            // ResultSet结果集,把ResultSet理解成返回一张表行的结果集
            rs = ps.executeQuery();

            if (rs.next()) {
                user = rs.getString(1);
                pwd = rs.getString(2);
                JOptionPane.showMessageDialog(null, "登录成功！！！", "提示消息", JOptionPane.WARNING_MESSAGE);
//                System.out.println("成功获取到密码和用户名");
//                System.out.println(user + "\t" + pwd + "\t");
                System.out.println("登录成功");
            } else {
                JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重新输入！", "提示消息", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    //	登录验证方法
    public void SQLverify2(String a, String b) {
        try {
            ps = ct.prepareStatement("select * from Operator where Sacc=? and Spwd=?");
            ps.setString(1, a);
            ps.setString(2, b);

            // ResultSet结果集,把ResultSet理解成返回一张表行的结果集
            rs = ps.executeQuery();


            // ResultSet结果集,把ResultSet理解成返回一张表行的结果集
            rs = ps.executeQuery();

            if (rs.next()) {
                user = rs.getString(1);
                pwd = rs.getString(2);
                JOptionPane.showMessageDialog(null, "登录成功！！！", "提示消息", JOptionPane.WARNING_MESSAGE);
//                System.out.println("成功获取到密码和用户名");
//                System.out.println(user + "\t" + pwd + "\t");
                System.out.println("登录成功");
            } else {
                JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重新输入！", "提示消息", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    //注册验证方法，判断用户名是否已经存在
    public void ZhuceVerify1(String a) {
        try {
            ps = ct.prepareStatement("select * from Operator where Sacc=?");
            ps.setString(1, a);

            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "该用户名已经存在", "提示信息", JOptionPane.WARNING_MESSAGE);
            } else {
                this.UserRegis(RegisterView.jtf1.getText(), RegisterView.jtf2.getText());
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    //注册验证方法，判断用户名是否已经存在
    public void ZhuceVerify2(String a) {
        try {
            ps = ct.prepareStatement("select * from Operator where Sacc=?");
            ps.setString(1, a);

            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "该用户名已经存在", "提示信息", JOptionPane.WARNING_MESSAGE);
            } else {
                this.UserRegis(RegisterView.jtf1.getText(), RegisterView.jtf2.getText());
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}