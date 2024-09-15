package com.mistake.day7.demo3;

import javax.naming.Name;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

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
