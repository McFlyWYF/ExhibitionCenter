package HZZX.View;

import HZZX.utils.Facade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainView extends JFrame implements ActionListener {

    //门面模式对象
    Facade fcd = new Facade();

    //定义登录界面的组件
    JButton jb1, jb2, jb3 = null;
    JRadioButton jrb1, jrb2 = null;
    JPanel jp1, jp2, jp3 ,jp4 ,jp5= null;
    JTextField jtf = null;
    JLabel jlb1, jlb2 ,jlb3 = null;
    JPasswordField jpf = null;
    ButtonGroup group;


    public static void main(String[] args) {
        MainView mainView = new MainView();
    }

    public MainView() {
        //创建组件
        jb1 = new JButton("登录");
        jb2 = new JButton("注册");
        jb3 = new JButton("退出");

        //设置监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);


        jlb3 = new JLabel("欢迎使用会展中心管理系统");
        jlb1 = new JLabel("用户名：");
        jlb2 = new JLabel("密    码：");

        jrb1 = new JRadioButton("管理员");
        jrb2 = new JRadioButton("客户");
        group = new ButtonGroup();
        group.add(jrb1);
        group.add(jrb2);

        jtf = new JTextField(10);
        jpf = new JPasswordField(10);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();

        jp4.add(jlb3);
        jp1.add(jlb1);
        jp1.add(jtf);

        jp2.add(jlb2);
        jp2.add(jpf);


        jp3.add(jp4);
        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);

        jp5.add(jrb1);
        jp5.add(jrb2);

        this.add(jp4);
        this.add(jp1);
        this.add(jp2);
        this.add(jp5);
        this.add(jp3);

        this.setVisible(true);
        //this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 200, 600, 380);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //监听各个按钮
        if (e.getActionCommand() == "退出") {
            System.exit(0);
        } else if (e.getActionCommand() == "登录") {
            //进行判断，为空则不进行登录操作。
            if (jtf.getText().isEmpty() || jpf.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "请输入用户名和密码", "提示信息", JOptionPane.WARNING_MESSAGE);
            else {
                //调用登录方法
                if (jrb1.isSelected()) {
                    login1();
                }else if (jrb2.isSelected()){
                    login2();
                }
            }
        } else if (e.getActionCommand() == "注册") {
            //调用注册方法
            this.Regis();
        }

    }

    //注册方法
    public void Regis() {
        this.dispose();  //关闭当前界面
        new RegisterView();   //打开新界面
    }

    //管理员登录方法
    public void login1() {

        //使用门面模式
        fcd.ConnectSQL();
        fcd.SQLverify1(jtf.getText(), jpf.getText());

        this.jtf.setText("");
        this.jpf.setText("");

        this.dispose();
        new ManagerMain();
    }

    //客户登录方法
    public void login2() {

        //使用门面模式
        fcd.ConnectSQL();
        fcd.SQLverify2(jtf.getText(), jpf.getText());

        this.jtf.setText("");
        this.jpf.setText("");

        this.dispose();
        new Customer();
    }
}