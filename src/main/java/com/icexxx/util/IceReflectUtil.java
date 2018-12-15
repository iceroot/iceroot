package com.icexxx.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类
 * 
 * @author IceWater
 * @version 2.0.2
 */
public class IceReflectUtil {
    /**
     * 获取类上所有的属性,包括继承的属性
     * 
     * @param clazz 类对象
     * @return 获取的类上的属性
     * @since 2.0.2
     */
    public static List<Field> getFields(Class<?> clazz) {
        List<Field> list = new ArrayList<Field>();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            list.add(field);
        }
        Class<?> superclass = clazz.getSuperclass();
        if (!"java.lang.Object".equals(superclass.getName())) {
            list.addAll(getFields(superclass));
        }
        return list;
    }
}
