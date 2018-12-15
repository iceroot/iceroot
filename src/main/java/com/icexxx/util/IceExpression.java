package com.icexxx.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Map表达式工具类
 * 
 * @author IceWater
 * @version 2.0.2
 */
public class IceExpression {
    /**
     * 根据map表达式创建map
     * 
     * @param expression map表达式
     * @param value map的值
     * @return 创建好的Map
     * @since 2.0.2
     */
    public static Map toMap(String expression, String value) {
        if (expression == null || "".equals(expression)) {
            return null;
        }
        if (!expression.contains(".")) {
            Map map = new HashMap();
            map.put(expression, value);
            return map;
        }
        String[] strArray = expression.split("\\.");
        Map map = new HashMap();
        Object val = value;
        for (int i = strArray.length - 1; i >= 0; i--) {
            String key = strArray[i];
            Map mapCurrent = new HashMap();
            mapCurrent.put(key, val);
            val = mapCurrent;
        }
        return (Map) val;
    }
}
