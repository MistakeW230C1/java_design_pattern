package com.mistake.day5.demo6;

import java.util.Observable;

public class Subject extends Observable {
    private int data;

    private Factor factor;

    public void setFactor(Factor factor) {
        this.factor = factor;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
        setChanged();
        notifyObservers(factor);
    }
}
