package com.mistake.day11.demo6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Progress extends Decorator implements Runnable {

    private JProgressBar bar;

    private String strFile;

    private Timer timer;

    public Progress(IEntry obj, String strFile) {
        super(obj);
        this.strFile = strFile;
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (obj.getTotal() == 0) {
                    return;
                }
                bar.setValue(getCursor() * 100 / getTotal());
                if (getCursor() == getTotal()) {
                    timer.stop();
                }
            }
        });
    }

    public void setBar(JProgressBar bar) {
        this.bar = bar;
        bar.setStringPainted(true);
    }

    @Override
    public void run() {
        timer.start();
        try {
            super.entry(strFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
