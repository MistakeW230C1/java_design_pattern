package com.mistake.day1.demo1;

public class InteLess implements ILess<Integer> {
    @Override
    public Boolean less(Integer x, Integer y) {
        return x < y;
    }
}
