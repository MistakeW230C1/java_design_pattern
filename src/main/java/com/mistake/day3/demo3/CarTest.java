package com.mistake.day3.demo3;


public class CarTest {
    public static void main(String[] args) {
        TopFactory topFactory = new TopFactory();
        // 从工厂中创建对象
        ICar iCar = topFactory.createCar();
    }
}
