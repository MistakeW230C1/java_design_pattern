package com.mistake.day3.demo4;


public class CarTest {
    public static void main(String[] args) {
        AbstractActionFactory1 abstractActionFactory1 = new TopFactory();
        // 从工厂中创建对象
        ICar iCar = abstractActionFactory1.createCar();
    }
}
