package HZZX.customer.ticket;

import HZZX.manager.informationManager.selectInformation.Query;

import javax.swing.*;

public class SelectTicket extends JFrame{

    public static void selectInformation(){
        String[] tableHead;
        String[][] content;
        JTable table;
        JFrame win = new JFrame("购票信息查询");
        Query query = new Query();
        query.setSQL("select * from Ticket");
        content = query.getRecord();
        tableHead = query.getColumnName();
        table = new JTable(content,tableHead);
        win.add(new JScrollPane(table));
        win.setBounds(300,200,800,600);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
