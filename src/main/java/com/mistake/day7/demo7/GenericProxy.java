package com.mistake.day7.demo7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class GenericProxy {
    static Object creatProxy(Object obj, InvocationHandler invocationHandler) {
        Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), invocationHandler);
        return proxy;
    }
}
