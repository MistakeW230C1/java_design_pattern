package com.mistake.day5.demo4;

// 主题接口 ISubject
public interface ISubject {

    /**
     * 注册观察者
     */
    void register(IObserver obs);

    /**
     * 撤销观察者
     */
    void unregister(IObserver obs);

    /**
     * 通知所有观察者
     */
    void notifyObservers();
}
