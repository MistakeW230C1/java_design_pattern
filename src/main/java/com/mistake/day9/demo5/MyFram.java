package com.mistake.day9.demo5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.Vector;

public class MyFram extends JFrame {
    // 定义年级成员变量
    Grade grade = new Grade();
    // 定义主界面 右侧内容面板
    JPanel contentPane = new JPanel();
    // 主界面选择班级下拉框对象
    JComboBox comboBox;
    // "成绩显示" 按钮响应方法
    ActionListener a1 = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String factor = (String) comboBox.getSelectedItem();
            BanJi obj = grade.map.get(factor);
            Vector<Student> v = obj.getV();
            String title[] = {"学号", "姓名", "语文", "数学", "英语"};
            String d[][] = new String[v.size()][5];
            for (int i = 0; i < v.size(); i++) {
                Student unit = v.get(i);
                d[i][0] = unit.stuNo;
                d[i][1] = unit.name;
                d[i][2] = String.valueOf(unit.chinese);
                d[i][3] = String.valueOf(unit.math);
                d[i][4] = String.valueOf(unit.english);
            }
            showTable(d, title);
        }
    };

    // "成绩显示" 按钮响应方法
    ActionListener a2 = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String factor = (String) comboBox.getSelectedItem();
            BanJi obj = grade.map.get(factor);
            Vector<Student> v = obj.getV();
            obj.statistics(new StaVisitor(), contentPane);
        }
    };

    public void showTable(String d[][], String title[]) {
        contentPane.removeAll();
        contentPane.setLayout(new BorderLayout());
        JTable table = new JTable(d, title);
        JScrollPane scr = new JScrollPane(table);
        contentPane.add(scr);
        contentPane.updateUI();
    }

    public void init(String strFile) {
        // 读数据文件，形成数据集合
        grade.readFile(strFile);
        setLayout(null);
        Set<String> set = grade.map.keySet();
        Object info[] = set.toArray();
        comboBox = new JComboBox<>(info);
        comboBox.setBounds(10, 10, 150, 30);
        add(comboBox);

        JButton dispBtn = new JButton("成绩显示");
        JButton infoBtn = new JButton("统计功能");
        dispBtn.addActionListener(a1);
        dispBtn.addActionListener(a2);
        dispBtn.setBounds(10, 60, 150, 30);
        dispBtn.setBounds(10, 110, 150, 30);

        add(dispBtn);
        add(infoBtn);

        contentPane.setBounds(170, 10, 420, 280);
        contentPane.setBorder(BorderFactory.createEtchedBorder());
        add(contentPane);

        this.setSize(600, 320);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
