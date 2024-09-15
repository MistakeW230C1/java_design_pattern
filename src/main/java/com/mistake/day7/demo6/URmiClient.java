package com.mistake.day7.demo6;

/**
 * @author mistake
 */
public class URmiClient {
    public static void main(String[] args) throws Exception {
        ICalc obj = new CalcProxy("localhots", 4000);
        System.out.println(obj.calc("1+5+4"));
        System.out.println(obj.calc("1+5+5"));
    }
}
