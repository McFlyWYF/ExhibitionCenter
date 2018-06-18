package HZZX.customer.ticket;

import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateTicketInformation extends JFrame implements ActionListener {

    JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6 = null;
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7 = null;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8 = null;
    JButton jb1, jb2;

    public UpdateTicketInformation() {

        jl7 = new JLabel(" 门票修改系统");
        jl1 = new JLabel(" 订单号：");
        jl2 = new JLabel(" 姓名：");
        jl3 = new JLabel(" 性别：");
        jl4 = new JLabel(" 职业：");
        jl5 = new JLabel(" 会展编号：");
        jl6 = new JLabel(" 售价：");

        jb1 = new JButton("确定");
        jb2 = new JButton("返回");

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jtf1 = new JTextField(6);
        jtf2 = new JTextField(6);
        jtf3 = new JTextField(6);
        jtf4 = new JTextField(6);
        jtf5 = new JTextField(6);
        jtf6 = new JTextField(6);

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

        jp5.add(jb1);
        jp5.add(jb2);

        jp6.add(jl7);

        this.add(jp6);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp5);

        this.setVisible(true);
//        this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(300, 200, 600, 380);
    }

    public int verify(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Ticket where Ano = ?");
            ps.setString(1,jtf1.getText());
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
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("update Ticket set Aname = ?,Asex = ?,Awork = ?,Mno = ? where Ano = " + jtf1.getText());
            ps.setString(1,jtf2.getText());
            ps.setString(2,jtf3.getText());
            ps.setString(3,jtf4.getText());
            ps.setString(4,jtf5.getText());

            ps.executeUpdate();
            System.out.println("订单修改成功");
            JOptionPane.showMessageDialog(null,"订单修改成功","提示消息",JOptionPane.WARNING_MESSAGE);
            jtf1.setText("");
            jtf2.setText("");
            jtf3.setText("");
            jtf4.setText("");
            jtf5.setText("");
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
            new UpdateTicket();
        }else if (e.getActionCommand() == "确定"){
            if (verify() == 1) {
                update();
            }else {
                    JOptionPane.showMessageDialog(null,"该订单编号不存在，请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
                    jtf1.setText("");
            }
        }
    }
}

