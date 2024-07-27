package com.mistake.day3.demo4;

public class TopFactory extends AbstractActionFactory1 {
    @Override
    public ICar createCar() {
        return new TopCar();
    }

    @Override
    public IBus createBus() {
        return new TopBus();
    }
}
