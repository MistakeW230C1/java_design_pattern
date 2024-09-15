package com.mistake.day7.demo5;

import java.io.RandomAccessFile;
import java.util.*;

public class BorrowProxy implements IBorrow {

    private Borrow borrow;

    private Map<String, Integer> map;

    public BorrowProxy(Borrow borrow) {
        this.borrow = borrow;
        map = new HashMap<>();
    }

    @Override
    public boolean borrow() {
        if (!borrow.borrow()) {
            return false;
        }
        Book book = borrow.getBook();
        Integer i = map.get(book.getNo());
        i = (i == null) ? 1 : i + 1;
        // 保存"书号-次数"键-值对
        map.put(book.getNo(), i);
        return true;
    }

    public void log() throws Exception {
        Set<String> set = map.keySet();
        String key = "";
        String result = "";
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            key = it.next();
            result += key + "\t" + map.get(key) + "\r\n";
        }
        Calendar calendar =Calendar.getInstance();
        RandomAccessFile randomAccessFile = new RandomAccessFile("com.mistake.day7.demo5","rw");
        randomAccessFile.seek(randomAccessFile.length());
        // 记录日志时间
        randomAccessFile.writeBytes(+calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONDAY)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"\r\n");
        randomAccessFile.writeBytes(result);
        randomAccessFile.close();
    }
}
