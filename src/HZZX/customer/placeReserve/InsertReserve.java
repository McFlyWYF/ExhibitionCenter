package HZZX.customer.placeReserve;

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

public class InsertReserve extends JFrame implements ActionListener {

    JTextField jt1,jt2,jt3,jt4,jt5,jt6;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8;
    JButton jb1,jb2;

    public InsertReserve(){

        jt1 = new JTextField(8);
        jt2 = new JTextField(8);
        jt4 = new JTextField(8);
        jt5 = new JTextField(8);
        jt6 = new JTextField(8);

        jl1 = new JLabel("展馆预约");
        jl2 = new JLabel("预约编号");
        jl3 = new JLabel("展馆编号");
        //jl4 = new JLabel("展商编号");
        jl5 = new JLabel("姓名");
        jl6 = new JLabel("时间");
        jl7 = new JLabel("个数");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();


        jb1 = new JButton("预约");
        jb2 = new JButton("更新");
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jp1.add(jl1);

        jp2.add(jl2);
        jp2.add(jt1);
        jp2.add(jl3);
        jp2.add(jt2);

        //jp3.add(jl4);
        //jp3.add(jt3);
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
        this.setBounds(700,300,600,400);
        this.setLayout(new GridLayout(6,4));
    }


    public void clear(){
        jt1.setText("");
        jt2.setText("");
        //jt3.setText("");
        jt4.setText("");
        jt5.setText("");
        jt6.setText("");
    }

    public int verify1(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Place where Pno = ?");
            ps.setString(1,jt2.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null,"该编号存在","提示消息",JOptionPane.WARNING_MESSAGE);
                result = 1;
            }else {
                JOptionPane.showMessageDialog(null,"该编号不存在，请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
                result = 0;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    //获取展馆展位数
    public int getPnum(){
        Connection con = null;
        ResultSet rs = null;
        int num1 = 0;
        try{
            con = DatabaseConnection.getConnection();
            String sql = "select Pnum from Place where Pno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,jt2.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                num1 = rs.getInt(1);
            }
            System.out.println("展位数查询成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(num1);
        return num1;
    }

    //获取预约订单展位数
    public int getRnum(){
        Connection con = null;
        ResultSet rs = null;
        int num2 = 0;
        PlaceReserveInformation pi = new PlaceReserveInformation();
        try{
            con = DatabaseConnection.getConnection();
            String sql = "select Rnum from Reserve where RNO = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,jt1.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                num2 = rs.getInt(1);
            }
            System.out.println("展位数查询成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(num2);
        return num2;
    }

    public void updatePlace(){
        Connection con = null;
        int n1 = 0,n2 = 0,n3 = 0;
        try{
            con = DatabaseConnection.getConnection();
            String sql = "update Place set Pnum = ? where Pno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            n1 = this.getPnum();
            n2 = this.getRnum();
            n3 = n1-n2;
            ps.setInt(1,n3);
            ps.setString(2,jt2.getText());
            ps.executeUpdate();
            System.out.println("展位数更新成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void placeReserve() {
        Connection con = null;
        int result = 0;
        try{
            if (!jt1.getText().isEmpty() && !jt2.getText().isEmpty() && !jt4.getText().isEmpty() && !jt5.getText().isEmpty() && !jt6.getText().isEmpty()) {
                con = DatabaseConnection.getConnection();
                String sql = "insert into Reserve values (?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                PlaceReserveInformation pi = new PlaceReserveInformation();

                if (verify1() == 1) {
                    pi.setR_id(jt1.getText());
                    pi.setP_id(jt2.getText());
                    //pi.setB_id(jt3.getText());
                    pi.setB_name(jt4.getText());
                    pi.setTime(jt5.getText());
                    pi.setNum((jt6.getText()));

                    ps.setString(1, pi.getR_id());
                    ps.setString(2, pi.getP_id());
                    //ps.setString(3,pi.getB_id());
                    ps.setString(3, pi.getB_name());
                    ps.setString(4, pi.getTime());
                    ps.setString(5, pi.getNum());

                    result = ps.executeUpdate();
                }
            }else {
                JOptionPane.showMessageDialog(null, "请输入完整信息", "提示消息", JOptionPane.WARNING_MESSAGE);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }if (result == 1){
            JOptionPane.showMessageDialog(null,"预约成功","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("预约成功");
            //clear();
        }else if (result == 0){
            JOptionPane.showMessageDialog(null,"预约失败","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("预约失败");
            clear();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "更新"){
            updatePlace();
        }else if (e.getActionCommand() == "预约"){
            placeReserve();

        }
    }
}
