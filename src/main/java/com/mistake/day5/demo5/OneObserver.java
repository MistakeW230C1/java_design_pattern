package com.mistake.day5.demo5;

import java.util.Observable;
import java.util.Observer;

public class OneObserver implements Observer {
    private int c = 0;

    public int getC() {
        return c;
    }

    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject) o;
        if (subject.getData().equals(arg)) {
            c++;
        }
    }
}
