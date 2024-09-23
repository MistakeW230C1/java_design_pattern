package com.mistake.day10.demo2;

public class Test
{
    public static void main(String[] args) {
        CommanderManage manage =new CommanderManage();
        PolyonCalc polyonCalc = new PolyonCalc();
        Point pt[] = new Point[3];
        pt[0] = new Point(0,0);
        pt[1] = new Point(1,0);
        pt[2] = new Point(0,1);
        AreaCommander areaCommander = new AreaCommander(polyonCalc,pt);
        manage.add(areaCommander);

      /*  pt[0] = new Point(0,0);
        pt[1] = new Point(2,0);
        pt[2] = new Point(0,2);
        AreaCommander areaCommander2 = new AreaCommander(polyonCalc,pt);
        manage.add(areaCommander2);*/
        manage.executeCommand();
    }
}
