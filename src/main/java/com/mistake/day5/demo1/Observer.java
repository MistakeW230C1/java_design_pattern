package com.mistake.day5.demo1;

public class Observer implements IObserver {
    public void refresh(String data) {
        System.out.println("I have received this data:" + data);
    }
}
