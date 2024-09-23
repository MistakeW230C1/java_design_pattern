package com.mistake.day10.demo1;

public class Test {
    public static void main(String[] args) {
//        Student s = new Student();
//        Teacher t = new Teacher(s);
//        Invoke invoke = new Invoke(t);
//        invoke.execute();
        Student s = new Student();
        Teacher t = new Teacher(s);
        t.sweep();
    }
}
