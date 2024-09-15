package com.mistake.day9.demo1;

/**
 * @author mistake
 */
public class CenterVisitor implements IVisitor {
    @Override
    public Object visit(Triangle t) {
        Point pt = new Point();
        pt.x = (t.x1 + t.x2 + t.x3) / 3;
        pt.y = (t.y1 + t.y2 + t.y3) / 3;
        return pt;
    }
}
