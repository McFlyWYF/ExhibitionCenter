package HZZX.manager.meetingInformation;

import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SelectInformation extends JFrame {

    JTable jt;
    JScrollPane js = new JScrollPane();
    Vector columnNames = null;
    Vector rowData = null;
    Connection con = null;
    ResultSet rs;

    public static void main(String[] args) {
        SelectInformation select = new SelectInformation();
    }

    public SelectInformation(){

        columnNames = new Vector();
        rowData = new Vector();
        columnNames.add("展会编号");
        columnNames.add("展会名称");
        columnNames.add("展商编号");
        columnNames.add("展品编号");
        columnNames.add("展品名称");
        columnNames.add("地址");
        columnNames.add("时间");
        columnNames.add("类型");
        columnNames.add("门票价格");


        try{
            con = DatabaseConnection.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select * from Meeting");
            rs = ps.executeQuery();
            while (rs.next()){
                Vector vector = new Vector();
                vector.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
                vector.add(rs.getString(5));
                vector.add(rs.getString(6));
                vector.add(rs.getString(7));
                vector.add(rs.getString(8));
                vector.add(rs.getString(9));
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
        this.setLayout(new GridLayout(1,2));

        this.setBounds(450,300,1200,600);
        this.setVisible(true);
        //this.setResizable(false);
    }
}
