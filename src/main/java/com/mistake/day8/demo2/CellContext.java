package com.mistake.day8.demo2;

public class CellContext {
    /**
     * 电话号码
     */
    String strPhone;

    /**
     * 姓名
     */
    String name;

    /**
     * 金额
     */
    float price;

    public CellContext(String strPhone, String name, float price) {
        this.strPhone = strPhone;
        this.name = name;
        this.price = price;
    }

    /**
     * 手机存钱
     *
     * @param prize
     */
    public void save(float prize) {
        this.price += prize;
    }

    /**
     * 手机打了n分钟，重新计算余额
     *
     * @param minute
     */
    public void cost(int minute) {
        this.price -= ICellState.COST_LIMIT * minute;
    }

    public Boolean call() {
        ICellState state = null;
        if (price > ICellState.NORMAL_LIMIT) {
            state = new NormalState();
        } else if (price < ICellState.STOP_LIMIT) {
            state = new StopState();
        } else {
            state = new OverDrawState();
        }
        state.phone(this);
        return true;
    }
}
