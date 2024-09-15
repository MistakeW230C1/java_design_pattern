package com.mistake.day9.demo2;

public class Test4 {
    public static void main(String[] args) {
        IVisitor v = new ShapeVisitor();
        Triangle t = new Triangle(0, 0, 2, 0, 0, 2);
        Point pt = (Point) t.accept(v, "getCenter");
        System.out.println("重心坐标 x=" + pt.x + "\t" + pt.y);
        Float f = (Float) t.accept(v, "getInnerCircleR");
        System.out.println("内心圆半径 r=" + f.floatValue());
    }
}
