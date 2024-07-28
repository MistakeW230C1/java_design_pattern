package com.mistake.day3.demo5;

public class BMPFactory extends AbstractFactory{

    @Override
    public IRead create() {
        return new BMPRead();
    }
}
