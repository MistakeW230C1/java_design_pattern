package com.mistake.day11.demo5;

import java.io.InputStream;
import java.io.OutputStream;

interface ICopy {
    void copy(InputStream in, OutputStream out) throws Exception;
}