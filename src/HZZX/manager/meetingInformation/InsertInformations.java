package HZZX.manager.meetingInformation;

import HZZX.bean.MeetingInformation;
import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/*
添加会展信息
 */
public class InsertInformations extends JFrame implements ActionListener {

    JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8,jtf9 = null;
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8,jl9 = null;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8 = null;
    JButton jb1, jb2;

    public InsertInformations() {

        jl1 = new JLabel(" 展会编号：");
        jl2 = new JLabel(" 展会名称：");
        jl3 = new JLabel(" 展商编号：");
        jl4 = new JLabel(" 展品编号：");
        jl6 = new JLabel(" 展馆编号：");
        jl7 = new JLabel(" 时间：");
        jl9 = new JLabel(" 门票价格");

        jb1 = new JButton("发布");
        jb1.addActionListener(this);

        jtf1 = new JTextField(6);
        jtf2 = new JTextField(6);
        jtf3 = new JTextField(6);
        jtf4 = new JTextField(6);
        jtf6 = new JTextField(6);
        jtf7 = new JTextField(6);
        jtf9 = new JTextField(6);


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

        jp3.add(jl6);
        jp3.add(jtf6);

        jp3.add(jl7);
        jp3.add(jtf7);

        jp4.add(jl9);
        jp4.add(jtf9);

        jp5.add(jb1);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);

        this.setVisible(true);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(6, 4));
        this.setBounds(700, 300, 752,471);
    }

    //展馆编号验证
    public int verifyPno(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Place where Pno = ?");
            ps.setString(1,jtf6.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                result = 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    //展商编号验证
    public int verifyBno(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Business where Bno = ?");
            ps.setString(1,jtf3.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                result = 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    //展品编号验证
    public int verifyTno(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Thing where Tno = ?");
            ps.setString(1,jtf4.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                result = 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void insertinformation() {
        Connection con = null;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            String sql = "insert into Meeting values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            MeetingInformation mi = new MeetingInformation();

            if ((verifyBno() == 1) && (verifyPno() == 1) && (verifyTno() == 1)){
                mi.setM_id(jtf1.getText());
                mi.setM_name(jtf2.getText());
                mi.setB_id(jtf3.getText());
                mi.setT_id(jtf4.getText());
                //mi.setT_name(jtf5.getText());
                mi.setAddress(jtf6.getText());
                mi.setTime(jtf7.getText());
                //mi.setKind(jtf8.getText());
                mi.setPrice(jtf9.getText());

                ps.setString(1,mi.getM_id());
                ps.setString(2,mi.getM_name());
                ps.setString(3,mi.getB_id());
                ps.setString(4, mi.getT_id());
                //ps.setString(5,mi.getT_name());
                ps.setString(5,mi.getAddress());
                ps.setString(6,mi.getTime());
                //ps.setString(8,mi.getKind());
                ps.setString(7,mi.getPrice());
                result = ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"发布成功","提示消息",JOptionPane.WARNING_MESSAGE);
                System.out.println("插入数据成功");
                clear();
            }else {
                JOptionPane.showMessageDialog(null, "发布失败，编号不存在", "提示消息", JOptionPane.WARNING_MESSAGE);
                System.out.println("插入数据失败");
                clear();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void clear(){
        jtf1.setText("");
        jtf2.setText("");
        jtf3.setText("");
        jtf4.setText("");
        //jtf5.setText("");
        jtf6.setText("");
        jtf7.setText("");
        //jtf8.setText("");
        jtf9.setText("");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "发布") {
            insertinformation();
        }
    }
}
