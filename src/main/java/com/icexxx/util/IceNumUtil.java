package com.icexxx.util;

import java.math.BigDecimal;

/**
 * 数字工具类
 * 
 * @author IceWater
 * @version 2.0.3
 */
public class IceNumUtil {
    /**
     * 判断数字是否相等
     * 
     * @param num 原始数字
     * @param standard 标准值
     * @return 比较结果
     * @version 2.0.3
     */
    public static boolean equals(Integer num, Integer standard) {
        if (num == null) {
            if (standard == null) {
                return true;
            } else {
                return false;
            }
        } else if (num.equals(standard)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断数字是否相等
     * 
     * @param num 原始值
     * @param standard 标准值
     * @return 比较结果
     * @version 2.0.3
     */
    public static boolean equals(Long num, Long standard) {
        if (num == null) {
            if (standard == null) {
                return true;
            } else {
                return false;
            }
        } else if (standard == null) {
            return false;
        } else if (num.equals(standard.longValue())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断数字是否相等
     * 
     * @param num 原始值
     * @param standard 标准值
     * @return 比较结果
     * @version 2.0.3
     */
    public static boolean equals(Long num, Integer standard) {
        if (num == null) {
            if (standard == null) {
                return true;
            } else {
                return false;
            }
        } else if (standard == null) {
            return false;
        } else if (num.equals(standard.longValue())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断数字是否相等
     * 
     * @param num 原始值
     * @param standard 标准值
     * @return 比较结果
     * @version 2.0.3
     */
    public static boolean equals(Long num, BigDecimal standard) {
        if (num == null) {
            if (standard == null) {
                return true;
            } else {
                return false;
            }
        } else if (standard == null) {
            return false;
        } else if (num.equals(standard.longValue()) && !standard.toString().contains(".")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断数字与标准值是否相等
     * 
     * @param num 原始值
     * @param standard 标准值
     * @return 比较结果
     * @version 2.0.3
     */
    public static boolean equals(Long num, Byte standard) {
        if (num == null) {
            if (standard == null) {
                return true;
            } else {
                return false;
            }
        } else if (standard == null) {
            return false;
        } else if (num.equals(standard.longValue())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean equals(Integer num, Long standard) {
        if (num == null) {
            if (standard == null) {
                return true;
            } else {
                return false;
            }
        }
        return equals((Long) num.longValue(), standard);
    }

    public static boolean equals(Integer num, BigDecimal standard) {
        if (num == null) {
            if (standard == null) {
                return true;
            } else {
                return false;
            }
        }
        return equals((Long) num.longValue(), standard);
    }

    public static boolean equals(Integer num, Byte standard) {
        if (num == null) {
            if (standard == null) {
                return true;
            } else {
                return false;
            }
        }
        return equals((Long) num.longValue(), standard);
    }
}
