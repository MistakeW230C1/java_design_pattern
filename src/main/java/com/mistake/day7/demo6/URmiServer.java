package com.mistake.day7.demo6;


import java.rmi.RemoteException;

public class URmiServer {
    public static void main(String[] args) throws Exception {
        ServerCalc serverCalc = new ServerCalc();
        ServerProxy serverProxy = new ServerProxy();
        serverProxy.registry("calc", serverCalc);
        serverProxy.process(1);
    }
}
