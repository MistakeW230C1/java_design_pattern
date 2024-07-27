package com.mistake.day3.demo1;

public class CarSimpleFactory {
    public static final String TopType = "TOP_TYPE";
    public static final String MidType = "MID_TYPE";
    public static final String LowType = "MID_TYPE";

    public static ICar create(String mark) {
        ICar obj = null;
        if (mark.equals(TopType)) {
            obj = new TopCar();
        }
        if (mark.equals(MidType)) {
            obj = new MidCar();
        }
        if (mark.equals(LowType)) {
            obj = new LowCar();
        }
        return obj;
    }
}
