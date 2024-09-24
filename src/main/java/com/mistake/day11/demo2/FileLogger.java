package com.mistake.day11.demo2;


import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class FileLogger implements ILogger {
    @Override
    public void log(String msg) {
        DataOutputStream dos = null;
        // 读取日志文件
        try {
            dos = new DataOutputStream(new FileOutputStream("src/main/resources/day11.demo1/log.text", true));
            dos.writeBytes(msg + "\r\n");
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
