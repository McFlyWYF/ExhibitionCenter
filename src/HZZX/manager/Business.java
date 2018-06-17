package HZZX.manager;

import javax.swing.*;
import java.awt.*;

public class Business extends JFrame{


    JPanel jp1;
    JButton jb1;

    public Business() {


        jb1 = new JButton("测试");
        jp1 = new JPanel();
        jp1.add(jb1);
        this.add(jp1);

        this.setVisible(true);
//        this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(3, 1));
        this.setBounds(300, 200, 600, 380);
    }
}
