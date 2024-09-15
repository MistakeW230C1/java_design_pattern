package com.mistake.day7.demo4;

import java.rmi.Remote;

public interface ICalc extends Remote {
    float calc(String s) throws Exception;
}
