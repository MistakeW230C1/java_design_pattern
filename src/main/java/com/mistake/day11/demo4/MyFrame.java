package com.mistake.day11.demo4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private String directSrc;

    private String directDest;

    JTextField fromText = new JTextField(60);
    JTextField toText = new JTextField(60);

    public void init() {
        setLayout(null);
        JButton frombtn = new JButton("选择源目录");
        JButton tobtn = new JButton("选择目标目录");
        JButton btn = new JButton("开始拷贝");
        fromText.setEnabled(false);
        toText.setEnabled(false);
        frombtn.setBounds(20, 30, 100, 30);
        tobtn.setBounds(20, 70, 100, 30);
        btn.setBounds(200, 110, 100, 30);
        fromText.setBounds(140, 30, 300, 30);
        toText.setBounds(140, 70, 300, 30);
        add(frombtn);
        add(fromText);
        add(tobtn);
        add(toText);
        add(btn);

        // 选择源文件
        frombtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                directSrc = getDirect();
                fromText.setText(directSrc);
            }
        });

        tobtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                directDest = getDirect();
                toText.setText(directDest);
            }
        });

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ICopy obj = new Copy();
                ICopy obj2 = new DirectCopy(obj);
                try {
                    obj2.copy(directSrc, directDest);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });
        setSize(460, 180);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private String getDirect() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int ret = fc.showDialog(this, "请选择目录");
        if (ret == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    public static void main(String[] args) {
        new MyFrame().init();
    }
}
