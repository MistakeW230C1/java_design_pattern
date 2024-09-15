package com.mistake.day7.demo4;

public class Test {
    public static void main(String[] args) {
        ServerCalc obj = new ServerCalc();
        ServerProxy serverProxy = new ServerProxy(obj);
        serverProxy.run();
    }
}
