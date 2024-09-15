package com.mistake.day9.demo1;

public interface IShape {
    /**
     * 明确的需求
     *
     * @return
     */
    float getArea();

    /**
     * 明确的需求
     *
     * @return
     */
    float getLength();

    Object accept(IVisitor v);

}
