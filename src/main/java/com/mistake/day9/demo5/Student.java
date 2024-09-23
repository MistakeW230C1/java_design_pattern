package com.mistake.day9.demo5;

public class Student {

    /**
     * 学号
     */
    String stuNo;

    /**
     * 姓名
     */
    String name;

    /**
     * 语文成绩
     */
    int chinese;

    /**
     * 数学成绩
     */
    int math;

    /**
     * 数学成绩
     */
    int english;

    public Student(String t[]){
        stuNo =t[0];
        name = t[1];
        chinese = Integer.parseInt(t[2]);
        math = Integer.parseInt(t[3]);
        english = Integer.parseInt(t[4]);
    }
}
