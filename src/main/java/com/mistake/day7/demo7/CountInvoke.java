package com.mistake.day7.demo7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CountInvoke implements InvocationHandler {
    private int count = 0;

    private Object object;

    public CountInvoke(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        count++;
        method.invoke(object, args);
        return null;
    }

    int getCount() {
        return count;
    }
}
