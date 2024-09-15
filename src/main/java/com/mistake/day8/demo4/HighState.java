package com.mistake.day8.demo4;

public class HighState implements IState {

    private int times;

    @Override
    public String getStateInfo() {
        return "充裕";
    }

    @Override
    public int getStateInterval() {
        return times++;
    }
}
