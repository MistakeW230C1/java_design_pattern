package com.mistake.day9.demo2;


/**
 * @author leoliu
 */
public interface IShape {
    float getArea();

    float getLength();

    Object accept(IVisitor visitor, String method);
}
