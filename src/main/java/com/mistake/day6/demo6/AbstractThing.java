package com.mistake.day6.demo6;

public class AbstractThing {
    AbstractRead reader;

    public AbstractThing(AbstractRead read) {
        this.reader = read;
    }

    Object read(String strPath) throws Exception {
        return reader.read(strPath);
    }
}
