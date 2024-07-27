package com.mistake.day3.demo3;


public class LowFactory extends AbstractActionFactory {
    public IBus createBus() {
        return new LowBus();
    }

}
