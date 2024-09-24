package com.mistake.day11.demo5;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author mistake
 */
abstract class Decorator implements ICopy {
    protected ICopy obj;

    public Decorator(ICopy obj) {
        this.obj = obj;
    }

    public void copy(InputStream in, OutputStream out) throws Exception {
        obj.copy(in, out);
    }
}
