package com.mistake.day8.demo3;

/**
 * @author mistake
 */
public class StopState implements ICellState {
    @Override
    public Boolean phone(CellContext cellContext) {
        System.out.println(cellContext.name + ":手机已经处于停机状态，请及时缴费");
        return false;
    }
}
