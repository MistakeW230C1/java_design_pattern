package com.mistake.day9.demo3;

/**
 * @author leoliu
 */
public interface IElement {

    /**
     * 访问者接口方法
     *
     * @param visitor
     */
    public void accept(IVisitor visitor);
}
