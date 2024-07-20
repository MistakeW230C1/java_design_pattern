package com.mistake.day1.demo2;


public class test {
    public static void main(String[] args) {
        IShape shape = new Circle();
        ShapeProc object = new ShapeProc(shape);
        float value = object.process();
        System.out.println("圆的面积:" + value);

        Rect shape2 = new Rect();
        ShapeProc object2 = new ShapeProc(shape2);
        float value2 = object2.process();
        System.out.println("矩形的面积:" + value2);
    }
}
