package com.mistake.day10.demo3;


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

    float getLength(Point pt[]) {
        int i = 0;
        float len = 0;
        for (i = 0; i < pt.length - 1; i++) {
            len += distance(pt[i], pt[i + 1]);
        }
        len += distance(pt[0], pt[pt.length - 1]);
        return len;
    }

    public float distance(Point one, Point two) {
        return (float) Math.sqrt((one.x - two.x) * (one.x - two.x) + (one.y - two.x) * (one.y - two.y));
    }
}
