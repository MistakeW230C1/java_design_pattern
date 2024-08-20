package com.mistake.day6.demo2;

/**
 * 抽象事物
 */
public class AbstractThing {
    private IPost obj;

    /**
     * 抽象事物
     *
     * @param obj
     */
    public AbstractThing(IPost obj) {
        this.obj = obj;
    }

    public void post() {
        obj.post();
    }
}
