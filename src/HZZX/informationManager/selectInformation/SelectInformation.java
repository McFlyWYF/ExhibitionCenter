package HZZX.informationManager.selectInformation;

import HZZX.informationManager.selectInformation.Query;
import HZZX.manager.Information;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
查询会展信息
 */
public class SelectInformation extends JFrame implements ActionListener {
    JButton jb1,jb2;
    JPanel jp1;

    public SelectInformation(){

        jb1 = new JButton("查询");
        jb1.addActionListener(this);

        jb2 = new JButton("返回");
        jb2.addActionListener(this);

        jp1 = new JPanel();
        jp1.add(jb1);
        jp1.add(jb2);

        this.add(jp1);
        this.setVisible(true);
//        this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(10,8));
        this.setBounds(300, 200, 600, 380);
    }

    public void selectInformation(){
        String[] tableHead;
        String[][] content;
        JTable table;
        JFrame win = new JFrame("会展信息查询");
        Query query = new Query();
        query.setSQL("select * from Meeting");
        content = query.getRecord();
        tableHead = query.getColumnName();
        table = new JTable(content,tableHead);
        win.add(new JScrollPane(table));
        win.setBounds(300,200,800,600);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回"){
            this.dispose();
            new Information();
        }else if (e.getActionCommand() == "查询"){
            selectInformation();
        }
    }
}
