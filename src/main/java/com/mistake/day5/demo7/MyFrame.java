package com.mistake.day5.demo7;


import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class MyFrame extends JFrame {
    public void init(){
        // 形成页面
        setLayout(null);

        JTable nameTable = new JTable();
        JTable structTable = new JTable();
        JTable showTable = new JTable();
        JScrollPane namePane = new JScrollPane(nameTable);
        JScrollPane structPane = new JScrollPane(structTable);
        JScrollPane showPane = new JScrollPane(showTable);

        JPanel left = new JPanel();
        left.setLayout(new BorderLayout());


        JPanel struct = new JPanel();
        struct.setLayout(new BorderLayout());

        JPanel show = new JPanel();
        show.setLayout(new BorderLayout());

        left.add(namePane);
        struct.add(structPane);
        show.add(showPane);

        add(left);
        add(struct);
        add(show);

        left.setSize(200,500);
        struct.setSize(500,200);
        show.setSize(500,290);

        left.setBounds(0,0,left.getWidth(), left.getHeight());
        struct.setBounds(210,0,struct.getWidth(), struct.getHeight());
        show.setBounds(210,210,show.getWidth(), show.getHeight());

        setSize(700,500);

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置主题-观察者之间的关联
        try{
            Subject subject = new Subject(nameTable);
            Observer obj  = new StructObserver(structTable);
            Observer obj2  = new ShowObserver(showTable);

            subject.addObserver(obj);
            subject.addObserver(obj2);
        }catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        new MyFrame().init();
    }
}

