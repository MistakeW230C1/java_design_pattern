package com.mistake.day3.demo5;

public class GBKFactory extends AbstractFactory {
    @Override
    public IRead create() {
        return new GBKRead();
    }
}
