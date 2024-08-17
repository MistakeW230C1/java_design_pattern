package com.mistake.day5.demo4;


import java.util.Vector;

public class AbstractSubject implements ISubject {
    Vector<IObserver> vec = new Vector<>();


    @Override
    public void register(IObserver obs) {
        vec.add(obs);
    }

    @Override
    public void unregister(IObserver obs) {
        vec.add(obs);
    }

    @Override
    public void notifyObservers() {
        for (IObserver obs : vec) {
            obs.refresh(this);
        }
    }
}
