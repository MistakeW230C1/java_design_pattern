package com.mistake.day3.demo2;

public class TopFactory extends AbstractActionFactory {
    @Override
    public ICar createCar() {
        return new TopCar();
    }

    @Override
    public IBus createBus() {
        return new TopBus();
    }
}
