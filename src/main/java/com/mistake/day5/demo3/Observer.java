package com.mistake.day5.demo3;


public class Observer implements IObserver {

    @Override
    public void refresh(ISubject iSubject) {
        Subject subject = (Subject) iSubject;
        System.out.println("I have received this data:" + subject.getData());
    }
}
