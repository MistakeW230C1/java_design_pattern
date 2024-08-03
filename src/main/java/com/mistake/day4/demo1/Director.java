package com.mistake.day4.demo1;

import javax.swing.*;

public class Director {
    public UIBuilder build;

    public Director(UIBuilder builder) {
        this.build = builder;
    }

    public JPanel build(String user) {
        build.addUI();
        build.registerMsg();
        build.initialData(user);
        return build.getPanel();
    }
}
