package com.mistake.day8.demo2;

public class NormalState implements ICellState {
    @Override
    public Boolean phone(CellContext cellContext) {
        System.out.println(cellContext.name + ":手机处于正常状态");
        int minute = (int) (Math.random() * 10 + 1);
        cellContext.cost(minute);
        return false;
    }
}
