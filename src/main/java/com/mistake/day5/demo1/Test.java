package com.mistake.day5.demo1;

public class Test {
    public static void main(String[] args) {
        // 自定义观察者对象
        IObserver obs = new Observer();
        // 定义主题对象
        Subject subject = new Subject();
        subject.register(obs);
        subject.setData("hello");
        subject.notifyObservers();
    }
}
