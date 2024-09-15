package com.mistake.day9.demo1;

public class Test3 {
    public static void main(String[] args) {
        IVisitor v = new CenterVisitor();
        Triangle t = new Triangle(0, 0, 2, 0, 0, 2);
        Point pt = (Point) t.accept(v);
        System.out.println(pt.x + "\t" + pt.y);
    }
}
