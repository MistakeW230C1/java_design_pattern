package com.mistake.day8.demo4;

public class MidState implements IState {

    private int times;

    @Override
    public String getStateInfo() {
        return "良好";
    }

    @Override
    public int getStateInterval() {
        return times++;
    }
}
