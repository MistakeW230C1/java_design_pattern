package com.mistake.day10.demo4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    JPanel content = new JPanel();

    ActionListener a1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            content.removeAll();
            content.setLayout(new FlowLayout());
            content.add(new JButton("1"));
            content.add(new JButton("2"));
            content.add(new JButton("3"));
            content.add(new JButton("4"));
            content.add(new JButton("5"));
            content.updateUI();
        }
    };

    ActionListener a2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            content.removeAll();
            content.setLayout(new BorderLayout());
            content.add(new JButton("北"),BorderLayout.NORTH);
            content.add(new JButton("南"),BorderLayout.SOUTH);
            content.add(new JButton("西"),BorderLayout.WEST);
            content.add(new JButton("东"),BorderLayout.EAST);
            content.add(new JButton("中"),BorderLayout.CENTER);
            content.updateUI();
        }
    };

    public void init(){
        JPanel p = new JPanel();
        JButton btn1 = new JButton("FlowLayout演示");
        JButton btn2 = new JButton("BorderLayout演示");
        p.add(btn1);
        p.add(btn2);
        add(p,BorderLayout.NORTH);
        add(content);

        btn1.addActionListener(a1);
        btn2.addActionListener(a2);

        setSize(300,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame().init();
    }
}
