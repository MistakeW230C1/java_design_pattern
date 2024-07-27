package com.mistake.day3.demo1;

public class CarTest {
    public static void main(String[] args) {
        // 从工厂中创建对象
        ICar iCar = CarSimpleFactory.create("TOP_CAR");
    }
}
