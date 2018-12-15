package com.icexxx.util;

/**
 * 数值转换工具类
 * 
 * @author IceWater
 * @version 2.0.2
 */
public class IceSwitchUtil {
    /**
     * 根据月日获取星座
     * 
     * @param monthAndDay 月日字符串(MMdd格式)
     * @return 返回的星座
     * @since 2.0.2
     */
    public static String constellation(String monthAndDay) {
        if (monthAndDay.compareTo("0120") < 0) {
            return "摩羯座";
        } else if (monthAndDay.compareTo("0219") < 0) {
            return "水瓶座";
        } else if (monthAndDay.compareTo("0321") < 0) {
            return "双鱼座";
        } else if (monthAndDay.compareTo("0421") < 0) {
            return "白羊座";
        } else if (monthAndDay.compareTo("0521") < 0) {
            return "金牛座";
        } else if (monthAndDay.compareTo("0622") < 0) {
            return "双子座";
        } else if (monthAndDay.compareTo("0723") < 0) {
            return "巨蟹座";
        } else if (monthAndDay.compareTo("0823") < 0) {
            return "狮子座";
        } else if (monthAndDay.compareTo("0923") < 0) {
            return "处女座";
        } else if (monthAndDay.compareTo("1023") < 0) {
            return "天秤座";
        } else if (monthAndDay.compareTo("1122") < 0) {
            return "天蝎座";
        } else if (monthAndDay.compareTo("1222") < 0) {
            return "射手座";
        } else {
            return "摩羯座";
        }
    }
}
