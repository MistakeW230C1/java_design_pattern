package com.mistake.day9.demo3;


public class Element2 implements IElement {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
