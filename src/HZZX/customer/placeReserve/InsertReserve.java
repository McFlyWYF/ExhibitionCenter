package HZZX.customer.placeReserve;

import HZZX.bean.PlaceReserveInformation;
import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertReserve extends JFrame implements ActionListener {

    JTextField jt1,jt2,jt3,jt4,jt5,jt6;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8;
    JButton jb1,jb2;

    public InsertReserve(){

        jt1 = new JTextField(8);
        jt2 = new JTextField(8);
        jt3 = new JTextField(8);
        jt4 = new JTextField(8);
        jt5 = new JTextField(8);
        jt6 = new JTextField(8);

        jl1 = new JLabel("展馆预约");
        jl2 = new JLabel("预约编号");
        jl3 = new JLabel("展馆编号");
        jl4 = new JLabel("展商编号");
        jl5 = new JLabel("展商姓名");
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
        jp3.add(jl5);
        jp3.add(jt4);

        jp4.add(jl6);
        jp4.add(jt5);
        jp4.add(jl7);
        jp4.add(jt6);

        jp5.add(jb1);
        //jp5.add(jb2);

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
        jt3.setText("");
        jt4.setText("");
        jt5.setText("");
        jt6.setText("");
    }


    public void placeReserve() {
        Connection con = null;
        int result = 0;
        try{
            con = DatabaseConnection.getConnection();
            String sql = "insert into Reserve values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            PlaceReserveInformation pi = new PlaceReserveInformation();

            pi.setR_id(jt1.getText());
            pi.setP_id(jt2.getText());
            pi.setB_id(jt3.getText());
            pi.setB_name(jt4.getText());
            pi.setTime(jt5.getText());
            pi.setNum((jt6.getText()));

            ps.setString(1,pi.getR_id());
            ps.setString(2,pi.getP_id());
            ps.setString(3,pi.getB_id());
            ps.setString(4,pi.getB_name());
            ps.setString(5,pi.getTime());
            ps.setString(6,pi.getNum());

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
            JOptionPane.showMessageDialog(null,"预约成功","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("预约成功");
            clear();
        }else if (result == 0){
            JOptionPane.showMessageDialog(null,"预约失败","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("预约失败");
            clear();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回"){

        }else if (e.getActionCommand() == "预约"){
            placeReserve();
        }
    }
}
