package com.mistake.day7.demo2;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

/**
 * @author mistake
 */
public class UFrame extends JFrame implements MouseListener {

    MangeItem mangeItem = new MangeItem();
    JTable jTable;
    JTextArea jTextArea1 = new JTextArea();
    JTextArea jTextArea2 = new JTextArea();

    private void init() throws Exception {
        setLayout(null);
        mangeItem.firstSearch();
        String[] title = {"账号", "姓名", "项目名称"};
        String[][] data = null;
        Vector<ProxyItem> vector = new Vector<>();
        data = new String[vector.size()][title.length];
        for (int i = 0; i < vector.size(); i++) {
            ProxyItem proxyItem = vector.get(i);
            data[i][0] = proxyItem.getAccount();
            data[i][1] = proxyItem.getName();
            data[i][2] = proxyItem.getProject();
        }
        jTable = new JTable(data, title);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(10, 10, 200, 340);

        JLabel jLabel1 = new JLabel("项目主要内容");
        JLabel jLabel2 = new JLabel("项目计划");
        jLabel1.setBounds(230, 5, 100, 20);
        jTextArea1.setBounds(230, 40, 200, 100);
        jLabel2.setBounds(230, 160, 100, 20);
        jTextArea2.setBounds(230, 195, 200, 100);

        add(jScrollPane);
        add(jLabel1);
        add(jTextArea1);
        add(jLabel2);
        add(jTextArea2);

        jTable.addMouseListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        try {
            int n = jTable.getSelectedRow();
            if (n > 0) {
                ProxyItem proxyItem = mangeItem.proxyItems.get(n);
                proxyItem.itemFill();
                jTextArea1.setText(proxyItem.getContent());
                jTextArea2.setText(proxyItem.getPlan());
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // todo
    public static void main(String[] args) throws Exception {
        new UFrame().init();

    }
}
