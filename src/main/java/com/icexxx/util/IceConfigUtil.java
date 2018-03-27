package com.icexxx.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 配置文件工具类
 * 
 * @author IceWater
 * @version 1.0.0
 */
public class IceConfigUtil {
    /**
     * 根据配置文件获取Properties
     * 
     * @param fileName 配置文件的名称
     * @return 获取的配置文件中的值
     * @since 1.0.0
     */
    public static Properties conf(String fileName) {
        fileName = reset(fileName);
        InputStream resourceAsStream = IceConfigUtil.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static String reset(String fileName) {
        if (fileName == null) {
            return ".";
        }
        int lastIndexOf = fileName.lastIndexOf("/");
        if (lastIndexOf == -1) {
            if (fileName.lastIndexOf(".") == -1) {
                return fileName + ".properties";
            }
        } else {
            int indexOf = fileName.indexOf(".", lastIndexOf + 1);
            if (indexOf == -1) {
                return fileName + ".properties";
            }
        }
        return fileName;
    }

    /**
     * 根据配置文件获取Boolean类型的值
     * 
     * @param configFileName 配置文件的名称
     * @param key 配置文件的参数名称
     * @return 获取到的参数的值
     * @since 1.0
     */
    public static Boolean getBoolean(String configFileName, String key) {
        Properties conf = conf(configFileName);
        String value = conf.getProperty(key);
        return convertBoolean(value);
    }

    /**
     * 根据配置文件获取Boolean类型的值
     * 
     * @param configFileName 配置文件的名称
     * @param key 配置文件的参数名称
     * @param defaultValue 当配置文件中找不到需要的值时使用的默认值
     * @return 获取到的参数的值
     * @since 1.0
     */
    public static Boolean getBoolean(String configFileName, String key, String defaultValue) {
        Properties conf = conf(configFileName);
        String value = conf.getProperty(key, defaultValue);
        return convertBoolean(value);
    }

    /**
     * 根据配置文件获取String类型的值
     * 
     * @param configFileName 配置文件的名称
     * @param key 配置文件的参数名称
     * @return 获取到的参数的值
     * @since 1.0
     */
    public static String getString(String configFileName, String key) {
        Properties conf = conf(configFileName);
        String value = conf.getProperty(key);
        return value;
    }

    /**
     * 根据配置文件获取String类型的值
     * 
     * @param configFileName 配置文件的名称
     * @param key 配置文件的参数名称
     * @param defaultValue 从给定的配置文件中找不到需要的参数时使用的默认值
     * @return 获取到的参数的值
     * @since 1.0
     */
    public static String getString(String configFileName, String key, String defaultValue) {
        Properties conf = conf(configFileName);
        String value = conf.getProperty(key, defaultValue);
        return value;
    }

    /**
     * 根据配置文件获取int类型的值
     * 
     * @param configFileName 配置文件的名称
     * @param key 配置文件的参数名称
     * @return 从配置文件中获取的参数的值
     * @since 1.0
     */
    public static Integer getInt(String configFileName, String key) {
        Properties conf = conf(configFileName);
        String value = conf.getProperty(key);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * 根据配置文件获取int类型的值
     * 
     * @param configFileName 配置文件的名称
     * @param key 配置文件的参数名称
     * @param defaultValue 从给定的配置文件中找不到需要的参数时使用的默认值
     * @return 从配置文件中获取的参数的值
     * @since 1.0
     */
    public static Integer getInt(String configFileName, String key, int defaultValue) {
        Properties conf = conf(configFileName);
        String value = conf.getProperty(key, defaultValue + "");
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 从配置文件中获取多个参数值
     * 
     * @param configFileName 配置文件的名称
     * @param key 配置文件的参数名称
     * @return 从配置文件中获取的参数的值组成的List
     * @since 1.0
     */
    public static List<String> getList(String configFileName, String key) {
        Properties conf = conf(configFileName);
        String value = conf.getProperty(key);
        if (value == null || "".equals(value.trim())) {
            return null;
        }
        String[] split = value.split(",");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            list.add(str.trim());
        }
        return list;
    }

    private static Boolean convertBoolean(String value) {
        if (value == null || "".equals(value.trim())) {
            return null;
        } else if ("true".equalsIgnoreCase(value)) {
            return true;
        } else if ("false".equalsIgnoreCase(value)) {
            return false;
        } else if ("yes".equalsIgnoreCase(value)) {
            return true;
        } else if ("no".equalsIgnoreCase(value)) {
            return false;
        } else if ("show".equalsIgnoreCase(value)) {
            return true;
        } else if ("hide".equalsIgnoreCase(value)) {
            return false;
        } else if ("on".equalsIgnoreCase(value)) {
            return true;
        } else if ("off".equalsIgnoreCase(value)) {
            return false;
        } else if ("y".equalsIgnoreCase(value)) {
            return true;
        } else if ("n".equalsIgnoreCase(value)) {
            return false;
        }
        return null;
    }
}
