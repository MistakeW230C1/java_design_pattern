package com.mistake.day1.demo1;

public class Algo<T> {
    public T getMax(T t[], ILess<T> cmp) {
        T maxValue = t[0];
        for (int i = 1; i < t.length; i++) {
            if(cmp.less(maxValue,t[i]))
                maxValue = t[i];
        }
        return  maxValue;
    }
}
