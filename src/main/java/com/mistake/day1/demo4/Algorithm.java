package com.mistake.day1.demo4;

public class Algorithm<T> {
    IComparator<T> cmp;  // 比较器,是AbstractComparator的子类

    Algorithm(IComparator<T> cmp) {
        this.cmp = cmp;
    }

    public T median(T x, T y, T z) {
        int i = 2 ;
        int i1 = 1;
        if (cmp.less(x, y))
            return cmp.less(y, z) ? y : cmp.less(x, z) ? z : x;
        else
            return cmp.less(y, z) ? y : cmp.less(x, z) ? z : y;
    }
}
