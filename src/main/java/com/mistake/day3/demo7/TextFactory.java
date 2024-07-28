package com.mistake.day3.demo7;

public class TextFactory extends AbstractFactory {
    public IRead create(){
        return  new TextRead();
    }
}
