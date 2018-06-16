package HZZX.informationManager;

import HZZX.bean.MeetingInformation;
import HZZX.manager.Information;
import HZZX.utils.DatabaseConnection;
import HZZX.utils.Facade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/*
添加会展信息
 */
public class InsertInformations extends JFrame implements ActionListener {

    JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8 = null;
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8 = null;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8 = null;
    JButton jb1, jb2;
    String m_id, m_name, b_id, t_id, t_name, address, time, kind;

    public InsertInformations() {

        jl1 = new JLabel(" 展会编号：");
        jl2 = new JLabel("    展会名称：");
        jl3 = new JLabel(" 展商编号：");
        jl4 = new JLabel("    展品编号：");
        jl5 = new JLabel(" 展品名称：");
        jl6 = new JLabel("    地址：");
        jl7 = new JLabel("时间：");
        jl8 = new JLabel("    类别：");

        jb1 = new JButton("发布");
        jb2 = new JButton("返回");

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jtf1 = new JTextField(6);
        jtf2 = new JTextField(6);
        jtf3 = new JTextField(6);
        jtf4 = new JTextField(6);
        jtf5 = new JTextField(6);
        jtf6 = new JTextField(6);
        jtf7 = new JTextField(6);
        jtf8 = new JTextField(6);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();


        jp1.add(jl1);
        jp1.add(jtf1);
        jp1.add(jl2);
        jp1.add(jtf2);

        jp2.add(jl3);
        jp2.add(jtf3);
        jp2.add(jl4);
        jp2.add(jtf4);

        jp3.add(jl5);
        jp3.add(jtf5);
        jp3.add(jl6);
        jp3.add(jtf6);

        jp4.add(jl7);
        jp4.add(jtf7);
        jp4.add(jl8);
        jp4.add(jtf8);

        jp5.add(jb1);
        jp5.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);

        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(300, 200, 600, 380);
    }


    public void insertinformation() {
        Connection con = null;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            String sql = "insert into Meeting values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            MeetingInformation mi = new MeetingInformation();

            mi.setM_id(jtf1.getText());
            mi.setM_name(jtf2.getText());
            mi.setB_id(jtf3.getText());
            mi.setT_id(jtf4.getText());
            mi.setT_name(jtf5.getText());
            mi.setAddress(jtf6.getText());
            mi.setTime(jtf7.getText());
            mi.setKind(jtf8.getText());

            m_id = jtf1.getText();
            m_name = jtf2.getText();
            b_id = jtf3.getText();
            t_id = jtf4.getText();
            t_name = jtf5.getText();
            address = jtf6.getText();
            time = jtf7.getText();
            kind = jtf8.getText();
            ps.setString(1,m_id);
            ps.setString(2, m_name);
            ps.setString(3, b_id);
            ps.setString(4, t_id);
            ps.setString(5, t_name);
            ps.setString(6, address);
            ps.setString(7, time);
            ps.setString(8, kind);
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (result == 1){
            JOptionPane.showMessageDialog(null,"插入数据成功","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("插入数据成功");
            clear();
        }else if (result == 0) {
            JOptionPane.showMessageDialog(null, "插入数据成功", "提示消息", JOptionPane.WARNING_MESSAGE);
            System.out.println("插入数据失败");
        }
    }

    public void clear(){
        jtf1.setText("");
        jtf2.setText("");
        jtf3.setText("");
        jtf4.setText("");
        jtf5.setText("");
        jtf6.setText("");
        jtf7.setText("");
        jtf8.setText("");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回") {
            this.dispose();
            new Information();
        } else if (e.getActionCommand() == "发布") {
            insertinformation();
//            MeetingInformation mi = new MeetingInformation();
//            m_id = jtf1.getText();
//            m_name = jtf2.getText();
//            b_id = jtf3.getText();
//            t_id = jtf4.getText();
//            t_name = jtf5.getText();
//            address = jtf6.getText();
//            time = jtf7.getText();
//            kind = jtf8.getText();
//
//            mi.setM_id(m_id);
//            mi.setM_id(m_name);
//            mi.setM_id(b_id);
//            mi.setM_id(t_id);
//            mi.setM_id(t_name);
//            mi.setM_id(address);
//            mi.setM_id(time);
//            mi.setM_id(kind);
//
//            int res = InsertInformations.getInstance().information(mi);
//
//            if (res == 1) {
//                JOptionPane.showMessageDialog(null, "插入信息成功", "提示消息", JOptionPane.WARNING_MESSAGE);
//                System.out.println("插入数据成功");
//            } else {
//                JOptionPane.showMessageDialog(null, "插入信息失败", "提示消息", JOptionPane.WARNING_MESSAGE);
//                System.out.println("插入数据失败");
//            }
        }
    }
}
