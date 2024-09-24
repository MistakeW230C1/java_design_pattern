package com.mistake.day9.demo4;


import java.util.Vector;

/**
 * 农行存单类
 */
public class ICBCBank extends Bank {
    Vector<ICBCSheet> v = new Vector<>();

    void add(ICBCSheet s) {
        v.add(s);
    }

    @Override
    public void process(IVisitor<Sheet> visitor) {
        for (int i = 0; i < v.size(); i++) {
            v.get(i).accept(visitor);
        }
    }
}