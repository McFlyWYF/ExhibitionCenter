package HZZX.manager.informationManager.selectInformation;

import HZZX.utils.DatabaseConnection;

import javax.swing.*;
import java.sql.*;

public class Query {

    String SQL;
    String[] columnName;
    String[][] record;

    public void setSQL(String SQL){
        this.SQL = SQL.trim();
    }

    public String[] getColumnName(){
        if (columnName == null){
            JOptionPane.showMessageDialog(null,"记录为空","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("先插入记录");
        }
        return columnName;
    }

    public String[][] getRecord(){
        startQuery();
        return record;
    }

    private void startQuery() {
        Connection con;
        Statement st;
        ResultSet rs;

        try {
            con = DatabaseConnection.getConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(SQL);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();//字段数目
            columnName = new String[columnCount];
            for (int i = 1;i <= columnCount;i++){
                columnName[i-1] = metaData.getCatalogName(i);
            }

            rs.last();
            int recordAmount = rs.getRow();//结果集中的记录数目
            record = new String[recordAmount][columnCount];
            int i = 0;
            rs.beforeFirst();
            while (rs.next()){
                for (int j = 1;j <= columnCount;j++){
                    record[i][j-1] = rs.getString(j);
                }
                i++;
            }
            con.close();
            System.out.println("数据库关闭成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
