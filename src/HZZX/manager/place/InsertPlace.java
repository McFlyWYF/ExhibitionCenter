package HZZX.manager.place;

import HZZX.bean.PlaceInformation;
import HZZX.bean.PlaceReserveInformation;
import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertPlace extends JFrame implements ActionListener {

    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7;
    JButton jb1, jb2;
    JTextField jt1, jt2, jt3, jt4, jt5, jt6;


    public InsertPlace() {

        jb1 = new JButton("开放展馆");
        jb2 = new JButton("返回");

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();


        JLabel jl1 = new JLabel("展馆信息管理");
        JLabel jl2 = new JLabel("展馆编号");
        JLabel jl3 = new JLabel("展馆名称");
        JLabel jl4 = new JLabel("面积");
        JLabel jl5 = new JLabel("地址");
        JLabel jl6 = new JLabel("负责人");
        JLabel jl7 = new JLabel("展位数");

        jt1 = new JTextField(8);
        jt2 = new JTextField(8);
        jt3 = new JTextField(8);
        jt4 = new JTextField(8);
        jt5 = new JTextField(8);
        jt6 = new JTextField(8);


        jp1.add(jl1);
        jp2.add(jl2);
        jp2.add(jt1);

        jp2.add(jl3);
        jp2.add(jt2);

        jp3.add(jl4);
        jp3.add(jt3);

        jp3.add(jl5);
        jp3.add(jt4);

        jp4.add(jl6);
        jp4.add(jt5);

        jp4.add(jl7);
        jp4.add(jt6);

        jp5.add(jb1);
        jp5.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);

        this.setVisible(true);
//        this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(300, 200, 900, 500);
    }

    public void clear() {
        jt1.setText("");
        jt2.setText("");
        jt3.setText("");
        jt4.setText("");
        jt5.setText("");
        jt6.setText("");
    }

    //验证展商编号是否存在
    public int Verify1() {
        int result = 0;
        try {
            PreparedStatement ps = null;
            Connection con = null;
            ResultSet rs;
            ps = con.prepareStatement("select * from Place where Pno = ?");
            ps.setString(1, jt1.getText());

            rs = ps.executeQuery();
            if (rs.next()) {
                clear();
            } else {
                result = 1;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return result;
    }

    public void insert() {
        Connection con = null;
        int result = 0;

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into Place values(?,?,?,?,?,?)");
            PlaceInformation b = new PlaceInformation();
            b.setP_id(jt1.getText());
            b.setP_name(jt2.getText());
            b.setArea(jt3.getText());
            b.setAddress(jt4.getText());
            b.setPeople(jt5.getText());
            b.setNum(jt6.getText());

            ps.setString(1, b.getP_id());
            ps.setString(2, b.getP_name());
            ps.setString(3, b.getArea());
            ps.setString(4, b.getAddress());
            ps.setString(5, b.getPeople());
            ps.setString(6, b.getNum());

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
        if (result == 1) {
            JOptionPane.showMessageDialog(null, "添加成功", "提示消息", JOptionPane.WARNING_MESSAGE);
            clear();
        }else if (Verify1() == 0){
            JOptionPane.showMessageDialog(null, "该编号已经存在", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "开放展馆") {
            insert();
        }else if (e.getActionCommand() == "返回"){
            dispose();
            new Place();
        }
    }
}