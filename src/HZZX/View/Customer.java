package HZZX.View;

import HZZX.customer.placeReserve.*;
import HZZX.customer.shopping.BuyThings;
import HZZX.customer.shopping.DeleteThings;
import HZZX.customer.shopping.SelectThings;
import HZZX.customer.shopping.UpdateThings;
import HZZX.customer.ticket.BuyTicket;
import HZZX.customer.ticket.DeleteTicket;
import HZZX.customer.ticket.SelectTicket;
import HZZX.customer.ticket.UpdateTicket;
import HZZX.manager.business.SelectBusiness;
import HZZX.manager.place.SelectPlace;
import HZZX.manager.selectInformation.ManagerSelect;
import HZZX.manager.thing.SelectThing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Customer extends JFrame implements ActionListener {

    JMenuBar jMenuBar;
    JMenu jm1,jm2,jm3,jm4,jm5;
    JMenuItem jmt1,jmt2,jmt3,jmt4,jmt5,jmt6,jmt7,jmt8,jmt9,jmt10,jmt11,jmt12,jmt13,jmt14,jmt15,jmt16;
    JPanel jp1;
    JLabel jl1;

    public Customer() {

        //加载图片
        ImageIcon icon=new ImageIcon("image.png");

        //将图片放入label中
        JLabel label=new JLabel(icon);

        //设置label的大小
        label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());

        //获取窗口的第二层，将label放入
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));

        //获取frame的顶层容器,并设置为透明
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);
        jMenuBar = new JMenuBar();
        jm1 = new JMenu("展馆预约");
        jm1.addSeparator();
        jm2 = new JMenu("展会门票");
        jm2.addSeparator();
        jm3 = new JMenu("展品采购");
        jm3.addSeparator();
        jm4 = new JMenu("会展信息查询");

        jmt5 = new JMenuItem("预定门票");
        jmt6 = new JMenuItem("查询门票");
        jmt7 = new JMenuItem("取消订单");
        jmt8 = new JMenuItem("修改门票信息");

        jmt1 = new JMenuItem("预约展馆");
        jmt2 = new JMenuItem("查询预约信息");
        jmt3 = new JMenuItem("取消预约");
        jmt4 = new JMenuItem("修改预约信息");

        jmt9 = new JMenuItem("展品采购");
        jmt10 = new JMenuItem("查询采购信息");
        jmt11 = new JMenuItem("取消订单");
        jmt12 = new JMenuItem("修改订单信息");

        jmt13  =new JMenuItem("会展信息查询");
        jmt14 = new JMenuItem("展馆查询");
        jmt15 = new JMenuItem("展商查询");
        jmt16 = new JMenuItem("展品查询");

        jp1 = new JPanel();
        jl1 = new JLabel("欢迎使用会展中心管理系统");
        Font font = new Font("alias", Font.PLAIN, 28);
        jl1.setFont(font);
        jp1.add(jl1,BorderLayout.CENTER);


        jm1.add(jmt1);
        jm1.add(jmt2);
        jm1.add(jmt3);
        jm1.add(jmt4);

        jm2.add(jmt5);
        jm2.add(jmt6);
        jm2.add(jmt7);
        jm2.add(jmt8);

        jm3.add(jmt9);
        jm3.add(jmt10);
        jm3.add(jmt11);
        jm3.add(jmt12);

        jm4.add(jmt13);
        jm4.add(jmt14);
        jm4.add(jmt15);
        jm4.add(jmt16);

        jMenuBar.add(jm1);
        jMenuBar.add(jm2);
        jMenuBar.add(jm3);
        jMenuBar.add(jm4);
        setJMenuBar(jMenuBar);

        click();
        this.add(jp1);
        this.setVisible(true);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 200, 800, 500);
        //this.setBounds(200,200,icon.getIconWidth(),icon.getIconHeight());
    }

    public void click(){
        jmt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InsertReserve();
            }
        });

        jmt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectReserve();
            }
        });

        jmt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteReserve();
            }
        });

        jmt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateReserve();
            }
        });

        jmt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BuyTicket();
            }
        });

        jmt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectTicket();
            }
        });

        jmt7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteTicket();
            }
        });

        jmt8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateTicket();
            }
        });

        jmt9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BuyThings();
            }
        });

        jmt10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectThings();
            }
        });

        jmt11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteThings();
            }
        });

        jmt12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateThings();
            }
        });

        jmt13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManagerSelect();
            }
        });

        jmt14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectPlace();
            }
        });

        jmt15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectBusiness();
            }
        });

        jmt16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectThing();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
