package com.mistake.day8.demo4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CtrlPanel extends JPanel {
    private static final long serialVersionUID = -6539318368246202726L;

    JComponent c[] = {new JTextField(4), new JTextField(4),
            new JButton("开始监测"), new JButton("停止监控")};
    boolean bmark[][] = {{true, true, true, false}, {false, false, false, true}};

    // 开始监控 按钮响应
    ActionListener startAct = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setState(1);
            int high = Integer.parseInt(((JTextField) c[0]).getText());
            int low = Integer.parseInt(((JTextField) c[1]).getText());
            Container c = CtrlPanel.this.getParent();
            String className = c.getClass().getName();
            while (!className.equalsIgnoreCase("com.mistake.day8.demo4.MyFrame")) {
                c = c.getParent();
                className = c.getClass().getName();
            }
            ((MyFrame) c).startMonitor(high, low);
        }
    };

    // 停止监控 按钮响应
    ActionListener stopAct = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setState(0);
            Container c = CtrlPanel.this.getParent();
            String className = c.getClass().getName();
            while (!className.equalsIgnoreCase("com.mistake.day8.demo4.MyFrame")) {
                c = c.getParent();
                className = c.getClass().getName();
            }
            ((MyFrame) c).stopMonitor();
        }
    };

    public CtrlPanel() {
        add(new JLabel("优良"));
        add(c[0]);
        add(new JLabel("良好"));
        add(c[1]);
        add(c[2]);
        add(c[3]);
        // 为组件设置初始状态
        setState(0);
        ((JButton) c[2]).addActionListener(startAct);
        ((JButton) c[3]).addActionListener(stopAct);
    }

    void setState(int nState) {
        // length值为2
        for (int i = 0; i < bmark[nState].length; i++) {
            c[i].setEnabled(bmark[nState][i]);
        }
    }


}
