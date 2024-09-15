package com.mistake.day8.demo3;


public class CellContext {
    public final int NORMAL_STATE = 1;
    public final int OVERDRAW_STATE = 2;
    public final int STOP_STATE = 3;


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

    int mark = -100;
    ICellState state = null;

    public CellContext(String strPhone, String name, float price) {
        this.strPhone = strPhone;
        this.name = name;
        this.price = price;
    }

    public int getMark() {
        int mark = 0;
        if (price > ICellState.NORMAL_LIMIT) {
            mark = NORMAL_STATE;
        } else if (price < ICellState.STOP_LIMIT) {
            mark = STOP_STATE;
        } else {
            mark = OVERDRAW_STATE;
        }
        return mark;
    }

    public void setState() {
        int curMark = getMark();
        if (curMark == mark) {
            return;
        }
        mark = curMark;
        switch (mark) {
            case NORMAL_STATE:
                state = new NormalState();
                break;
            case OVERDRAW_STATE:
                state = new OverDrawState();
                break;
            case STOP_STATE:
                state = new StopState();
                break;
            default:
                break;
        }
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
        this.setState();
        state.phone(this);
        return true;
    }
}
