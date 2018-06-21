package HZZX.customer.placeReserve;

import HZZX.manager.selectInformation.Query;
import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SelectReserve extends JFrame{

    JTable jt;
    JScrollPane js = new JScrollPane();
    Vector columnNames = null;
    Vector rowData = null;
    Connection con = null;
    ResultSet rs;

    public SelectReserve(){

        columnNames = new Vector();
        rowData = new Vector();
        columnNames.add("订单编号");
        columnNames.add("展馆编号");
        columnNames.add("展商编号");
        columnNames.add("展商姓名");
        columnNames.add("时间");
        columnNames.add("展位数");


        try{
            con = DatabaseConnection.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select RNO,Place.Pno,Bno,Bname,Rtime,Rnum from Reserve,Place where Reserve.Pno = Place.Pno");
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
