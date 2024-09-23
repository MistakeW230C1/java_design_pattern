package com.mistake.day10.demo5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JPanel content = new JPanel();

    /**
     * FlowBtn 既是命令发送者，又是接收者
     */
    class FlowBtn extends JButton implements IReceiver {

        public FlowBtn(String name) {
            super(name);
        }

        @Override
        public void response() {
            content.removeAll();
            content.setLayout(new FlowLayout());
            content.add(new JButton("1"));
            content.add(new JButton("2"));
            content.add(new JButton("3"));
            content.add(new JButton("4"));
            content.add(new JButton("5"));
            content.updateUI();
        }
    }

    /**
     * BorderBtn 既是命令发送者，又是接收者
     */
    class BorderBtn extends JButton implements IReceiver {

        public BorderBtn(String name) {
            super(name);
        }

        @Override
        public void response() {
            content.removeAll();
            content.setLayout(new BorderLayout());
            content.add(new JButton("北"), BorderLayout.NORTH);
            content.add(new JButton("南"), BorderLayout.SOUTH);
            content.add(new JButton("西"), BorderLayout.WEST);
            content.add(new JButton("东"), BorderLayout.EAST);
            content.add(new JButton("中"), BorderLayout.CENTER);
            content.updateUI();
        }
    }

    public void init() {
        JPanel p = new JPanel();
        JButton btn1 = new FlowBtn("FlowLayout演示");
        JButton btn2 = new BorderBtn("BorderLayout演示");
        p.add(btn1);
        p.add(btn2);

        add(p, BorderLayout.NORTH);
        add(content);
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IReceiver obj = (IReceiver) e.getSource();
        obj.response();
    }

    public static void main(String[] args) {
        new MyFrame().init();
    }
}
