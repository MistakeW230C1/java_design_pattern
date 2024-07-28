package com.mistake.day3.demo6;

public class TextFactory extends AbstractFactory{
    public IRead create(){
        return  new TextRead();
    }
}
