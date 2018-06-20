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


        jb1 = new JButton("添加展馆");
        jb2 = new JButton("删除展馆");
        jb3 = new JButton("查询展馆信息");
        jb4 = new JButton("修改展馆信息");
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

        this.setTitle("会展中心管理系统");
        this.setVisible(true);
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(300, 200, 900, 500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "添加展馆"){
            dispose();
            new InsertPlace();
        }else if (e.getActionCommand() == "删除展馆"){
            dispose();
            new DeletePlace();
        }else if (e.getActionCommand() == "查询展馆信息"){
            new SelectPlace();
        }else if (e.getActionCommand() == "修改展馆信息"){
            dispose();
            new UpdatePlace();
        }else if (e.getActionCommand() == "返回"){
            dispose();
            new ManagerMain();
        }
    }
}
