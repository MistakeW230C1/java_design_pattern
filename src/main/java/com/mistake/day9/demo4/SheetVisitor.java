package com.mistake.day9.demo4;

public class SheetVisitor implements IVisitor<Sheet> {

    private void ABCProc(ABCSheet sheet) {
        System.out.println("ABCSheet process");
    }

    private void ICBCProc(ICBCSheet sheet){
        System.out.println("ICBCSheet process");
    }
    @Override
    public void visit(Sheet s) {
        if (s instanceof ABCSheet){
            ABCProc((ABCSheet) s);
        }else {
            ICBCProc((ICBCSheet) s);
        }
    }
}
