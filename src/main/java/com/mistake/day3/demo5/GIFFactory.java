package com.mistake.day3.demo5;

public class GIFFactory extends AbstractFactory {

    @Override
    public IRead create() {
        return new GIFRead();
    }
}
