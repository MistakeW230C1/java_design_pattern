package com.mistake.day10.demo3;

public class Test {
    public static void main(String[] args) {
        CommanderManage mange = new CommanderManage();
        Point pt[] = new Point[3];
        pt[0] = new Point(0, 0);
        pt[1] = new Point(1, 0);
        pt[2] = new Point(0, 1);
        PolyonCalc polyonCalc = new PolyonCalc();
        AreaCommander areaCommander = new AreaCommander(polyonCalc, pt);
        LenCommander lenCommander = new LenCommander(polyonCalc, pt);
        mange.add(areaCommander);
        mange.add(lenCommander);
        mange.executeCommand();
    }
}
