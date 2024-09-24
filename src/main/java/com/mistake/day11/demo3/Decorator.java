package com.mistake.day11.demo3;

abstract class Decorator implements ICook {
    ICook cook;

    public Decorator(ICook cook) {
        this.cook = cook;
    }
}
