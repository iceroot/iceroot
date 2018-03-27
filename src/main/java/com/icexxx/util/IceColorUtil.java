package com.icexxx.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 图片颜色相关工具类
 * 
 * @author IceWater
 * @version 2.1
 */
public class IceColorUtil {
    /**
     * 计算图片颜色的平均值
     * 
     * @param fileName 图片路径
     * @return 颜色的平均值
     */
    public static double color(String fileName) {
        File file = new File(fileName);
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width = image.getWidth();
        int height = image.getHeight();
        int minX = image.getMinX();
        int minY = image.getMinY();
        long sum = 0;
        int count = 0;
        for (int i = minX; i < width; i++) {
            for (int j = minY; j < height; j++) {
                int rgb = image.getRGB(i, j);
                sum += rgb;
                count++;
            }
        }
        double avg = (double) sum / count;
        return avg;
    }
}
