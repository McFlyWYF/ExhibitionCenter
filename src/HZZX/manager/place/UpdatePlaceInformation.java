package HZZX.manager.place;

import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePlaceInformation extends JFrame implements ActionListener {


    JTextField jt1,jt2,jt3,jt4,jt5,jt6;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8;
    JButton jb1,jb2;

    public UpdatePlaceInformation(){


        jt1 = new JTextField(8);
        jt2 = new JTextField(8);
        jt3 = new JTextField(8);
        jt4 = new JTextField(8);
        jt5 = new JTextField(8);
        jt6 = new JTextField(8);

        jl1 = new JLabel("展馆信息修改系统");
        jl2 = new JLabel("展馆编号");
        jl3 = new JLabel("展馆名称");
        jl4 = new JLabel("面积");
        jl5 = new JLabel("地址");
        jl6 = new JLabel("负责人");
        jl7 = new JLabel("展位数");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();


        jb1 = new JButton("确定");
        jb2 = new JButton("返回");
        jb1.addActionListener(this);
        jb2.addActionListener(this);

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
        this.setTitle("会展中心管理系统");
        this.setBounds(200,200,640,450);
        this.setLayout(new GridLayout(6,4));
    }

    public int verify(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Place where Pno = ?");
            ps.setString(1,jt1.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                result = 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    private void update(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("update Place set Pname = ?,Parea = ?, Padd = ?,Ppeo = ?,Pnum = ? where Pno = " + jt1.getText());
            ps.setString(1,jt2.getText());
            ps.setString(2,jt3.getText());
            ps.setString(3,jt4.getText());
            ps.setString(4,jt5.getText());
            ps.setString(5,jt6.getText());

            ps.executeUpdate();
            System.out.println("修改成功");
            JOptionPane.showMessageDialog(null,"修改成功","提示消息",JOptionPane.WARNING_MESSAGE);
            jt1.setText("");
            jt2.setText("");
            jt3.setText("");
            jt4.setText("");
            jt5.setText("");
            jt6.setText("");
            con.close();
            System.out.println("数据库关闭");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回"){
            dispose();
            new UpdatePlace();
        }else if (e.getActionCommand() == "确定"){
            if (verify() == 1) {
                update();
            }else {
                JOptionPane.showMessageDialog(null,"该编号不存在，请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
                jt1.setText("");
            }
        }
    }
}
