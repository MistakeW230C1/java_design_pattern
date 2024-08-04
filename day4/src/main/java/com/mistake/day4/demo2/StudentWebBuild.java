package com.mistake.day4.demo2;

import java.util.List;
import java.util.Vector;

public class StudentWebBuild implements IWebBuilder {
    private String name, age, major, depart;

    @Override
    public void getData(String user) {
        String sql = "select name,age,major,depart from student where user ='" + user + "'";
        DbProc dbProc = new DbProc();
        try {
            dbProc.connect();
            List list = dbProc.executeQuery(sql);
            dbProc.close();
            Vector vector = (Vector) list.get(0);
            name = (String) vector.get(0);
            age = (String) vector.get(1);
            major = (String) vector.get(2);
            depart = (String) vector.get(3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getUI() {
        String s = "姓名:<input type ='text' id='name' value ='" + name + "'/<br>" +
                "年龄:<input type ='text' id='age' value ='" + age + "'/<br>" +
                "专业:<input type ='text' id='major' value ='" + major + "'/<br>" +
                "学院:<input type ='text' id='depart' value ='" + depart + "'/<br>" +
                "<input type ='button' id ='myupdate' value ='更新'";
        return s;
    }
}
