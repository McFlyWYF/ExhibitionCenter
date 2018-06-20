package HZZX.customer.placeReserve;

import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateReserve extends JFrame implements ActionListener{

        JButton jb1,jb2;
        JPanel jp1,jp2,jp3;
        JLabel jl1,jl2;
        JTextField jt1;

        public UpdateReserve(){
            jb1 = new JButton("确定");
            //jb2 = new JButton("返回");

            jp1 = new JPanel();
            jp2 = new JPanel();
            jp3 = new JPanel();

            jl1 = new JLabel("展馆预约修改系统");
            jl2 = new JLabel("订单号");

            jt1 = new JTextField(8);

            jb1.addActionListener(this);
            //jb2.addActionListener(this);

            jp1.add(jl1);
            jp2.add(jl2);
            jp2.add(jt1);

            jp3.add(jb1);
            //jp3.add(jb2);

            this.add(jp1);
            this.add(jp2);
            this.add(jp3);

            this.setVisible(true);
            this.setLayout(new GridLayout(4,3));
            this.setBounds(300,300,600,400);
            this.setTitle("会展中心管理系统");
        }

        public int verify(){
            Connection con = null;
            ResultSet rs;
            int result = 0;
            try {
                con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement("select * from Reserve where RNO = ?");
                ps.setString(1,jt1.getText());
                rs = ps.executeQuery();
                if (rs.next()){
                    JOptionPane.showMessageDialog(null,"该订单编号存在","提示消息",JOptionPane.WARNING_MESSAGE);
                    result = 1;
                }else {
                    JOptionPane.showMessageDialog(null,"该订单编号不存在，请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return result;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "返回"){

            }else if (e.getActionCommand() == "确定") {
                if (verify() == 1) {
                    dispose();
                    new UpdateReserveInformation();
                }else {
                    jt1.setText("");
                }
            }
        }
}
