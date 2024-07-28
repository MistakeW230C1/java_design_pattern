package com.mistake.day3.demo5;

public class UNICODEFactory extends AbstractFactory {
    @Override
    public IRead create() {
        return new UNICODERead();
    }
}
