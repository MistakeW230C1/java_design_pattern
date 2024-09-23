package com.mistake.day10.demo6;

public class Command implements ICommand {
    IReceiver rvr;
    ISource src;

    public Command(IReceiver rvr, ISource src) {
        this.rvr = rvr;
        this.src = src;
    }

    @Override
    public void noticeCommand() {
        System.out.println(src.toString());
        rvr.process(src);
    }
}
