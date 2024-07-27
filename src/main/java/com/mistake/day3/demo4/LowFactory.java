package com.mistake.day3.demo4;

public class LowFactory extends AbstractActionFactory2 {
    @Override
    public ICar createCar() {
        return new LowCar();
    }

}
