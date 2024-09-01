package com.mistake.day6.demo7;

import com.mistake.day4.demo1.DbProc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 表格功能实现类
 */
public class TableShow extends AbstractShow {

    /**
     * 形成表头信息HTML字符串
     */
    private String getHeader() {
        // para 来自于抽象父类AbstractShow
        String title[] = para.getTitle();
        String s = "<tr>";
        for (int i = 0; i < title.length; i++) {
            s += "<th>" + title[i] + "</th>";
        }
        s += "</tr>";
        return s;
    }

    /**
     * 形成数据显示HTML字符串
     */
    private String getData(String no) throws Exception {
        String s = "";
        String strSql = para.getPerSql() + "'" + no + "'";
        DbProc dbProc = new DbProc();
        Connection connection = dbProc.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(strSql);
        if (resultSet.next()) {
            s = "<tr>";
            for (int i = 0; i < para.getTitle().length; i++) {
                s += "<td>" +resultSet.getString(i) +"</td>";
            }
            s += "</tr>";
        }
        statement.close();
        connection.close();
        return s;
    }

    @Override
    public String show(String no) throws Exception {
        String s = "<table border ='1'>";
        s += getHeader();
        s += getData(no);
        s +="</table>";
        return s;
    }
}
