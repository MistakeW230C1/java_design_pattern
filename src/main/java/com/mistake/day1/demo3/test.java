package com.mistake.day1.demo3;

public class test {
    public static void main(String[] args) {
        IShape2 obj = new Circle2(1);
        int nId = obj.query("getArea");
        Float result = (Float) obj.dispatch(nId, null);
        System.out.println("半径1圆面积:" + result.floatValue());
    }
}
