package HZZX.View;

import HZZX.utils.Facade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
注册界面
 */

public class RegisterView extends JFrame implements ActionListener {

    //门面类对象
    Facade fcd = new Facade();

    //定义组件
    JFrame jf;
    JPanel jp1, jp2, jp3, jp4, jp5;
    JLabel jl1, jl2, jl3;
    static JTextField jtf1, jtf2;
    JButton jb1, jb2;
    ButtonGroup group;
    JRadioButton jrb1 = null, jrb2 = null;

    public RegisterView() {
        //初始化组件
        jf = new JFrame();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();

        jl1 = new JLabel("请输入用户名：");
        jtf1 = new JTextField(10);
        jtf1.setToolTipText("用户名必须为3-11位字母_或者数字");
        jl2 = new JLabel("请输入密码：");
        jtf2 = new JPasswordField(10);
        jtf2.setToolTipText("密码必须为6位字母_或者数字");

        jl3 = new JLabel("注册界面");

        jb1 = new JButton("返回");
        jb1.setToolTipText("点我返回登录界面哦");
        jb2 = new JButton("注册");
        jb1.addActionListener(this);
        jb2.addActionListener(this);


        jrb1 = new JRadioButton("管理员");
        jrb2 = new JRadioButton("客户");
        group = new ButtonGroup();
        group.add(jrb1);
        group.add(jrb2);

        jp1.add(jl1);
        jp1.add(jtf1);

        jp2.add(jl2);
        jp2.add(jtf2);

        jp3.add(jb1);
        jp3.add(jb2);

        jp4.add(jl3);

        jp5.add(jrb1);
        jp5.add(jrb2);

        this.add(jp4);
        this.add(jp1);
        this.add(jp2);
        this.add(jp5);
        this.add(jp3);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 2));
        this.setBounds(400, 150, 600, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "返回") {
            this.dispose();
            new MainView();

        } else if (e.getActionCommand() == "注册") {
            //调用注册方法
            if (jrb1.isSelected()) {
                this.zhuce1();
            } else if (jrb2.isSelected()) {
                this.zhuce2();
            }
        }

    }

    //管理员注册方法
    public void zhuce1() {
        String account = "\\w{3,8}"; //管理员用户名必须是3-8位
        boolean flag1 = jtf1.getText().matches(account);

        String password = "\\w{6}"; //密码必须是6位
        boolean flag2 = jtf2.getText().matches(password);

        if (flag1 == false) {
            JOptionPane.showMessageDialog(null, "用户名填写错误,必须为3-8位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
            jtf1.setText("");
        } else if (flag2 == false) {
            JOptionPane.showMessageDialog(null, "密码填写错误,必须为6位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
            jtf2.setText("");
        } else {
            //使用门面模式
            fcd.ConnectSQL();
            fcd.zhuceverify1(jtf1.getText());

            this.jtf1.setText("");
            this.jtf2.setText("");
        }
    }

    // 用户登录方法
    public void zhuce2() {
        String account = "\\w{6,11}"; //客户用户名必须是3-11位
        boolean flag1 = jtf1.getText().matches(account);

        String password = "\\w{6}"; //密码必须是6位
        boolean flag2 = jtf2.getText().matches(password);

        if (flag1 == false) {
            JOptionPane.showMessageDialog(null, "用户名填写错误,必须为6-11位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
            jtf1.setText("");
        } else if (flag2 == false) {
            JOptionPane.showMessageDialog(null, "密码填写错误,必须为6位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
            jtf2.setText("");
        } else {
            fcd.ConnectSQL();
            fcd.zhuceverify2(jtf1.getText());
            this.jtf1.setText("");
            this.jrb2.setText("");
        }
    }
}
