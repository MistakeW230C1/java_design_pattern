package com.mistake.day8.demo2;

public class Test {
    public static void main(String[] args) {
       /* CellContext c = new CellContext("1771131313","mistake",1);
        c.call();
        c.call();
        c.save(3);
        c.call();
        c.call();
        c.call();
        c.call();*/
        CellContext c = new CellContext("1771131313","mistake",1);
        Manage object = new Manage();
        object.regist(c);
        object.phone("1771131313");
        object.phone("1771131313");
        object.save("1771131313",4);
        object.phone("1771131313");
        object.phone("1771131313");
    }
}
