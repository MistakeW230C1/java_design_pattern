package com.mistake.day1.demo4;

//AbstractComparator.java
public class AbstractComparator<T> implements  IComparator<T>{
    @Override
    public Boolean equal(T x, T y) {
        return true;
    }

    @Override
    public Boolean less(T x, T y) {
        return true;
    }
}
