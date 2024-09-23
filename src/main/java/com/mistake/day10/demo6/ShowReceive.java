package com.mistake.day10.demo6;

public class ShowReceive implements IReceiver {
    @Override
    public void process(ISource src) {
        Msgsrc msgsrc = (Msgsrc) src;
        System.out.println(msgsrc.getMsg());
    }
}
