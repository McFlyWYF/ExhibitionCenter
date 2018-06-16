package HZZX.informationManager;

import HZZX.manager.Information;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
查询会展信息
 */
public class SelectInformation extends JFrame implements ActionListener {
    JButton jb1;
    JPanel jp1;

    public SelectInformation(){
        jb1 = new JButton("返回");
        jb1.addActionListener(this);

        jp1 = new JPanel();
        jp1.add(jb1);

        this.add(jp1);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(10,8));
        this.setBounds(300, 200, 600, 380);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回"){
            this.dispose();
            new Information();
        }
    }
}
