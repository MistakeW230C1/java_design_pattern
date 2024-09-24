package com.mistake.day11.demo4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Copy implements ICopy {
    @Override
    public void copy(String src, String dest) throws Exception {
        File file = new File(src);
        FileInputStream in = new FileInputStream(file);
        FileOutputStream out = new FileOutputStream(dest);
        byte buf[] = new byte[(int) file.length()];
        in.read(buf);
        out.write(buf);
        in.close();
        out.close();
    }
}
