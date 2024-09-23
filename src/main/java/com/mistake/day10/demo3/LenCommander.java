package com.mistake.day10.demo3;



public class LenCommander implements ICommander {
    PolyonCalc calc;

    Point pt[];

    public LenCommander(PolyonCalc calc, Point[] pt) {
        this.calc = calc;
        this.pt = pt;
    }

    @Override
    public float calc() {
        return calc.getLength(pt);
    }
}
