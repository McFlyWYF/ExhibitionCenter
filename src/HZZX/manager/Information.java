package HZZX.manager;

import HZZX.View.MainView;
import HZZX.informationManager.InsertInformations;
import HZZX.utils.Facade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Information extends JFrame implements ActionListener {

    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8 = null;
    JButton jb1, jb2, jb3 = null;
    Facade fcd = new Facade();
    PreparedStatement ps;
    Connection ct;
    ResultSet rs;


    String m_id, m_ame, b_id, t_id, t_name, address, time, kind;


    public Information() {

        jb1 = new JButton("查询");
        jb2 = new JButton("发布会展信息");
        jb3 = new JButton("返回");

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        jp1 = new JPanel();

        jp1.add(jb1);
        jp1.add(jb2);
        jp1.add(jb3);

        this.add(jp1);

        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(300, 200, 600, 380);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回") {
            this.dispose();
            new MainView();
        } else if (e.getActionCommand() == "查询") {
            //fcd.ConnectSQL();
            //insertInformations();
        } else if (e.getActionCommand() == "发布会展信息") {
            this.dispose();
            new InsertInformations();
        }
    }

//    //查询方法
//    public void insertInformations(String a, String b, String c, String d, String e, String f, String g, String h) {
//        try {
//            ps = ct.prepareStatement("select * from Meeting");
//            ps.setString(1, a);
//            ps.setString(2, b);
//            ps.setString(3, c);
//            ps.setString(4, d);
//            ps.setString(5, e);
//            ps.setString(6, f);
//            ps.setString(7, g);
//            ps.setString(8, h);
//
//            rs = ps.executeQuery();
//
//            if (rs.next()) {
//                m_id = rs.getString(1);
//                m_ame = rs.getString(1);
//                b_id = rs.getString(1);
//                t_id = rs.getString(1);
//                t_name = rs.getString(1);
//                address = rs.getString(1);
//                time = rs.getString(1);
//                kind = rs.getString(1);
//                JOptionPane.showMessageDialog(null, "查询成功!!!", "提示消息", JOptionPane.WARNING_MESSAGE);
//                System.out.println("查询成功");
//            } else {
//                JOptionPane.showMessageDialog(null, "查询失败!!!", "提示消息", JOptionPane.WARNING_MESSAGE);
//            }
//        } catch (SQLException ee) {
//            ee.printStackTrace();
//        }
//    }
}
