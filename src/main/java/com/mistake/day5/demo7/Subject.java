package com.mistake.day5.demo7;

import com.mistake.day4.demo1.DbProc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Observable;
import java.util.Vector;

public class Subject extends Observable implements MouseListener {
    /**
     * 主题中心数据是表名称
     */
    private String tableName;

    private JTable table;

    public Subject(JTable table) throws Exception {
        this.table = table;
        // 数据库工具类
        DbProc dbProc = new DbProc();
        Connection connection = dbProc.connect();
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        String s[] = {"table"};
        ResultSet rs = databaseMetaData.getTables(null,null,null,s);
        Vector<String> vector = new Vector<>();
        while(rs.next()){
            vector.add(rs.getString("TABLE_NAMe"));
        }
        connection.close();

        String data[][] = new String[vector.size()][1];
        for (int i =0 ;i <vector.size();i++){
            data[i][0] = vector.get(i);
        }
        String title [] ={"表名称"};
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setDataVector(data,title);
        // 主题类必须注册鼠标事件
        table.addMouseListener(this);
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        System.out.println(tableName);
        this.tableName = tableName;
        setChanged();
        notifyObservers();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row =table.getSelectedRow();
        setTableName((String) table.getValueAt(row,0));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
