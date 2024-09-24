package com.mistake.day11.demo6;

import com.mistake.day4.demo1.DbProc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class DbEntry implements IEntry {
    private String tabName;

    private int total;

    private int cursor;

    @Override
    public int getTotal() {
        return total;
    }

    @Override
    public int getCursor() {
        return cursor;
    }


    @Override
    public void entry(String strFile) throws Exception {
        FileReader in = new FileReader(strFile);
        BufferedReader in2 = new BufferedReader(in);
        // 读取第一行数据 获取到表名
        tabName = in2.readLine();
        // 读取第二行数据 获取到记录总数
        total = Integer.parseInt(in2.readLine());

        DbProc dbProc = new DbProc();
        Connection conn = dbProc.connect();
        Statement stm = conn.createStatement();
        String s, strSQl, d[];
        // 读取第三行开始至文件尾是数据记录ø
        while ((s = in2.readLine()) != null) {
            cursor++;
            d = s.split("\t");
            strSQl = "insert into " + tabName + " values(";
            for (int i = 0; i < d.length; i++) {
                if (i < d.length - 1) {
                    strSQl += "'" + d[i] + "'";
                } else {
                    strSQl += "'" + d[i] + "')";
                }
                stm.executeUpdate(strSQl);
            }
            stm.close();
            conn.close();
            in2.close();
            in.close();
        }
    }
}
