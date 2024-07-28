package com.mistake.day3.demo5;

public class JPGFactory extends AbstractFactory {

    @Override
    public IRead create() {
        return new JPGRead();
    }
}
