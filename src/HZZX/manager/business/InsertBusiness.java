package HZZX.manager.business;

import HZZX.View.Customer;
import HZZX.bean.BusinessInformation;
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

public class InsertBusiness extends JFrame implements ActionListener {

    JTextField jt1,jt2,jt3,jt4,jt5,jt6;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8;
    JButton jb1,jb2;
    private int result1 =0;

    public InsertBusiness(){

        jt1 = new JTextField(8);
        jt2 = new JTextField(8);
        jt3 = new JTextField(8);
        jt4 = new JTextField(8);
        jt5 = new JTextField(8);
        jt6 = new JTextField(8);

        jl1 = new JLabel("展商管理");
        jl2 = new JLabel("展商编号");
        jl3 = new JLabel("姓名");
        jl4 = new JLabel("身份证号");
        jl5 = new JLabel("职业");
        jl6 = new JLabel("工作单位");
        jl7 = new JLabel("手机号");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();


        jb1 = new JButton("添加");
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
        this.setBounds(200,200,900,500);
        this.setLayout(new GridLayout(6,4));
    }


    public void clear(){
        jt1.setText("");
        jt2.setText("");
        jt3.setText("");
        jt4.setText("");
        jt5.setText("");
        jt6.setText("");
    }


    public void buythings() {
        Connection con = null;
        int result = 0;
        try{
            con = DatabaseConnection.getConnection();
            String sql = "insert into Business values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            BusinessInformation pi = new BusinessInformation();

            pi.setB_id(jt1.getText());
            pi.setB_name(jt2.getText());
            pi.setID(jt3.getText());
            pi.setWork(jt4.getText());
            pi.setWorkplace(jt5.getText());
            pi.setTel((jt6.getText()));

            ps.setString(1,pi.getB_id());
            ps.setString(2,pi.getB_name());
            ps.setString(3,pi.getID());
            ps.setString(4,pi.getWork());
            ps.setString(5,pi.getWorkplace());
            ps.setString(6,pi.getTel());

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
            JOptionPane.showMessageDialog(null,"添加成功","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("添加成功");
            clear();
        }else if (result == 0){
            JOptionPane.showMessageDialog(null,"添加失败","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("添加失败");
            clear();
        }
    }


    public int verify1(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Business where Bno = ?");
            ps.setString(1,jt1.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null,"该编号已存在,请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回"){
            dispose();
            new Business();
        }else if (e.getActionCommand() == "添加") {
            if (verify1() == 1) {
                buythings();
            }else {
                clear();
            }
        }
    }
}
