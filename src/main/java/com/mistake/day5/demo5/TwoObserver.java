package com.mistake.day5.demo5;

import java.util.Observable;
import java.util.Observer;

public class TwoObserver implements Observer {


    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject) o;
        System.out.println("The data is:" +((Subject) o).getData());
    }
}
