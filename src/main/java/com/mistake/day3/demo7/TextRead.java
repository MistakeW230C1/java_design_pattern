package com.mistake.day3.demo7;


import java.io.File;
import java.io.FileInputStream;

public class TextRead implements IRead<String> {
    @Override
    public String read(String... in) {
        String result = null;
        try {
            File file = new File(in[0]);
            long len = file.length();
            FileInputStream fileInputStream = new FileInputStream(in[0]);
            byte buf[] = new byte[(int) len];
            fileInputStream.read(buf);
            result = new String(buf, in[1]);
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
