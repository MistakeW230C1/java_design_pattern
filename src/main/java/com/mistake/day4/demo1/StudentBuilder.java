package com.mistake.day4.demo1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

/**
 * @author leoliu
 */
public class StudentBuilder extends UIBuilder implements ActionListener {
    String user;

    /**
     * 姓名
     */
    JTextField studName = new JTextField(10);

    /**
     * 年龄
     */
    JTextField studAge = new JTextField(10);

    /**
     * 专业
     */
    JTextField studMajor = new JTextField(10);

    /**
     * 学院
     */
    JTextField studDepart = new JTextField(10);

    /**
     * 该按钮需要注册事件
     */
    JButton updateBtn = new JButton("更新");


    /**
     * 界面生成方法
     */
    @Override
    public void addUI() {
        JPanel center = new JPanel();
        JPanel south = new JPanel();
        // 第一列垂直box对象b
        Box b = Box.createVerticalBox();

        b.add(new JLabel("姓名"));
        b.add(Box.createVerticalStrut(8));

        b.add(new JLabel("年龄"));
        b.add(Box.createVerticalStrut(8));

        b.add(new JLabel("专业"));
        b.add(Box.createVerticalStrut(8));

        b.add(new JLabel("学院"));
        b.add(Box.createVerticalStrut(8));
        Box b2 = Box.createVerticalBox();
        b2.add(studName);
        b2.add(Box.createVerticalStrut(8));

        b2.add(studAge);
        b2.add(Box.createVerticalStrut(8));

        b2.add(studMajor);
        b2.add(Box.createVerticalStrut(8));

        b2.add(studDepart);
        b2.add(Box.createVerticalStrut(8));
        center.add(b);
        center.add(b2);

        south.add(updateBtn);
        panel.setLayout(new BorderLayout());
        panel.add(center, BorderLayout.CENTER);
        panel.add(south, BorderLayout.SOUTH);
    }

    @Override
    public void registerMsg() {
        //消息响应家在本类中，故实现ActionListener接口
        updateBtn.addActionListener(this);
    }

    @Override
    public void initialData(String user) {
        this.user = user;
        String strSql = "select  name,age,major,depart from student where user ='" + user + "'";
        DbProc dbobj = new DbProc();
        try {
            dbobj.connect();
            List l = dbobj.executeQuery(strSql);
            Vector vector = (Vector) l.get(0);
            studName.setText((String) vector.get(0));
            studAge.setText((String) vector.get(1));
            studMajor.setText((String) vector.get(2));
            studDepart.setText((String) vector.get(3));
            dbobj.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent agr0) {
        String name = studName.getText();
        String age = studAge.getText();
        String major = studMajor.getText();
        String depart = studDepart.getText();
        System.out.println(depart);
        String strSQL = "update student set name='" + name + "',age=" + age + ",major='" + major + "',depart='" + depart + "'" + "where user='" + user + "'";
        try {
            DbProc dbobj = new DbProc();
            dbobj.connect();
            dbobj.executeUpdate(strSQL);
            dbobj.close();
        } catch (Exception e) {

        }
    }
}
