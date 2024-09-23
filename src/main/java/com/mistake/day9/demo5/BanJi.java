package com.mistake.day9.demo5;

import javax.swing.*;
import java.util.Vector;

public class BanJi {
    Vector<Student> vector = new Vector<>();

    /**
     * 班级是学生的集合
     * @return
     */
    public Vector<Student> getV() {
        return vector;
    }

    /**
     * 班级增加学生
     * @return
     */
    void add(Student s) {
        vector.add(s);
    }

    /**
     *
     * @param v
     * @param jPanel
     */
    void statistics(IVisitor v, JPanel jPanel) {
        v.visit(this, jPanel);
    }
}
