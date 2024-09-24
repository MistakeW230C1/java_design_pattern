package com.mistake.day11.demo5;

import java.io.InputStream;
import java.io.OutputStream;

public class Copy implements ICopy {
    @Override
    public void copy(InputStream in, OutputStream out) throws Exception {
        while (in.available() > 0) {
            int value = in.read();
            out.write(value);
        }
    }
}
