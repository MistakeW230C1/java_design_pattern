package com.mistake.day5.demo4;



public class Observer implements IObserver {

    @Override
    public void refresh(ISubject iSubject) {
     Subject subject = (Subject) iSubject;
        System.out.println("I have received this data:" + subject.getData());
    }
}
