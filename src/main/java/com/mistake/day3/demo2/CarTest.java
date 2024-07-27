package com.mistake.day3.demo2;

public class CarTest {
    public static void main(String[] args) {
        AbstractActionFactory abstractActionFactory = new TopFactory();
        // 从工厂中创建对象
        ICar iCar = abstractActionFactory.createCar();
    }
}
