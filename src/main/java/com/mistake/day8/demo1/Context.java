package com.mistake.day8.demo1;

public class Context {
    private IState state;

    public void setState(IState state) {
        this.state = state;
    }

    public void mange() {
        state.goState();
    }
}
