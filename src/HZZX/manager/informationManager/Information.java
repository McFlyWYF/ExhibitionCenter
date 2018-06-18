package HZZX.manager.informationManager;

import HZZX.View.ManagerMain;
import HZZX.manager.informationManager.InsertInformations;
import HZZX.manager.informationManager.deleteInformation.DeleteInformation;
import HZZX.manager.informationManager.selectInformation.SelectInformation;
import HZZX.customer.ticket.SelectTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Information extends JFrame implements ActionListener {

    JPanel jp1, jp2 ,jp3 = null;
    JButton jb1, jb2, jb3,jb4,jb5 = null;
    ResultSet rs;
    Statement st;

    public Information() {

        jb1 = new JButton("查询会展信息");
        jb2 = new JButton("发布会展信息");
        jb3 = new JButton("删除会展信息");
        jb4 = new JButton("返回");
        jb5 = new JButton("购票信息查询");

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jp1.add(jb1);
        jp1.add(jb2);
        jp2.add(jb3);
        jp2.add(jb5);
        jp3.add(jb4);


        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setVisible(true);
//        this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(300, 200, 600, 380);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回") {
            dispose();
            new ManagerMain();
        } else if (e.getActionCommand() == "查询会展信息") {
            SelectInformation.selectInformation();
        } else if (e.getActionCommand() == "发布会展信息") {
            this.dispose();
            new InsertInformations();
        }else if(e.getActionCommand() == "删除会展信息"){
            this.dispose();
            new DeleteInformation();
        }else if (e.getActionCommand() == "购票信息查询"){
            //this.dispose();
            SelectTicket.selectInformation();
        }
    }
}
