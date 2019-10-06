package com.icexxx.util;

import java.lang.reflect.Field;

/**
 * 枚举工具类
 * 
 * @author IceWater
 * @version 2.0.3
 */
public class IceEnumUtil {
    /**
     * 判断枚举code属性是否与数字相等
     * 
     * @param enums 枚举值
     * @param num 标准值
     * @return 比较结果
     * @version 2.0.3
     */
    @SuppressWarnings("rawtypes")
    public static <T extends Enum> boolean equals(Enum enums, Integer num) {
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) enums.getClass();
        Field field = null;
        try {
            field = clazz.getField("code");
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        } catch (SecurityException e1) {
            e1.printStackTrace();
        }
        field.setAccessible(true);
        Object value = null;
        try {
            value = field.get(enums);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (value == null) {
            if (num == null) {
                return true;
            } else {
                return false;
            }
        } else if (num != null) {
            if (value instanceof Integer) {
                return value.equals(num);
            }
            if (value instanceof Long) {
                return value.equals(num);
            }
        }
        return false;
    }
}
