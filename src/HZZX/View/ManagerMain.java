package HZZX.View;

import HZZX.manager.business.Business;
import HZZX.manager.meetingInformation.Information;
import HZZX.manager.place.Place;
import HZZX.manager.thing.Things;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
管理员主界面
 */

public class ManagerMain extends JFrame implements ActionListener {

    JButton jb1, jb2, jb3 ,jb4,jb5;
    JPanel jp1,jp2,jp3,jp4,jp5;
    JLabel jl1;

    public ManagerMain(){

        Font font = new Font("alias", Font.PLAIN, 22);
        Font font1 = new Font("alias", Font.PLAIN, 30);


        //加载图片
        ImageIcon icon=new ImageIcon("image6.png");
//
//        //将图片放入label中
        JLabel label=new JLabel(icon);
//
//        //设置label的大小
        label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
//
//        //获取窗口的第二层，将label放入
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
//
//        //获取frame的顶层容器,并设置为透明
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);

        jb1 = new JButton("会展信息管理");
        jb1.setBackground(Color.WHITE);
        jb1.setFont(font);
        jb2 = new JButton("展商管理");
        jb2.setBackground(Color.WHITE);
        jb2.setFont(font);
        jb3 = new JButton("展馆管理");
        jb3.setBackground(Color.WHITE);
        jb3.setFont(font);
        jb4 = new JButton("展品管理");
        jb4.setBackground(Color.WHITE);
        jb4.setFont(font);
        jb5 = new JButton("退出");
        jb5.setBackground(Color.WHITE);
        jb5.setFont(font);

        jl1 = new JLabel("管理员主菜单");
        jl1.setFont(font1);

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

        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        jp4.setOpaque(false);

        this.add(jp3);
        this.add(jp1);
        this.add(jp2);
        this.add(jp4);

        this.setVisible(true);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(4, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(530, 200, icon.getIconWidth(), icon.getIconHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "退出"){
            System.exit(0);
        }else if (e.getActionCommand() == "会展信息管理"){
            new Information();
            this.dispose();
        }else if (e.getActionCommand() == "展商管理"){
            new Business();
            this.dispose();
        }else if (e.getActionCommand() == "展品管理"){
            new Things();
            this.dispose();
        }else if (e.getActionCommand() == "展馆管理"){
            new Place();
            this.dispose();
        }
    }
}
