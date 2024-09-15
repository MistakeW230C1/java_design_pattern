package com.mistake.day7.demo4;

import java.rmi.Naming;

public class RmiClient {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try{
            //查询远程对象
          ICalc iCalc =(ICalc) Naming.lookup("rmi://localhost:1099/calc");
            System.out.println(iCalc.calc("1+1"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
