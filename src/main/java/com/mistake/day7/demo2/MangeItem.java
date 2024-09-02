package com.mistake.day7.demo2;

import com.mistake.day4.demo1.DbProc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 * @author leoliu
 */
public class MangeItem {
    /**
     * 代理项目集合
     */
    Vector<ProxyItem> proxyItems = new Vector<>();

    public void firstSearch() throws Exception {
        // 第一级 查询sql语句
        String strSql = "select account,name,project from project";
        DbProc dbProc = new DbProc();
        Connection connect = dbProc.connect();
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(strSql);
        while (resultSet.next()) {
            ProxyItem proxyItem = new ProxyItem(new RealItem());
            proxyItem.setAccount(resultSet.getString("account"));
            proxyItem.setAccount(resultSet.getString("name"));
            proxyItem.setAccount(resultSet.getString("project"));
            proxyItems.add(proxyItem);
        }
        resultSet.close();
        statement.close();
        dbProc.close();
    }
}
