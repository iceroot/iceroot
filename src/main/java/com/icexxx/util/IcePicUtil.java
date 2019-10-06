package com.icexxx.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 图片工具类
 * 
 * @author IceWater
 * @version 2.0.3
 */
public class IcePicUtil {
    /**
     * 文件转为图片
     * 
     * @param file 原始文件
     * @return 转换后的图片对象
     * @version 2.0.3
     */
    public static BufferedImage toImage(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件转为图片
     * 
     * @param file 原始文件
     * @return 转换后的图片对象
     * @version 2.0.3
     */
    public static BufferedImage toImage(String file) {
        try {
            return ImageIO.read(new File(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
