package com.mistake.day11.demo3;

/**
 * @author mistake
 */
public class PepperDecorator extends Decorator {
    public  PepperDecorator(ICook cook) {
        super(cook);
    }

    public void addPepper() {
        System.out.println("添加辣椒");
    }

    @Override
    public void cook() {
        addPepper();
        cook.cook();
    }
}
