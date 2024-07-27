package com.mistake.day3.demo4;

public class MidFactory extends AbstractActionFactory1 {
    @Override
    public ICar createCar() {
        return new MidCar();
    }

    @Override
    public IBus createBus() {
        return new MidBus();
    }
}
