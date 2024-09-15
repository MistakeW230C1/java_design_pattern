package com.mistake.day9.demo4;

public class BankVisitor implements IVisitor<Bank> {

    private void ABCProc(ABCBank bank) {
        System.out.println("ABCBank process");
    }

    private void ICBCProc(ICBCBank bank) {
        System.out.println("ICBCBank process");
    }

    @Override
    public void visit(Bank b) {
        if (b instanceof ABCBank) {
            ABCProc((ABCBank) b);
        } else {
            ICBCProc((ICBCBank) b);
        }
    }
}
