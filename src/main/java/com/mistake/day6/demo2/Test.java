package com.mistake.day6.demo2;

public class Test {
    public static void main(String[] args) {
        IPost p = new SimplePost();
        Letter letter = new Letter(p);
        letter.post();
    }
}
