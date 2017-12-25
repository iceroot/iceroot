package com.icexxx.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 测试工具类,建议只在测试或调试时使用
 * 
 * @author IceWater
 * @version 1.0
 */
public class IceTestUtil {
    public static void print(String str) {
        System.out.println(str);
    }

    public static void print(int num) {
        System.out.println(num);
    }

    public static void print(double num) {
        System.out.println(num);
    }

    public static void print(boolean bool) {
        System.out.println(bool);
    }

    public static void print(Integer num) {
        System.out.println(num);
    }

    public static void print(Double num) {
        System.out.println(num);
    }

    public static void print(Boolean bool) {
        System.out.println(bool);
    }

    public static void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void print(Integer[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void print(String[] strs) {
        System.out.println(Arrays.toString(strs));
    }

    // public static void print(Object[] strs){
    // System.out.println(Arrays.toString(strs));
    // }
    public static void print(Date date) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }

    public static void print(Exception e) {
        StringBuilder sb = new StringBuilder();
        String nl = "\r\n";
        sb.append(e.getClass());
        sb.append(nl);
        sb.append(e.getMessage());
        sb.append(nl);
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("        ");
            sb.append(stackTraceElement);
            sb.append(nl);
        }
        System.out.println(sb);
    }
}
