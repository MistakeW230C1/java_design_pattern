package com.mistake.day6.demo2;

/**
 * 平信邮寄类 SimplePost
 */
public class SimplePost implements IPost {
    @Override
    public void post() {
        System.out.println("This is Simple post");
    }
}
