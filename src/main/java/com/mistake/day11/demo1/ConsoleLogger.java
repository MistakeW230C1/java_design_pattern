package com.mistake.day11.demo1;

public class ConsoleLogger implements ILogger {
    @Override
    public void log(String msg) {
        System.out.println(msg);
    }
}
