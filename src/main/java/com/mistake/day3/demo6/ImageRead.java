package com.mistake.day3.demo6;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRead implements IRead<ImageInfo> {

    @Override
    public ImageInfo read(String... in) {
        BufferedImage bi = null;
        File f = new File(in[0]);
        try {
            bi = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        int width = bi.getWidth();
        int height = bi.getHeight();
        int[] rgb = new int[width * height];
        // 将图像数据读到result缓冲区
        bi.getRGB(0, 0, width, height, rgb, width, height);
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setWidth(width);
        imageInfo.setHeight(height);
        imageInfo.setRGB(rgb);
        return imageInfo;
    }
}
