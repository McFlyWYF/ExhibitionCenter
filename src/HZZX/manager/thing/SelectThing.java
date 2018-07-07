package HZZX.manager.thing;

import HZZX.customer.shopping.BuyThings;
import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SelectThing extends JFrame implements ActionListener {

    JTable jt;
    JScrollPane js = new JScrollPane();
    Vector columnNames = null;
    Vector rowData = null;
    Connection con = null;
    ResultSet rs;

    JButton jb;
    JPanel jp;

    public SelectThing(){

        columnNames = new Vector();
        rowData = new Vector();
        columnNames.add("展品编号");
        columnNames.add("名称");
        columnNames.add("类别");
        columnNames.add("售价");
        columnNames.add("规格");
        columnNames.add("是否出售");

        try{
            con = DatabaseConnection.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select * from Thing");
            rs = ps.executeQuery();
            while (rs.next()){
                Vector vector = new Vector();
                vector.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
                vector.add(rs.getString(5));
                vector.add(rs.getString(6));
                rowData.add(vector);
            }
            System.out.println("OK");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                rs.close();
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        jt = new JTable(rowData,columnNames);
        js = new JScrollPane(jt);

        jb = new JButton("购买");
        jb.addActionListener(this);
        jp = new JPanel();
        jp.add(jb);
        jp.setLocation(100,100);

        this.add(js);
        this.add(jp);
        this.setTitle("查询");
        this.setLayout(new GridLayout(2,2));

        this.setBounds(630,300,850,500);
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "购买"){
            new BuyThings();
            dispose();
        }
    }
}
