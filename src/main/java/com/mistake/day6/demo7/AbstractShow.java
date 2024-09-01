package com.mistake.day6.demo7;

public abstract class AbstractShow {
    public IPara para;

    public void setPara(IPara para) {
        this.para = para;
    }

    abstract public String show(String no) throws Exception;
}
