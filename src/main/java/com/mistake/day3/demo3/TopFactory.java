package com.mistake.day3.demo3;

public class TopFactory extends AbstractActionFactory {
    public ICar createCar() {
        return new TopCar();
    }

}
