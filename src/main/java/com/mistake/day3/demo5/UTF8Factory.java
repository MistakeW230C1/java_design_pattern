package com.mistake.day3.demo5;

public class UTF8Factory extends AbstractFactory {
    @Override
    public IRead create() {
        return new UTF8Read();
    }
}
