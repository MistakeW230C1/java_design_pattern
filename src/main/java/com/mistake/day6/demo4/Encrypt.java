package com.mistake.day6.demo4;

public class Encrypt {

    LogFile logFile;

    public void Encrypt(LogFile logFile) {
        this.logFile = logFile;
    }


    /**
     * 加密信息保存到文件
     *
     * @param msg
     */
    public void save(String msg) {
        msg = encrypt(msg);
        logFile.save(msg);
    }

    private String encrypt(String msg) {
        String s = "";
        // 加密功能省略
        return s;
    }

}
