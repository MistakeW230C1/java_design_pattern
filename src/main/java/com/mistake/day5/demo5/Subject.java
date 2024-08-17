package com.mistake.day5.demo5;

import java.util.Observable;

public class Subject extends Observable {
    String data;

    /**
     * 增加条件变量
     */
    Object factor;

    public void setFactor(Object factor) {
        this.factor = factor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        setChanged();
        notifyObservers(factor);
    }
}
