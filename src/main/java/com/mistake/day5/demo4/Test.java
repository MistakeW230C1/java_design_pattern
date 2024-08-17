package com.mistake.day5.demo4;

public class Test {
    public static void main(String[] args) {
        // 自定义观察者对象
        IObserver obs1 = new Observer();
        IObserver obs2 = new Observer();
        // 定义主题对象
        Subject subject = new Subject();
        subject.register(obs1);
        subject.register(obs2);
        subject.setData("hello");
        subject.notifyObservers();
    }
}
