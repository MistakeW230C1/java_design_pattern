package com.mistake.day8.demo4;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class ContentPanel extends JPanel {
    private static final long serialVersionUID = 3347768107958337339L;


    JTextField totalField = new JTextField(20);
    JTextField freeField = new JTextField(20);
    JTextField ratioField = new JTextField(8);

    @SuppressWarnings("static-access")
    public ContentPanel() {
        totalField.setEnabled(false);
        freeField.setEnabled(false);
        ratioField.setEnabled(false);

        Box b1 = Box.createVerticalBox();
        b1.add(new JLabel("内存:"));
        b1.add(b1.createVerticalStrut(16));

        b1.add(new JLabel("空间内存:"));
        b1.add(b1.createVerticalStrut(16));

        b1.add(new JLabel("所占比例:"));
        b1.add(b1.createVerticalStrut(16));

        Box b2 = Box.createVerticalBox();
        b2.add(totalField);
        b2.add(b2.createVerticalStrut(16));

        b2.add(freeField);
        b2.add(b2.createVerticalStrut(16));

        b2.add(ratioField);
        b2.add(b2.createVerticalStrut(16));

        add(b1);
        add(b2);

        setBorder(new BevelBorder(BevelBorder.RAISED));
    }

    /**
     * 由主窗口MyFrame调用
     */
    public void setValue(Long total, long free, int ratio) {
        totalField.setText(total + " M");
        freeField.setText(free + "  M");
        ratioField.setText(ratio + "%");

    }
}
