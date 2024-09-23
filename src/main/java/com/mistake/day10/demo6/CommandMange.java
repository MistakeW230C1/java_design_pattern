package com.mistake.day10.demo6;


import java.util.Vector;

public class CommandMange extends Thread {

    Vector<ICommand> v = new Vector<>();

    ISource src;

    boolean bMark = true;

    public CommandMange(ISource src) {
        this.src = src;
    }

    public void addCommand(ICommand iCommand) {
        v.add(iCommand);
    }

    public void run() {
        while (bMark) {
            if (!src.isbFire()) {
                continue;
            }
            for (int i = 0; i < v.size(); i++) {
                v.get(i).noticeCommand();
            }
            src.setbFire(false);
        }
    }
}
