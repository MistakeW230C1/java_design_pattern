package com.mistake.day5.demo7;


import com.mistake.day4.demo1.DbProc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Observable;
import java.util.Observer;

public class StructObserver implements Observer {
    /**
     * 表结构观察者类与JTable相关
     */
    private JTable table;

    public StructObserver(JTable table) {
        this.table = table;
    }

    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject) o;
        String strSql = "select * from " + subject.getTableName();
        DbProc dbProc = new DbProc();
        try {
            Connection connection = dbProc.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(strSql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            String title[] = {"字段名称","类型","大小"};
            String data[][] = new String[resultSetMetaData.getColumnCount()][title.length];
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                data[i][0] = resultSetMetaData.getColumnName(i+1);
                data[i][1] = ""+ resultSetMetaData.getColumnType(i+1);
                data[i][2] = ""+ resultSetMetaData.getPrecision(i+1);
            }
            statement.close();
            connection.close();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setDataVector(data,title);
        } catch (Exception e) {

        }
    }
}
