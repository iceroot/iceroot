package com.icexxx.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合转换相关工具类
 * 
 * @author IceWater
 * @version 2.0.2
 */
public class IceConvertUtil {
    /**
     * 转为字符串集合
     * 
     * @param list 原始集合
     * @return 转换后的集合
     * @since 2.0.2
     */
    public static List<String> toStrArray(List<Integer> list) {
        if (list == null) {
            return null;
        }
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            Integer curValue = list.get(i);
            if (curValue == null) {
                result.add(null);
            } else {
                result.add(curValue + "");
            }
        }
        return result;
    }

    /**
     * 转化为Object对象集合
     * 
     * @param list 原始集合
     * @return 转换后的集合
     * @since 2.0.2
     */
    public static List<Object> toObjectArray(List<Integer> list) {
        if (list == null) {
            return null;
        }
        List<Object> result = new ArrayList<Object>();
        for (int i = 0; i < list.size(); i++) {
            Integer curValue = list.get(i);
            if (curValue == null) {
                result.add(null);
            } else {
                result.add(curValue);
            }
        }
        return result;
    }

    /**
     * 转化为数字对象集合
     * 
     * @param list 原始集合
     * @return 转换后的集合
     * @since 2.0.2
     */
    public static List<Integer> toIntArray(List<String> list) {
        if (list == null) {
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            String curValue = list.get(i);
            if (curValue == null) {
                result.add(null);
            } else {
                Integer value = null;
                try {
                    value = Integer.parseInt(curValue);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                result.add(value);
            }
        }
        return result;
    }
}
