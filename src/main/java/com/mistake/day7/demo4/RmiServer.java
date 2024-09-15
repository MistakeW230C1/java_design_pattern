package com.mistake.day7.demo4;

import java.rmi.Naming;

/**
 * @author mistake
 */
public class RmiServer {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try{
            ServerCalc serverCalc =new ServerCalc();
            Naming.rebind("calc",serverCalc);
            System.out.println("server bing success!!!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
