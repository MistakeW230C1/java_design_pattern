package com.mistake.day7.demo4;

public class ClientTest {
    public static void main(String[] args) throws Exception {
        ICalc obj = new ClientProxy();
        float value = obj.calc("1+2+3");
        System.out.println(value);
    }
}
