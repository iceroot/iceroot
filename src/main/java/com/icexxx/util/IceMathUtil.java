package com.icexxx.util;

import java.math.BigDecimal;

/**
 * 数学工具类 主要处理大实数运算问题
 * 
 * @author IceWater
 * @version 1.0
 */
public class IceMathUtil {
    /**
     * 两个数字相加
     * 
     * @param num1 第一个加数
     * @param num2 第二个加数
     * @return 两个加数相加的和
     * @since 1.0
     */
    public static String add(String num1, String num2) {
        BigDecimal dec1 = new BigDecimal(num1);
        BigDecimal dec2 = new BigDecimal(num2);
        return dec1.add(dec2).toString();
    }

    /**
     * 两个数字想减
     * 
     * @param num1 被减数
     * @param num2 减数
     * @return 两个数想减的差
     * @since 1.0
     */
    public static String subtract(String num1, String num2) {
        BigDecimal dec1 = new BigDecimal(num1);
        BigDecimal dec2 = new BigDecimal(num2);
        return dec1.subtract(dec2).toString();
    }

    /**
     * 两个数相乘的积
     * 
     * @param num1 被乘数
     * @param num2 乘数
     * @return 两个数相乘的积
     * @since 1.0
     */
    public static String multiply(String num1, String num2) {
        BigDecimal dec1 = new BigDecimal(num1);
        BigDecimal dec2 = new BigDecimal(num2);
        return dec1.multiply(dec2).toString();
    }

    /**
     * 两个数相除
     * 
     * @param num1 被除数
     * @param num2 除数
     * @return 两个数相除的商,保留两位小数
     * @since 1.0
     */
    public static String divide(String num1, String num2) {
        return divide(num1, num2, 2);
    }

    /**
     * 两个数相除
     * 
     * @param num1 被除数
     * @param num2 除数
     * @param scale 商的小数位数
     * @return 两个除数的商,保留若干位小数
     * @since 1.0
     */
    public static String divide(String num1, String num2, int scale) {
        BigDecimal dec1 = new BigDecimal(num1);
        BigDecimal dec2 = new BigDecimal(num2);
        return dec1.divide(dec2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 求相反数
     * 
     * @param num 原始数值
     * @return 该数值的相反数
     * @since 1.0
     */
    public static String negate(String num) {
        return new BigDecimal(num).negate().toString();
    }
}
