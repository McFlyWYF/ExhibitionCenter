package HZZX.manager.place;

import HZZX.View.ManagerMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Place extends JFrame implements ActionListener {

    JButton jb1,jb2,jb3,jb4,jb5;
    JPanel jp1,jp2,jp3 = null;

    public Place() {

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

        JLabel jl1 = new JLabel("                 ");
        JPanel jp4 = new JPanel();
        jl1.setFont(font);

        jb1 = new JButton("添加展馆");
        jb1.setFont(font);
        jb1.setBackground(Color.WHITE);
        jb2 = new JButton("删除展馆");
        jb2.setFont(font);
        jb2.setBackground(Color.WHITE);
        jb3 = new JButton("查询展馆信息");
        jb3.setFont(font);
        jb3.setBackground(Color.WHITE);
        jb4 = new JButton("修改展馆信息");
        jb4.setFont(font);
        jb4.setBackground(Color.WHITE);
        jb5 = new JButton("返回");
        jb5.setFont(font);
        jb5.setBackground(Color.WHITE);

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
        jp4.add(jl1);

        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        jp4.setOpaque(false);

        this.add(jp4);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setTitle("会展中心管理系统");
        this.setVisible(true);
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(630, 260, 752, 471);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "添加展馆"){
            //dispose();
            new InsertPlace();
        }else if (e.getActionCommand() == "删除展馆"){
            //dispose();
            new DeletePlace();
        }else if (e.getActionCommand() == "查询展馆信息"){
            new SelectPlace();
        }else if (e.getActionCommand() == "修改展馆信息"){
            //dispose();
            new UpdatePlace();
        }else if (e.getActionCommand() == "返回"){
            dispose();
            new ManagerMain();
        }
    }
}
