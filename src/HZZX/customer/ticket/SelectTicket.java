package HZZX.customer.ticket;

import HZZX.manager.selectInformation.Query;
import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SelectTicket extends JFrame{

    JTable jt;
    JScrollPane js = new JScrollPane();
    Vector columnNames = null;
    Vector rowData = null;
    Connection con = null;
    ResultSet rs;

    public SelectTicket(){

        columnNames = new Vector();
        rowData = new Vector();
        columnNames.add("订单编号");
        columnNames.add("姓名");
        columnNames.add("性别");
        columnNames.add("职业");
        columnNames.add("会展编号");
        columnNames.add("门票价格");


        try{
            con = DatabaseConnection.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select Ano,Aname,Asex,Awork,Ticket.Mno,Mprice from Ticket,Meeting where Ticket.Mno = Meeting.Mno");
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

        this.add(js);
        this.setTitle("查询");
        this.setLayout(new GridLayout(2,2));

        this.setSize(850,500);
        this.setVisible(true);
        this.setResizable(false);
    }
}
