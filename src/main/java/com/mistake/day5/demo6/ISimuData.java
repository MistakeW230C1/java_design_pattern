package com.mistake.day5.demo6;

public interface ISimuData<T> {
    void open();
    void close();
    Boolean hasNext();
    T next();
}
