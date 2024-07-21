package com.mistake.day2.demo1;

import java.lang.reflect.Constructor;

public class A{
    public A() {
        System.out.println("this is A");
    }

    public A(Integer m) {
        System.out.println("this is " + m);
    }


    public A(String s, Integer m) {
        System.out.println(s +":" +m);
    }

    public static void main(String[] args) throws Exception {
        Class classInfo = Class.forName("com.mistake.day2.demo1.A");

        // 第一种方法
        Constructor cons[] = classInfo.getConstructors();
        // 无参构造
        cons[2].newInstance();

        cons[1].newInstance(1);

        cons[0].newInstance("sss",1);

        // 第二种方法
        Constructor c = classInfo.getConstructor();
        c.newInstance();

        c = classInfo.getConstructor(new Class[]{Integer.class});
        c.newInstance(10);

        c = classInfo.getConstructor(new Class[]{String.class,Integer.class});
        c.newInstance("ssss",1);
    }
}
