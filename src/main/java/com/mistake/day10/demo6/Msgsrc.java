package com.mistake.day10.demo6;

/**
 * @author mistake
 */
public class Msgsrc implements ISource {
    String msg;

    boolean bFire;

    public String getMsg() {
        return msg;
    }

    public void setMsg() {
        this.msg = msg;
    }

    @Override
    public boolean isbFire() {
        return bFire;
    }

    @Override
    public void setbFire(boolean bFire) {
        this.bFire = bFire;
    }

    public void come(String msg) {
        this.msg = msg;
        System.out.println(bFire);
        if (msg.startsWith("zhang:")) {
            bFire = true;
        }
    }
}
