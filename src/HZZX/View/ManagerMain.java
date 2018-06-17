package HZZX.View;

import HZZX.manager.Business;
import HZZX.manager.Information;
import HZZX.manager.Place;
import HZZX.manager.Thing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerMain extends JFrame implements ActionListener {

    JButton jb1, jb2, jb3 ,jb4,jb5;
    JPanel jp1,jp2,jp3,jp4,jp5;
    JLabel jl1;

    ManagerMain(){
        jb1 = new JButton("会展信息管理");
        jb2 = new JButton("展商管理");
        jb3 = new JButton("展馆管理");
        jb4 = new JButton("展品管理");
        jb5 = new JButton("退出");

        jl1 = new JLabel("管理员主菜单");

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);


        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();


        jp1.add(jb1);
        jp1.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);

        jp4.add(jb5);

        jp3.add(jl1);

        this.add(jp3);
        this.add(jp1);
        this.add(jp2);
        this.add(jp4);

        this.setVisible(true);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(4, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 200, 600, 380);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "退出"){
            System.exit(0);
        }else if (e.getActionCommand() == "会展信息管理"){
            this.dispose();
            new Information();
        }else if (e.getActionCommand() == "展商管理"){
            this.dispose();
            new Business();
        }else if (e.getActionCommand() == "展品管理"){
            this.dispose();
            new Thing();
        }else if (e.getActionCommand() == "展馆管理"){
            this.dispose();
            new Place();
        }
    }
}
