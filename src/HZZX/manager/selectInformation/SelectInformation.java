package HZZX.manager.selectInformation;

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

/*
管理员查询会展信息
 */
public class SelectInformation extends JFrame {

    JTable jt;
    JScrollPane js = new JScrollPane();
    Vector columnNames = null;
    Vector rowData = null;
    Connection con = null;
    ResultSet rs;
    JPanel jp1,jp2,jp3;
    JLabel jl1;
    JComboBox jc;
    JTextField jt1;
    JButton jb1,jb2;

   /* public static void init() {

        jl1 = new JLabel("选择查询条件");
        String str[] = {"展会名称","展品名称","时间"};
        jc = new JComboBox(str);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jp1.add(jl1);
        jp2.add(jc);

        jt1 = new JTextField(8);

        jb1 = new JButton("查询");
        jb2 = new JButton("返回");
        jp2.add(jt1);
        jp3.add(jb1);
        jp3.add(jb2);

        JPanel jp = new JPanel();
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
        colum123nNames.add("门票价格");


        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select * from Meeting where Mname = ?");
            ps.setString(1,jt1.getText());
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
                vector.add(rs.getString(9));

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
        this.add(jp);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.setTitle("查询");
        this.setLayout(new GridLayout(2, 1));
        this.setSize(850, 600);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "查询"){
            init();
        }
    }
    */
}
