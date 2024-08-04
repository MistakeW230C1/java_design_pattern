package com.mistake.day4.demo2;

import java.sql.*;
import java.util.List;
import java.util.Vector;

public class DbProc {
    private String strDriver = "com.mysql.cj.jdbc.Driver";
    private String strDb = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    private String userName = "root";
    private String password = "root";

    private Connection connection;

    public Connection connect() {
        try {
            Class.forName(strDriver);
            connection = DriverManager.getConnection(strDb, userName, password);
            System.out.println("数据库连接成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC驱动未找到！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败！");
        }
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
