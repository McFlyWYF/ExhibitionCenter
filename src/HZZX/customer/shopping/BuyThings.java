package HZZX.customer.shopping;

import HZZX.bean.ShopBuyInformation;
import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyThings extends JFrame implements ActionListener {

    JTextField jt1,jt2,jt3,jt4,jt5,jt6;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8;
    JButton jb1,jb2;
    private int result1 =0;

    public BuyThings(){


        jt1 = new JTextField(8);
        jt2 = new JTextField(8);
        jt3 = new JTextField(8);
        //jt4 = new JTextField(8);
        jt5 = new JTextField(8);
        //jt6 = new JTextField(8);

        jl1 = new JLabel("展品采购");
        jl2 = new JLabel("采购商编号");
        jl3 = new JLabel("姓名");
        jl4 = new JLabel("展品编号");
        //jl5 = new JLabel("展品名称");
        jl6 = new JLabel("采购时间");
        //jl7 = new JLabel("价格");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();


        jb1 = new JButton("购买");
        //jb2 = new JButton("返回");
        jb1.addActionListener(this);
        //jb2.addActionListener(this);

        jp1.add(jl1);

        jp2.add(jl2);
        jp2.add(jt1);
        jp2.add(jl3);
        jp2.add(jt2);

        jp3.add(jl4);
        jp3.add(jt3);
        //jp3.add(jl5);
        //jp3.add(jt4);

        jp3.add(jl6);
        jp3.add(jt5);
        //jp4.add(jl7);
        //jp4.add(jt6);

        jp5.add(jb1);
        //jp5.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        //this.add(jp4);
        this.add(jp5);

        this.setVisible(true);
        this.setTitle("会展中心管理系统");
        this.setBounds(200,200,600,400);
        this.setLayout(new GridLayout(6,4));
    }


    public void clear(){
        jt1.setText("");
        jt2.setText("");
        jt3.setText("");
//        jt4.setText("");
        jt5.setText("");
        //jt6.setText("");
    }


    public void buythings() {
        Connection con = null;
        int result = 0;
        try{
            con = DatabaseConnection.getConnection();
            String sql = "insert into Shop values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ShopBuyInformation pi = new ShopBuyInformation();

            pi.setS_id(jt1.getText());
            pi.setS_name(jt2.getText());
            pi.setT_id(jt3.getText());
//            pi.setT_name(jt4.getText());
            pi.setTime(jt5.getText());
            //pi.setPrice((jt6.getText()));

            ps.setString(1,pi.getS_id());
            ps.setString(2,pi.getS_name());
            ps.setString(3,pi.getT_id());
            //ps.setString(4,pi.getT_name());
            ps.setString(4,pi.getTime());
            //ps.setString(6,pi.getPrice());

            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }if (result == 1){
            JOptionPane.showMessageDialog(null,"购买成功","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("购买成功");
            clear();
        }else if (result == 0){
            JOptionPane.showMessageDialog(null,"购买失败","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("购买失败");
            clear();
        }
    }


    public int verify1(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Shop where Sno = ?");
            ps.setString(1,jt1.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null,"该订单号已存在,请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
                result = 0;
            }else {
                //JOptionPane.showMessageDialog(null,"该数据不存在，请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
                result = 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

//    public int verify(){
//        Connection con = null;
//        ResultSet rs;
//        int result = 0;
//        try {
//            con = DatabaseConnection.getConnection();
//            PreparedStatement ps = con.prepareStatement("select * from Meeting,Shop where Meeting.Tno = Shop.Tno and Shop.Tno = ?");
//            //ps.setString(1,jt6.getText());
//            ps.setString(1,jt3.getText());
//            rs = ps.executeQuery();
//            if (rs.next()){
//                result = 1;
//            }else {
//                JOptionPane.showMessageDialog(null,"该数据不存在，请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return result;
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回"){

        }else if (e.getActionCommand() == "购买") {
            if (verify1() == 1) {
                buythings();
            }else {
                clear();
            }
        }
    }
}
