package com.mistake.day8.demo3;


/**
 * @author mistake
 */
public class OverDrawState implements ICellState {
    @Override
    public Boolean phone(CellContext cellContext) {
        System.out.println(cellContext.name + ":手机已经处于欠费状态，请及时缴费");
        int minute = (int) (Math.random() * 10 + 1);
        cellContext.cost(minute);
        cellContext.getMark();
        return false;
    }
}
