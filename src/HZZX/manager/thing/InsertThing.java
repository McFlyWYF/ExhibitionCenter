package HZZX.manager.thing;

import HZZX.bean.ThingInformation;
import HZZX.bean.TicketInformation;
import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertThing extends JFrame implements ActionListener {

    JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6 = null;
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7 = null;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8 = null;
    JButton jb1, jb2;

    public InsertThing() {


        jl7 = new JLabel(" 会展中心购票系统");
        jl1 = new JLabel(" 展品编号：");
        jl2 = new JLabel(" 名称：");
        jl3 = new JLabel(" 类别：");
        jl4 = new JLabel(" 售价：");
        jl5 = new JLabel(" 规格：");

        jb1 = new JButton("添加");
        jb2 = new JButton("返回");

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jtf1 = new JTextField(6);
        jtf2 = new JTextField(6);
        jtf3 = new JTextField(6);
        jtf4 = new JTextField(6);
        jtf5 = new JTextField(6);


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

        jp5.add(jb1);
        jp5.add(jb2);

        jp6.add(jl7);

        this.add(jp6);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp5);

        this.setVisible(true);;
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(300, 200, 900, 500);
    }


    public void insertinformation() {
        Connection con = null;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            String sql = "insert into Thing values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ThingInformation mi = new ThingInformation();

            mi.setT_id(jtf1.getText());
            mi.setT_name(jtf2.getText());
            mi.setKind(jtf3.getText());
            mi.setPrice(jtf4.getText());
            mi.setArea(jtf5.getText());

            ps.setString(1,mi.getT_id());
            ps.setString(2,mi.getT_name());
            ps.setString(3,mi.getKind());
            ps.setString(4,mi.getPrice());
            ps.setString(5,mi.getArea());

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
            JOptionPane.showMessageDialog(null,"添加成功","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("添加成功");
            clear();
        }else if (result == 0) {
            JOptionPane.showMessageDialog(null, "添加失败", "提示消息", JOptionPane.WARNING_MESSAGE);
            System.out.println("添加失败");
        }
    }

    public void clear(){
        jtf1.setText("");
        jtf2.setText("");
        jtf3.setText("");
        jtf4.setText("");
        jtf5.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回") {
            dispose();
            new Things();
        } else if (e.getActionCommand() == "添加") {
            insertinformation();
        }
    }
}
