package com.mistake.day5.demo5;


import java.util.Observer;

public class Test {
    public static void main(String[] args) {
        // 自定义观察者对象
        Subject subject = new Subject();
        Observer obj1 = new OneObserver();
        Observer obj2 = new TwoObserver();
        subject.addObserver(obj1);
        subject.addObserver(obj2);
        subject.setFactor("hello");
        subject.setData("hello");
        subject.setData("how are you");
        subject.setData("hello");
        subject.setData("thanks");
        System.out.println(((OneObserver)obj1).getC());
        subject.notifyObservers();
    }
}
