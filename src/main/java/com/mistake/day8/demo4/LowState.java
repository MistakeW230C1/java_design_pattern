package com.mistake.day8.demo4;

public class LowState implements IState {

    private int times;

    @Override
    public String getStateInfo() {
        return "一般";
    }

    @Override
    public int getStateInterval() {
        return times++;
    }
}
