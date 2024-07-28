package com.mistake.day3.demo7;

public class ProductFactory {
    static IRead create(String name) {
        IRead product = null;
        try {
            Class c = Class.forName(name);
            product = (IRead) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
