package com.mistake.day1.demo3;

import java.util.Vector;

// Circle.java:圆类
public class Circle2 implements IShape2 {

    static Vector<String> vec = new Vector<>();

    static {
        vec.add("getArea");
        vec.add("getPermeter");
    }

    float r; // 半径


    public Circle2(float r) {
        this.r = r;
    }


    @Override
    public int query(String strID) {
        return vec.indexOf(strID);
    }

    @Override
    public Object dispatch(int nID, Object in) {
        Object obj = null;
        switch (nID) {
            case 0:
                obj = getArea(in);
                break;
            case 1:
                obj = getPerimeter(in);
                break;
        }
        return obj;
    }

    Object getArea(Object in) {         // 非多态方法
        float area = (float) Math.PI * r * r;
        return new Float(area);
    }

    Object getPerimeter(Object in) {    // 非多态方法
        float area = (float) Math.PI * r * 2.0f;
        return new Float(area);
    }
}
