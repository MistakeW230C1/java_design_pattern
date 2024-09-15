package com.mistake.day7.demo3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerCalc extends UnicastRemoteObject implements ICalc {
    protected ServerCalc() throws RemoteException {
        super();
    }


    @Override
    public float calc(String s) throws Exception {
        s += "0";
        float result = 0;
        float value = 0;
        char opcur = '+';
        char opnext;
        // 字符串启始位置
        int start = 0;
        // 如果是负数
        if ('-' == s.charAt(0)) {
            // 修改操作符
            opcur = '-';
            // 修改字符串的遍历开始位置
            start = 1;
        }
        // 遍历字符串
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '+' || '-' == s.charAt(i)) {
                opnext = s.charAt(i);
                // 对操作符拆分字符串
                value = Float.parseFloat(s.substring(start, i));
                switch (opcur) {
                    case '+':
                        result += value;
                        break;
                    case '-':
                        result -= value;
                        break;
                    default:
                        break;
                }
                start =i+1;
                opcur = opnext;
                i =start;
            }
        }
        return result;
    }
}
