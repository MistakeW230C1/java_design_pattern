package com.mistake.day8.demo4;

import javax.swing.*;

public class StatePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    JTextField textInfo = new JTextField(4);
    JTextField textHour = new JTextField(10);

    IState state;
    int mark = -1;

    public StatePanel() {
        add(new JLabel("当前内存状态:"));
        add(textInfo);

        add(new JLabel("持续时间"));
        add(textHour);

        textInfo.setEnabled(false);
        textInfo.setEnabled(false);
    }

    public void setState(int mark) {
        if (this.mark == mark) {
            return;
        }
        switch (mark) {
            case 1:
                state = new HighState();
                break;
            case 2:
                state = new MidState();
                break;
            case 3:
                state = new LowState();
                break;
            default:
                break;
        }
    }

    public void process() {
        textInfo.setText(state.getStateInfo());
        // getStateInterval()在不同状态下实现
        int size = state.getStateInterval();
        textHour.setText("" + size / 3600);
    }
}
