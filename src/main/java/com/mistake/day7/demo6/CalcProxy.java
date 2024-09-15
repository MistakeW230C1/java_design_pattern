package com.mistake.day7.demo6;

public class CalcProxy implements ICalc {

    ClientComn comn;

    public CalcProxy(String IP, int socketNO) throws Exception {
        comn = new ClientComn(IP, socketNO);
    }

    @Override
    public float calc(String s) throws Exception {
        Float result = (Float) comn.invoke("calc", "calc", new Object[]{s});
        return result.floatValue();
    }
}
