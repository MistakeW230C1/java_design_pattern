package com.mistake.day9.demo5;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class StaVisitor implements IVisitor {
    public void visit(BanJi obj, JPanel panel) {
        String title[] = {"成绩区间", "人数" };
        String d[][] = new String[11][2];
        d[0][0] = "<200";
        for (int i = 0; i < d.length; i++) {
            d[i][0] = "" + (200 + (i - 1) * 10) + "~" + (200 + i * 10);
        }
        int num[] = new int[11];
        Vector<Student> v = obj.getV();
        for (int i = 0; i < v.size(); i++) {
            Student s = v.get(i);
            int total = s.chinese + s.math + s.english;
            if (total < 200) {
                num[0]++;
            } else {
                num[(total - 200) / 10 + 1]++;
            }
        }
        for (int i = 0; i < num.length; i++) {
            d[i][1] = "" + num[i];
        }
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        JTable tab = new JTable(d, title);
        JScrollPane scr = new JScrollPane(tab);
        panel.add(scr);
        panel.updateUI();
    }
}
