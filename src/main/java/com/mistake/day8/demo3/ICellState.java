package com.mistake.day8.demo3;


/**
 * @author mistake
 */
public interface ICellState {
    /**
     * 正常状态
     */
    public float NORMAL_LIMIT = 0;

    /**
     * 停机状态
     */
    public float STOP_LIMIT = -1;

    /**
     * 话费标准
     */
    public float COST_LIMIT = 0.2f;

    public Boolean phone(CellContext cellContext);
}
