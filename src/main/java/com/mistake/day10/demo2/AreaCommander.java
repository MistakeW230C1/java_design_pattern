package com.mistake.day10.demo2;

public class AreaCommander implements ICommander {
    PolyonCalc calc;

    Point pt[];

    public AreaCommander(PolyonCalc calc, Point[] pt) {
        this.calc = calc;
        this.pt = pt;
    }

    @Override
    public float calc() {
        return calc.getArea(pt);
    }
}
