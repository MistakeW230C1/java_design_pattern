package com.mistake.day9.demo4;

import java.util.Vector;

public class BankGroup {
    Vector<Bank> v = new Vector<>();

    void add(Bank bank) {
        v.add(bank);
    }

    public void accept(IVisitor<Bank> visitor) {
        for (int i = 0; i < v.size(); i++) {
            v.get(i).accept(visitor);
        }
    }
}
