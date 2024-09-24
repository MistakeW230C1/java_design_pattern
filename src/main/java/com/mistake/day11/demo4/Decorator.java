package com.mistake.day11.demo4;

/**
 * @author mistake
 */
abstract class Decorator implements ICopy {
    protected ICopy obj;

    public Decorator(ICopy obj) {
        this.obj = obj;
    }


}
