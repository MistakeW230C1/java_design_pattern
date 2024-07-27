package com.mistake.day3.demo3;

public class MidFactory extends AbstractActionFactory {
    public ICar createCar() {
        return new MidCar();
    }

    public IBus createBus() {
        return new MidBus();
    }
}
