package com.mistake.day2.demo1;


import java.lang.reflect.Method;

public class A1 {
    public void func1() {
        System.out.println("this is A");
    }

    public void func2(Integer m) {
        System.out.println("this is " + m);
    }


    public void func3(String s, Integer m) {
        System.out.println(s + ":" + m);
    }

    public static void main(String[] args) throws Exception {
        Class classInfo = Class.forName("com.mistake.day2.demo1.A1");
        Object object = classInfo.getConstructor().newInstance();

        Method fun1 = classInfo.getMethod("func1");
        fun1.invoke(object);

        Method func2 = classInfo.getMethod("func2",Integer.class);
        func2.invoke(object, 10);

        Method func3 = classInfo.getMethod("func3",String.class,Integer.class);
        func3.invoke(object, "1111", 1);

    }
}
