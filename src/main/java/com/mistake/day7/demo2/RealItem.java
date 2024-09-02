package com.mistake.day7.demo2;

import com.mistake.day4.demo1.DbProc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RealItem implements IItem {

    private String account;

    private String name;

    private String project;

    private String content;

    private String plan;

    @Override
    public String getAccount() {
        return null;
    }

    @Override
    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProject() {
        return project;
    }

    @Override
    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getPlan() {
        return plan;
    }

    /**
     * 填充本项目content以及plan字段
     *
     * @throws Exception
     */
    @Override
    public void itemFill() throws Exception {
        String strSQL = "select content,plan from project where account = '" + account + "'";
        DbProc dbProc = new DbProc();
        Connection connect = dbProc.connect();
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(strSQL);
        resultSet.next();
        // 填充content内容
        content = resultSet.getString("content");
        // 填充plan内容
        plan = resultSet.getString("plan");
        resultSet.close();
        statement.close();
        dbProc.close();
    }
}
