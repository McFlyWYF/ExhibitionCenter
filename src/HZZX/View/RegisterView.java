package HZZX.View;

import HZZX.utils.DatabaseConnection;
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
        Font font = new Font("alias", Font.PLAIN, 22);

        //加载图片
        ImageIcon icon=new ImageIcon("image5.png");
//
//        //将图片放入label中
        JLabel label=new JLabel(icon);
//
//        //设置label的大小
        label.setBounds(0,0,800,533);
//
//        //获取窗口的第二层，将label放入
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
//
//        //获取frame的顶层容器,并设置为透明
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);

        //初始化组件
        jf = new JFrame();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();

        jl1 = new JLabel("请输入用户名：");
        jtf1 = new JTextField(10);
        jl1.setFont(font);
        jtf1.setFont(font);
        jtf1.setToolTipText("用户名必须为3-11位字母_或者数字");
        jl2 = new JLabel("请输入密码：");
        jtf2 = new JPasswordField(10);
        jl2.setFont(font);
        jtf2.setFont(font);
        jtf2.setToolTipText("密码必须为6位字母_或者数字");

        jl3 = new JLabel("注册界面");

        jb1 = new JButton("返回");
        jb1.setBackground(Color.WHITE);
        jb1.setFont(font);
        jb1.setToolTipText("点我返回登录界面哦");
        jb2 = new JButton("注册");
        jb2.setBackground(Color.WHITE);
        jb2.setFont(font);
        jb1.addActionListener(this);
        jb2.addActionListener(this);


        jrb1 = new JRadioButton("管理员");
        jrb1.setFont(font);
        jrb2 = new JRadioButton("客户");
        jrb2.setFont(font);
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

        //必须设置为透明的。否则看不到图片
        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        jp4.setOpaque(false);
        jp5.setOpaque(false);

        this.add(jp4);
        this.add(jp1);
        this.add(jp2);
        this.add(jp5);
        this.add(jp3);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 2));
        this.setBounds(400, 150, icon.getIconWidth(), icon.getIconHeight());
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
        String account = "\\w{3,6}"; //管理员用户名必须是3-6位
        boolean flag1 = jtf1.getText().matches(account);

        String password = "\\w{6}"; //密码必须是6位
        boolean flag2 = jtf2.getText().matches(password);

        if (flag1 == false) {
            JOptionPane.showMessageDialog(null, "用户名填写错误,必须为3-6位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
            jtf1.setText("");
            jtf2.setText("");
        } else if (flag2 == false) {
            JOptionPane.showMessageDialog(null, "密码填写错误,必须为6位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
            jtf1.setText("");
            jtf2.setText("");
        } else {
            DatabaseConnection.getConnection();
            fcd.zhuceverify1(jtf1.getText());

            this.jtf1.setText("");
            this.jtf2.setText("");
        }
    }

    // 用户注册方法
    public void zhuce2() {
        String account = "\\w{7,11}"; //客户用户名必须是7-11位
        boolean flag1 = jtf1.getText().matches(account);

        String password = "\\w{6}"; //密码必须是6位
        boolean flag2 = jtf2.getText().matches(password);

        if (flag1 == false) {
            JOptionPane.showMessageDialog(null, "用户名填写错误,必须为7-11位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
            jtf1.setText("");
        } else if (flag2 == false) {
            JOptionPane.showMessageDialog(null, "密码填写错误,必须为6位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
            jtf2.setText("");
        } else {
            DatabaseConnection.getConnection();
            fcd.zhuceverify1(jtf1.getText());
            this.jtf1.setText("");
            this.jrb2.setText("");
        }
    }
}
