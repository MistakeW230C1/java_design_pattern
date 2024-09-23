package com.mistake.day10.demo2;

import java.util.ArrayList;

/**
 * @author mistake
 */
public class CommanderManage {
    ArrayList<ICommander> list = new ArrayList<>();

    public void add(ICommander commander) {
        list.add(commander);
    }

    public void executeCommand() {
        for (int i = 0; i < list.size(); i++) {
            float value = list.get(i).calc();
            System.out.println("this area is " + value);
        }
    }
}
