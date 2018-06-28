package HZZX.manager.meetingInformation;

import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

    JButton select;
    JPanel jp1,jp2;
    JTextField jtf;
    JRadioButton jr1,jr2;
    ButtonGroup group;


    public static void main(String[] args) {
        SelectInformation select = new SelectInformation();
    }

    public SelectInformation() {

//        select = new JButton("查询");
//        jtf = new JTextField(8);
//        jp1 = new JPanel();
//        jp1.add(jtf);
//        jp1.add(select);
//
//        jr1 = new JRadioButton("时间");
//        jr2 = new JRadioButton("类别");
//
//        group = new ButtonGroup();
//        group.add(jr1);
//        group.add(jr2);
//
//        jp2 = new JPanel();
//        jp2.add(jr1);
//        jp2.add(jr2);

        columnNames = new Vector();
        rowData = new Vector();
        columnNames.add("展会编号");
        columnNames.add("展会名称");
        columnNames.add("展品名称");
        columnNames.add("展商姓名");
        columnNames.add("地址");
        //columnNames.add("地址");
        columnNames.add("时间");
        columnNames.add("类别");
        columnNames.add("门票价格");

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select Mno,Mname,Thing.Tname,Business.Bname,Place.Pname,Mtime,Thing.Tkind,Mprice from Meeting,Thing,Place,Business where Meeting.Tno = Thing.Tno and Meeting.Pno = Place.Pno and Meeting.Bno = Business.Bno");
            rs = ps.executeQuery();
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
                vector.add(rs.getString(5));
                vector.add(rs.getString(6));
                vector.add(rs.getString(7));
                vector.add(rs.getString(8));
                //vector.add(rs.getString(9));
                rowData.add(vector);
            }
            System.out.println("OK");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        jt = new JTable(rowData, columnNames);
        js = new JScrollPane(jt);

        this.add(js);
        this.setTitle("查询");
        this.setLayout(new GridLayout(1, 1));

        this.setBounds(450, 300, 1200, 600);
        this.setVisible(true);
    }
}
