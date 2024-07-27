package com.mistake.day3.demo2;

public class MidFactory extends AbstractActionFactory {
    @Override
    public ICar createCar() {
        return new MidCar();
    }

    @Override
    public IBus createBus() {
        return new MidBus();
    }
}
