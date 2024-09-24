package com.mistake.day11.demo6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    JTextField selText = new JTextField(60);
    JProgressBar bar = new JProgressBar();
    String strFile;

    public void init() {
        setLayout(null);
        JButton selBtn = new JButton("选择文件");
        JButton btn = new JButton("开始导入");
        selText.setEnabled(false);
        selText.setEnabled(false);
        selBtn.setBounds(20, 30, 100, 30);
        btn.setBounds(20, 30, 100, 30);
        selText.setBounds(140, 30, 200, 30);
        bar.setBounds(140, 70, 200, 30);
        add(selBtn);
        add(selText);
        add(btn);
        add(bar);

        selBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int ret = fc.showDialog(MyFrame.this, "请选择文件");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    strFile = fc.getSelectedFile().getAbsolutePath();
                    selText.setText(strFile);
                }
            }
        });

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DbEntry obj = new DbEntry();
                Progress pg = new Progress(obj, strFile);
                pg.setBar(bar);
                new Thread(pg).start();
            }
        });

        setSize(460, 180);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame().init();
    }
}
