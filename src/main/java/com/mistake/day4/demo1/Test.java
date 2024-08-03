package com.mistake.day4.demo1;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        JFrame frm = new JFrame();
        UIBuilder ub = new StudentBuilder();
        Director director = new Director(ub);
        JPanel panel = director.build("1");
        frm.add(panel);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.pack();
        frm.setVisible(true);
    }
}