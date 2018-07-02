package HZZX.manager.meetingInformation;

import HZZX.View.ManagerMain;
import HZZX.customer.placeReserve.SelectReserve;
import HZZX.customer.placeReserve.SelectReserveAll;
import HZZX.customer.shopping.SelectThings;
import HZZX.customer.shopping.SelectThingsAll;
import HZZX.customer.ticket.SelectTicketAll;
import HZZX.manager.meetingInformation.DeleteInformation;
import HZZX.manager.meetingInformation.InsertInformations;
import HZZX.manager.meetingInformation.SelectInformation;
import HZZX.customer.ticket.SelectTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Information extends JFrame implements ActionListener {

    JPanel jp1, jp2 ,jp3,jp4 = null;
    JButton jb1, jb2, jb3,jb4,jb5,jb6,jb7 = null;
    ResultSet rs;
    Statement st;

    public Information() {
        Font font = new Font("alias", Font.PLAIN, 22);

        //加载图片
        ImageIcon icon = new ImageIcon("image7.png");
//
//        //将图片放入label中
        JLabel label = new JLabel(icon);
//
//        //设置label的大小
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
//
//        //获取窗口的第二层，将label放入
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
//
//        //获取frame的顶层容器,并设置为透明
        JPanel j = (JPanel) this.getContentPane();
        j.setOpaque(false);

        JPanel jp5 = new JPanel();
        JLabel jl1 = new JLabel("   ");

        jb1 = new JButton("查询会展信息");
        jb1.setBackground(Color.WHITE);
        jb1.setFont(font);
        jb2 = new JButton("发布会展信息");
        jb2.setBackground(Color.WHITE);
        jb2.setFont(font);
        jb3 = new JButton("删除会展信息");
        jb3.setBackground(Color.WHITE);
        jb3.setFont(font);
        jb4 = new JButton("返回");
        jb4.setBackground(Color.WHITE);
        jb4.setFont(font);
        jb5 = new JButton("购票信息查询");
        jb5.setBackground(Color.WHITE);
        jb5.setFont(font);
        jb6 = new JButton("展品采购信息查询");
        jb6.setBackground(Color.WHITE);
        jb6.setFont(font);
        jb7 = new JButton("展馆预定信息查询");
        jb7.setBackground(Color.WHITE);
        jb7.setFont(font);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);


        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jp1.add(jb1);
        jp1.add(jb2);
        jp2.add(jb3);
        jp2.add(jb5);
        jp4.add(jb6);
        jp4.add(jb7);
        jp3.add(jb4);
        jp5.add(jl1);


        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        jp4.setOpaque(false);
        jp5.setOpaque(false);

        this.add(jp5);
        this.add(jp1);
        this.add(jp2);
        this.add(jp4);
        this.add(jp3);

        this.setVisible(true);
//        this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(675, 270, icon.getIconWidth(), icon.getIconHeight());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回") {
            new ManagerMain();
            dispose();

        } else if (e.getActionCommand() == "查询会展信息") {
            new SelectInformation();
        } else if (e.getActionCommand() == "发布会展信息") {
            //this.dispose();
            new InsertInformations();
        }else if(e.getActionCommand() == "删除会展信息"){
            //this.dispose();
            new DeleteInformation();
        }else if (e.getActionCommand() == "购票信息查询"){
            //this.dispose();
            new SelectTicketAll();
        }else if (e.getActionCommand() == "展品采购信息查询"){
            new SelectThingsAll();
        }
        else if (e.getActionCommand() == "展馆预定信息查询"){
            new SelectReserveAll();
        }
    }
}
