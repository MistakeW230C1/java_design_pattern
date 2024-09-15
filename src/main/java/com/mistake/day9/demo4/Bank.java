package com.mistake.day9.demo4;

abstract class Bank {
    public void accept(IVisitor<Bank> v) {
        v.visit(this);
    }

    public abstract void process(IVisitor<Sheet> v);
}
