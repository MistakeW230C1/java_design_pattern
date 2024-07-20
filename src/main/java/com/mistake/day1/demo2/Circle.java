package com.mistake.day1.demo2;

import java.util.Scanner;

// Circle.java:圆类
public class Circle implements IShape {

    float r; // 半径

    public boolean input() {
        System.out.println("请输入半径:");
        Scanner s = new Scanner(System.in);
        r = s.nextFloat();
        return true;
    }

    public float getArea() {
        float s = (float) Math.PI * r * r;
        return s;
    }
}
