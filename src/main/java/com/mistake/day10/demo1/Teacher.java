package com.mistake.day10.demo1;


/**
 * @author mistake
 */
public class Teacher implements ICommand {

    public Student receiver = null;

    public Teacher(Student receiver) {
        this.receiver = receiver;
    }

    @Override
    public void sweep() {
        receiver.sweeping();
    }
}
