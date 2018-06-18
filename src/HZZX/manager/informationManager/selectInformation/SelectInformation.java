package HZZX.manager.informationManager.selectInformation;

import javax.swing.*;

/*
查询会展信息
 */
public class SelectInformation extends JFrame {

    public static void selectInformation(){
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
}
