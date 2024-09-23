package com.mistake.day9.demo2;


/**
 * @author mistake
 */
public interface IShape {
    float getArea();

    float getLength();

    Object accept(IVisitor visitor, String method);
}
