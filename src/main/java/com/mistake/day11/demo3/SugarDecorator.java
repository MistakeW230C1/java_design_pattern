package com.mistake.day11.demo3;

/**
 * @author mistake
 */
public class SugarDecorator extends Decorator {
    public SugarDecorator(ICook cook) {
        super(cook);
    }

    public void addPepper() {
        System.out.println("添加白糖");
    }

    @Override
    public void cook() {
        addPepper();
        cook.cook();
    }
}
