package com.mistake.day10.demo6;

public class EmailReceive implements IReceiver {
    @Override
    public void process(ISource src) {
        System.out.println("this is Email process:" + ((Msgsrc) src).getMsg());
    }
}
