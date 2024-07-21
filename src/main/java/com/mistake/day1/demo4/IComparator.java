package com.mistake.day1.demo4;

// IComparator.java
public interface IComparator<T> {
    Boolean equal(T x, T y);

    Boolean less(T x, T y);
}
