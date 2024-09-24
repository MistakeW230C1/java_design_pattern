package com.mistake.day11.demo4;

import java.io.File;

public class DirectCopy extends Decorator {

    public DirectCopy(ICopy obj) {
        super(obj);
    }

    @Override
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
                obj.copy(tempFile.getAbsolutePath(), dest + "/" + tempFile.getName());
            }

            if (tempFile.isDirectory()) {
                copy(src+"/"+files[i], dest + "/" + tempFile);
            }
        }
    }
}
