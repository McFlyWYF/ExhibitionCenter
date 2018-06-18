package HZZX.manager.informationManager.deleteInformation;

import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
类别
 */
public class Kind extends JFrame implements ActionListener {

    JButton jb1,jb2;
    JPanel jp1,jp2,jp3;
    JTextField jt1;
    JLabel jl1,jl2;

    public Kind(){
        jb1 = new JButton("删除");
        jb2 = new JButton("返回");

        jl1 = new JLabel("会展信息删除");
        jl2 = new JLabel("类别");

        jt1 = new JTextField(6);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jp1.add(jl1);
        jp2.add(jl2);
        jp2.add(jt1);
        jp3.add(jb1);
        jp3.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setVisible(true);
        this.setBounds(200,200,600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5,5));
    }

    public void delete(){
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement st = con.prepareStatement("delete from Meeting where Tkind = ?");
            st.setString(1,jt1.getText());
            st.executeUpdate();
            System.out.println("数据删除成功");
            JOptionPane.showMessageDialog(null,"删除成功","提示消息",JOptionPane.WARNING_MESSAGE);
            jt1.setText("");
            con.close();
            System.out.println("数据库关闭成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "删除"){
            delete();
        }else if (e.getActionCommand() == "返回"){
            this.dispose();
            new DeleteInformation();
        }
    }
}
