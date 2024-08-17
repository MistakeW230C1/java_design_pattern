package com.mistake.day5.demo1;

import java.util.Vector;

/**
 * 主题实现类Subject
 */
public class Subject implements ISubject {

    /**
     * 观察者维护向量
     */
    private Vector<IObserver> vec = new Vector<>();

    private String data;

    public String getData() {
        return data;
    }


    public void setData(String data) {
        this.data = data;
    }

    @Override
    public void register(IObserver obs) {
        vec.add(obs);
    }

    @Override
    public void unregister(IObserver obs) {
        if (vec.contains(obs)) {
            vec.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        for (IObserver iob : vec) {
            iob.refresh(data);
        }
    }
}
