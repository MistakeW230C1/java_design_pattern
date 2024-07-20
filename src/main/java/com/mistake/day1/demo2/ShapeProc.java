package com.mistake.day1.demo2;

// shapeProc.java: 流程处理类
public class ShapeProc {
    private IShape shape;

    public ShapeProc(IShape shape) {
        this.shape = shape;
    }

    public float process() {  // 每个形状处理包括输入及求面积两部
        shape.input();   // 输入功能
        float value = shape.getArea(); // 求面积功能
        return value; // 返回面积
    }
}
