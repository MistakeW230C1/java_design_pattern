package com.mistake.day10.demo2;

public class PolyonCalc {
    float getArea(Point pt[]) {
        float s;
        int size = pt.length;
        if (pt.length < 3) {
            return 0;
        }
        s = pt[0].y * (pt[size - 1].x - pt[1].x);
        for (int i = 1; i < size; i++) {
            s += pt[i].y * (pt[(i - 1)].x - pt[(i + 1) % size].x);
        }
        return s / 2;
    }
}
