package com.mistake.day3.demo7;

public class ProductFactory2<T> {
    public T create(String name) {
        T product = null;
        try {
            Class c = Class.forName(name);
            product = (T) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
