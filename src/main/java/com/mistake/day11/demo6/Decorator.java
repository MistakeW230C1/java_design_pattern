package com.mistake.day11.demo6;

public class Decorator implements IEntry {

    protected IEntry obj;

    public Decorator(IEntry obj) {
        this.obj = obj;
    }

    @Override
    public int getCursor() {
        return obj.getCursor();
    }

    @Override
    public int getTotal() {
        return obj.getTotal();
    }

    @Override
    public void entry(String strFile) throws Exception {
        obj.entry(strFile);
    }
}
