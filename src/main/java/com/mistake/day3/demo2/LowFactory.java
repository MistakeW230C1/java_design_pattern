package com.mistake.day3.demo2;

public class LowFactory extends AbstractActionFactory {
    @Override
    public ICar createCar() {
        return new LowCar();
    }

    @Override
    public IBus createBus() {
        return new LowBus();
    }
}
