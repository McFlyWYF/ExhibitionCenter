package HZZX.manager.informationManager;

import HZZX.View.ManagerMain;
import HZZX.customer.shopping.SelectThings;
import HZZX.manager.deleteInformation.DeleteInformation;
import HZZX.manager.selectInformation.ManagerSelect;
import HZZX.customer.ticket.SelectTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Information extends JFrame implements ActionListener {

    JPanel jp1, jp2 ,jp3,jp4 = null;
    JButton jb1, jb2, jb3,jb4,jb5,jb6 = null;
    ResultSet rs;
    Statement st;

    public Information() {

        jb1 = new JButton("查询会展信息");
        jb2 = new JButton("发布会展信息");
        jb3 = new JButton("删除会展信息");
        jb4 = new JButton("返回");
        jb5 = new JButton("购票信息查询");
        jb6 = new JButton("展品采购信息查询");

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jp1.add(jb1);
        jp1.add(jb2);
        jp2.add(jb3);
        jp2.add(jb5);
        jp4.add(jb6);
        jp3.add(jb4);


        this.add(jp1);
        this.add(jp2);
        this.add(jp4);
        this.add(jp3);

        this.setVisible(true);
//        this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(300, 200, 900, 500);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回") {
            dispose();
            new ManagerMain();
        } else if (e.getActionCommand() == "查询会展信息") {
            new ManagerSelect();
        } else if (e.getActionCommand() == "发布会展信息") {
            this.dispose();
            new InsertInformations();
        }else if(e.getActionCommand() == "删除会展信息"){
            this.dispose();
            new DeleteInformation();
        }else if (e.getActionCommand() == "购票信息查询"){
            //this.dispose();
            new SelectTicket();
        }else if (e.getActionCommand() == "展品采购信息查询"){
            new SelectThings();
        }
    }
}
