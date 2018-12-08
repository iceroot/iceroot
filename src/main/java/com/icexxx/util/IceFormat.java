package com.icexxx.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IceFormat {
    /**
     * 数字格式化
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @param roundingMode 舍入模式
     * @return 格式化后的数字
     */
    public static String format(Integer num, int precision, RoundingMode roundingMode) {
        if (num == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(precision, roundingMode);
        String result = decimal.toString();
        return result;
    }

    /**
     * 数字格式化
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @param roundingMode 舍入模式
     * @return 格式化后的数字
     */
    public static String format(Double num, int precision, RoundingMode roundingMode) {
        if (num == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(precision, roundingMode);
        String result = decimal.toString();
        return result;
    }

    /**
     * 数字格式化
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @param roundingMode 舍入模式
     * @return 格式化后的数字
     */
    public static String format(String num, int precision, RoundingMode roundingMode) {
        if (num == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(precision, roundingMode);
        String result = decimal.toString();
        return result;
    }

    /**
     * 数字格式化
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @param roundingMode 舍入模式
     * @return 格式化后的数字
     */
    public static String format(BigDecimal num, int precision, RoundingMode roundingMode) {
        if (num == null) {
            return null;
        }
        num = num.setScale(precision, roundingMode);
        String result = num.toString();
        return result;
    }

    /**
     * 数字直接进位
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @return 格式化后的数字
     */
    public static String ceil(Integer num, int precision) {
        if (num == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(precision, RoundingMode.CEILING);
        String result = decimal.toString();
        return result;
    }

    /**
     * 数字直接进位
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @return 格式化后的数字
     */
    public static String ceil(Double num, int precision) {
        if (num == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(precision, RoundingMode.CEILING);
        String result = decimal.toString();
        return result;
    }

    /**
     * 数字直接进位
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @return 格式化后的数字
     */
    public static String ceil(String num, int precision) {
        if (num == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(precision, RoundingMode.CEILING);
        String result = decimal.toString();
        return result;
    }

    /**
     * 数字直接进位
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @return 格式化后的数字
     */
    public static String ceil(BigDecimal num, int precision) {
        if (num == null) {
            return null;
        }
        num = num.setScale(precision, RoundingMode.CEILING);
        String result = num.toString();
        return result;
    }

    /**
     * 数字四舍五入
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @return 格式化后的数字
     */
    public static String round(Integer num, int precision) {
        if (num == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(precision, RoundingMode.HALF_UP);
        String result = decimal.toString();
        return result;
    }

    /**
     * 数字四舍五入
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @return 格式化后的数字
     */
    public static String round(Double num, int precision) {
        if (num == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(precision, RoundingMode.HALF_UP);
        String result = decimal.toString();
        return result;
    }

    /**
     * 数字四舍五入
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @return 格式化后的数字
     */
    public static String round(String num, int precision) {
        if (num == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(precision, RoundingMode.HALF_UP);
        String result = decimal.toString();
        return result;
    }

    /**
     * 数字四舍五入
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @return 格式化后的数字
     */
    public static String round(BigDecimal num, int precision) {
        if (num == null) {
            return null;
        }
        num = num.setScale(precision, RoundingMode.HALF_UP);
        String result = num.toString();
        return result;
    }

    /**
     * 数字直接舍去
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @return 格式化后的数字
     */
    public static String floor(Integer num, int precision) {
        if (num == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(precision, RoundingMode.FLOOR);
        String result = decimal.toString();
        return result;
    }

    /**
     * 数字直接舍去
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @return 格式化后的数字
     */
    public static String floor(Double num, int precision) {
        if (num == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(precision, RoundingMode.FLOOR);
        String result = decimal.toString();
        return result;
    }

    /**
     * 数字直接舍去
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @return 格式化后的数字
     */
    public static String floor(String num, int precision) {
        if (num == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(precision, RoundingMode.FLOOR);
        String result = decimal.toString();
        return result;
    }

    /**
     * 数字直接舍去
     * 
     * @param num 数字值
     * @param precision 小数点位数
     * @return 格式化后的数字
     */
    public static String floor(BigDecimal num, int precision) {
        if (num == null) {
            return null;
        }
        num = num.setScale(precision, RoundingMode.FLOOR);
        String result = num.toString();
        return result;
    }

    /**
     * 数字直接进位
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String ceil(Integer num) {
        String result = ceil(num, 2);
        return result;
    }

    /**
     * 数字四舍五入
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String round(Integer num) {
        String result = round(num, 2);
        return result;
    }

    /**
     * 数字直接舍去
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String floor(Integer num) {
        String result = floor(num, 2);
        return result;
    }

    /**
     * 数字直接进位
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String ceil(Double num) {
        String result = ceil(num, 2);
        return result;
    }

    /**
     * 数字四舍五入
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String round(Double num) {
        String result = round(num, 2);
        return result;
    }

    /**
     * 数字直接舍去
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String floor(Double num) {
        String result = floor(num, 2);
        return result;
    }

    /**
     * 数字直接进位
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String ceil(String num) {
        String result = ceil(num, 2);
        return result;
    }

    /**
     * 数字四舍五入
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String round(String num) {
        String result = round(num, 2);
        return result;
    }

    /**
     * 数字直接舍去
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String floor(String num) {
        String result = floor(num, 2);
        return result;
    }

    /**
     * 数字直接进位
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String ceil(BigDecimal num) {
        String result = ceil(num, 2);
        return result;
    }

    /**
     * 数字四舍五入
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String round(BigDecimal num) {
        String result = round(num, 2);
        return result;
    }

    /**
     * 数字直接舍去
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String floor(BigDecimal num) {
        String result = floor(num, 2);
        return result;
    }

    /**
     * 去掉小数末尾的零和点
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String natural(String num) {
        if (num == null) {
            return null;
        }
        int decimalPoint = num.indexOf(".");
        if (decimalPoint == -1) {
            return num;
        }
        int length = num.length();
        int point = length;
        for (int i = length - 1; i >= 0; i--) {
            char charAt = num.charAt(i);
            if (charAt == '0') {
                point--;
            } else {
                break;
            }
        }
        if (num.charAt(point - 1) == '.' && point - 1 > 0) {
            point--;
        }
        String result = num.substring(0, point);
        return result;
    }

    /**
     * 直接进位并去掉末尾的零
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String ceilNatural(Integer num) {
        String value = ceil(num);
        return natural(value);
    }

    /**
     * 四舍五入并去掉末尾的零
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String roundNatural(Integer num) {
        String value = round(num);
        return natural(value);
    }

    /**
     * 直接舍去并去掉末尾的零
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String floorNatural(Integer num) {
        String value = floor(num);
        return natural(value);
    }

    /**
     * 直接进位并去掉末尾的零
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String ceilNatural(Double num) {
        String value = ceil(num);
        return natural(value);
    }

    /**
     * 四舍五入并去掉末尾的零
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String roundNatural(Double num) {
        String value = round(num);
        return natural(value);
    }

    /**
     * 直接舍去并去掉末尾的零
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String floorNatural(Double num) {
        String value = floor(num);
        return natural(value);
    }

    /**
     * 直接进位并去掉末尾的零
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String ceilNatural(String num) {
        String value = ceil(num);
        return natural(value);
    }

    /**
     * 四舍五入并去掉末尾的零
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String roundNatural(String num) {
        String value = round(num);
        return natural(value);
    }

    /**
     * 直接舍去并去掉末尾的零
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String floorNatural(String num) {
        String value = floor(num);
        return natural(value);
    }

    /**
     * 直接进位并去掉末尾的零
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String ceilNatural(BigDecimal num) {
        String value = ceil(num);
        return natural(value);
    }

    /**
     * 四舍五入并去掉末尾的零
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String roundNatural(BigDecimal num) {
        String value = round(num);
        return natural(value);
    }

    /**
     * 直接舍去并去掉末尾的零
     * 
     * @param num 数字值
     * @return 格式化后的数字
     */
    public static String floorNatural(BigDecimal num) {
        String value = floor(num);
        return natural(value);
    }
}
