package com.mistake.day4.demo1;

import javax.swing.*;

public abstract class UIBuilder {
    protected JPanel panel = new JPanel();

    abstract public void addUI();

    abstract public void registerMsg();

    abstract public void initialData(String user);

    public JPanel getPanel() {
        return panel;
    }
}
