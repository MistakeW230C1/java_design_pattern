package com.mistake.day11.demo5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DirectCopy extends Decorator {

    public DirectCopy(ICopy obj) {
        super(obj);
    }

    public void copy(String src, String dest) throws Exception {
        File file = new File(dest);
        if (!file.exists()) {
            // 如果文件夹不存在 创建文件夹
            file.mkdirs();
        }
        File oldFile = new File(src);
        String[] files = oldFile.list();
        File tempFile = null;
        for (int i = 0; i < files.length; i++) {
            if (src.endsWith(File.separator)) {
                tempFile = new File(src + files[i]);
            } else {
                tempFile = new File(src + File.separator + files[i]);
            }
            if (tempFile.isFile()) {
                FileInputStream in = new FileInputStream(tempFile);
                FileOutputStream out = new FileOutputStream(dest + "/" + tempFile.getName());
                obj.copy(in, out);
                in.close();
                out.close();
            }

            if (tempFile.isDirectory()) {
                copy(src + "/" + files[i], dest + "/" + tempFile);
            }
        }
    }
}
