package com.mistake.day3.demo7;



public class ImageFactory extends AbstractFactory {
    public IRead create() {
        return new ImageRead();
    }
}
