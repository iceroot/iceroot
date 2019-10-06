package com.icexxx.util;

import java.io.File;

/**
 * 文件工具类
 * 
 * @author IceWater
 * @version 2.0.3
 */
public class IceFileUtil {
    /**
     * 获取文件夹中最新的文件或文件夹
     * 
     * @param folder 文件夹路径
     * @param isFile 是否是文件
     * @return 获取的文件名称
     * @version 2.0.3
     */
    public static String getNewest(String folder, boolean isFile) {
        File folderFile = new File(folder);
        File[] listFiles = folderFile.listFiles();
        long max = 0;
        String fileNameNewest = null;
        for (File file : listFiles) {
            boolean isFileFlag = file.isFile();
            if (isFile == isFileFlag) {
                long lastModified = file.lastModified();
                if (lastModified > max) {
                    max = lastModified;
                    fileNameNewest = file.getName();
                }
            }
        }
        return fileNameNewest;
    }
}
