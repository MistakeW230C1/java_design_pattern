package com.mistake.day6.demo3;

public class Encrypt extends LogFile {
    /**
     * 加密信息保存到文件
     * @param msg
     */
    public void save(String msg) {
        msg = encrypt(msg);
        super.save(msg);
    }

    private String encrypt(String msg) {
        String s = "";
        // 加密功能省略
        return s;
    }

}
