package HZZX.View;

import HZZX.bean.MeetingInformation;
import HZZX.manager.place.UpdatePlace;
import HZZX.utils.DatabaseConnection;
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
    String user, pwd;

    String a,b,c,d,ee,f;

    public SQLserver() {}

    //注册用户的方法
    public void UserRegis(String a, String b) {
        try {
            ct = DatabaseConnection.getConnection();
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

    //	管理员登录验证方法
    public void SQLverify1(String a, String b) {
        try {
            ct = DatabaseConnection.getConnection();
            ps = ct.prepareStatement("select * from Operator where Sacc=? and Spwd=?");
            ps.setString(1, a);
            ps.setString(2, b);

            // ResultSet结果集,把ResultSet理解成返回一张表行的结果集
            rs = ps.executeQuery();

            if (rs.next()) {
                user = rs.getString(1);
                pwd = rs.getString(2);
                JOptionPane.showMessageDialog(null, "登录成功！！！", "提示消息", JOptionPane.WARNING_MESSAGE);
                System.out.println("登录成功");
                new ManagerMain();
                MainView m = new MainView();
                m.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    //	客户登录验证方法
    public void SQLverify2(String a, String b) {
        try {
            ct = DatabaseConnection.getConnection();
            ps = ct.prepareStatement("select * from Operator where Sacc=? and Spwd=?");
            ps.setString(1, a);
            ps.setString(2, b);

            // ResultSet结果集,把ResultSet理解成返回一张表行的结果集
            rs = ps.executeQuery();

            if (rs.next()) {
                user = rs.getString(1);
                pwd = rs.getString(2);
                JOptionPane.showMessageDialog(null, "登录成功！！！", "提示消息", JOptionPane.WARNING_MESSAGE);
                System.out.println("登录成功");
                new Customer();
                MainView m = new MainView();
                m.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    //注册验证方法，判断用户名是否已经存在
    public void ZhuceVerify1(String a) {
        try {
            ct = DatabaseConnection.getConnection();
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