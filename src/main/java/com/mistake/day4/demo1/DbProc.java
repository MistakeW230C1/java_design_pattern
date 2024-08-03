package com.mistake.day4.demo1;

import java.sql.*;
import java.util.List;
import java.util.Vector;

public class DbProc {
    private String strDriver = "com.mysql.jdbc.Driver";
    private String strDb = "jdbc:mysql://localhost:3306/leo";
    private String userName = "root";
    private String password = "root";

    private Connection connection;

    public Connection connect() throws Exception {
        Class.forName(strDriver);
        connection = DriverManager.getConnection(strDb, userName, password);
        return connection;
    }

    public int executeUpdate(String sql) throws Exception {
        Statement stm = connection.createStatement();
        int n = stm.executeUpdate(sql);
        stm.close();
        return n;
    }

    public List executeQuery(String strSQL) throws Exception {
        List list = new Vector();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(strSQL);
        ResultSetMetaData rsmd = rst.getMetaData();
        while (rst.next()) {
            Vector unit = new Vector();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                unit.add(rst.getString(i));
            }
            list.add(unit);
        }
        return list;
    }

    public void close() throws Exception {
        connection.close();
    }

}
