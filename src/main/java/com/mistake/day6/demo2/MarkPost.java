package com.mistake.day6.demo2;

/**
 * 平信邮寄类 SimplePost
 */
public class MarkPost implements IPost {
    @Override
    public void post() {
        System.out.println("This is mark post");
    }
}
