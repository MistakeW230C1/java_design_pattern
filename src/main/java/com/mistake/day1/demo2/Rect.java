package com.mistake.day1.demo2;

import java.util.Scanner;

// Rect.java :矩形类
public class Rect implements IShape {
    float width, height;


    public boolean input() {
        System.out.println("请输入宽,高:");
        Scanner s = new Scanner(System.in);
        width = s.nextFloat();
        height = s.nextFloat();
        return true;
    }


    public float getArea() {
        float s = width * height;
        return s;
    }
}
