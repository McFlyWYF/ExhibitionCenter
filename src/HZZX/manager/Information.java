package HZZX.manager;

import HZZX.View.MainView;
import HZZX.bean.MeetingInformation;
import HZZX.informationManager.DeleteInformation;
import HZZX.informationManager.InsertInformations;
import HZZX.informationManager.SelectInformation;
import HZZX.utils.DatabaseConnection;
import HZZX.utils.Facade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Information extends JFrame implements ActionListener {

    JPanel jp1, jp2= null;
    JButton jb1, jb2, jb3,jb4 = null;
    ResultSet rs;
    Statement st;

    public Information() {

        jb1 = new JButton("查询会展信息");
        jb2 = new JButton("发布会展信息");
        jb3 = new JButton("删除会展信息");
        jb4 = new JButton("返回");

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);

        jp1 = new JPanel();
        jp2 = new JPanel();

        jp1.add(jb1);
        jp1.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);


        this.add(jp1);
        this.add(jp2);

        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(300, 200, 600, 380);
    }

    public void selectinformation(){
        Connection con = null;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from Meeting");
            while (rs.next()){
                MeetingInformation mi = new MeetingInformation();
                mi.setM_id(rs.getString("m_id"));
                mi.setM_name(rs.getString("m_name"));
                mi.setB_id(rs.getString("b_id"));
                mi.setT_id(rs.getString("t_id"));
                mi.setT_name(rs.getString("t_name"));
                mi.setAddress(rs.getString("address"));
                mi.setTime(rs.getString("time"));
                mi.setKind(rs.getString("kind"));
            }
            }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回") {
            System.exit(0);
        } else if (e.getActionCommand() == "查询会展信息") {
            this.dispose();
            new SelectInformation();
        } else if (e.getActionCommand() == "发布会展信息") {
            this.dispose();
            new InsertInformations();
        }else if(e.getActionCommand() == "删除会展信息"){
            this.dispose();
            new DeleteInformation();
        }
    }
}
