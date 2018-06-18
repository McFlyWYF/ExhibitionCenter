package HZZX.customer.placeReserve;

import HZZX.View.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reserve extends JFrame implements ActionListener {

    JButton jb1,jb2,jb3,jb4,jb5;
    JPanel jp1,jp2,jp3,jp4;
    public Reserve(){


        jb1 = new JButton("预约");
        jb2 = new JButton("查询");
        jb3 = new JButton("取消");
        jb4 = new JButton("修改");
        jb5 = new JButton("返回");

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
        jp2.add(jb4);

        jp3.add(jb5);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setVisible(true);
        this.setLayout(new GridLayout(4,2));
        this.setBounds(200,200,600,400);
        this.setTitle("会展中心管理系统");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回"){
            dispose();
            new Customer();
        }else if (e.getActionCommand() == "预约"){
            dispose();
            new InsertReserve();
        }else if (e.getActionCommand() == "取消"){
            dispose();
            new DeleteReserve();
        }else if (e.getActionCommand() == "修改"){
            dispose();
            new UpdateReserve();
        }else if (e.getActionCommand() == "查询"){
            SelectReserve.selectInformation();
        }
    }
}
