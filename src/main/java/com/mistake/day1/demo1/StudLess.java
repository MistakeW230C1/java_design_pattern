package com.mistake.day1.demo1;

// StudLess.java: 学生成绩比较器
public class StudLess implements ILess<Student> {
    @Override
    public Boolean less(Student x, Student y) {
        return x.grade < y.grade;
    }
}
