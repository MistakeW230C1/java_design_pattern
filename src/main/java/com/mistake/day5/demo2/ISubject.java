package com.mistake.day5.demo2;

// 主题接口 ISubject
public interface ISubject<T> {

    /**
     * 注册观察者
     */
    void register(IObserver<T> obs);

    /**
     * 撤销观察者
     */
    void unregister(IObserver<T> obs);

    /**
     * 通知所有观察者
     */
    void notifyObservers();
}
