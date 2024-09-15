package com.mistake.day9.demo4;

public class Test {
    public static void main(String[] args) {
        // 定义一个 工行单据
        ICBCSheet s = new ICBCSheet("1000", "zhang", 100, "2012-1-1", 3);
        IVisitor v = new SheetVisitor();

        s.accept(v);

        IVisitor b = new BankVisitor();
        ICBCBank mange = new ICBCBank();
        mange.accept(b);
        mange.add(s);
        mange.process(v);
    }
}
