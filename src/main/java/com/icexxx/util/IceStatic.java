package com.icexxx.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 静态缓存变量
 * 
 * @author IceWater
 * @version 2.0.6
 */
public class IceStatic {
    private static Integer num;
    private static Long longValue;
    private static String str;
    private static Double doubleValue;
    private static Date date;
    private static Boolean booleanValue;
    private static List<String> list;
    private static Map<String, String> map;

    public static Integer getNum() {
        return num;
    }

    public static void setNum(Integer num) {
        IceStatic.num = num;
    }

    public static Long getLongValue() {
        return longValue;
    }

    public static void setLongValue(Long longValue) {
        IceStatic.longValue = longValue;
    }

    public static String getStr() {
        return str;
    }

    public static void setStr(String str) {
        IceStatic.str = str;
    }

    public static Double getDoubleValue() {
        return doubleValue;
    }

    public static void setDoubleValue(Double doubleValue) {
        IceStatic.doubleValue = doubleValue;
    }

    public static Date getDate() {
        return date;
    }

    public static void setDate(Date date) {
        IceStatic.date = date;
    }

    public static Boolean getBooleanValue() {
        return booleanValue;
    }

    public static void setBooleanValue(Boolean booleanValue) {
        IceStatic.booleanValue = booleanValue;
    }

    public static List<String> getList() {
        return list;
    }

    public static void setList(List<String> list) {
        IceStatic.list = list;
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static void setMap(Map<String, String> map) {
        IceStatic.map = map;
    }

    public static void put(String key, String value) {
        if (IceStatic.map == null) {
            IceStatic.map = new HashMap<String, String>();
        }
        IceStatic.map.put(key, value);
    }

    public static void add(String value) {
        if (IceStatic.list == null) {
            IceStatic.list = new ArrayList<String>();
        }
        IceStatic.list.add(value);
    }
}
