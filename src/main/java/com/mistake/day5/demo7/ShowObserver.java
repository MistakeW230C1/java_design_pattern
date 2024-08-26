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

public class ShowObserver implements Observer {
    /**
     * 表结构观察者类与JTable相关
     */
    private JTable table;

    public ShowObserver(JTable table) {
        this.table = table;
    }

    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject) o;
        String strSql = "select * from " + subject.getTableName();
        DbProc dbProc = new DbProc();
        try {
            Connection connection = dbProc.connect();
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(strSql);
            // 游标只想最后一条记录
            resultSet.last();
            // 获得记录总数
            int rows = resultSet.getRow();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            // 获得查询的列名称信息,保存到title数组中
            String title[] = new String [resultSetMetaData.getColumnCount()];
            String data[][] = new String[rows][title.length];
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                title[i] = resultSetMetaData.getColumnName(i + 1);

            }
            // 获得查询的二维记录集 data[][]
            resultSet.first();
            for (int i = 0; i <rows ; i++) {
                for (int j = 0; j < title.length; j++) {
                    data[i][j] = resultSet.getString(j+1);
                }
            }
            statement.close();
            connection.close();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setDataVector(data, title);
        } catch (Exception e) {

        }
    }
}
