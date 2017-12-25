package com.icexxx.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IceJsonUtil {

    public static String format(Object obj) {
        return format(obj, 2);
    }

    public static <V> String format(Map<String, V> map) {
        return format(map, 2);
    }

    public static <T> String format(List<T> list) {
        return format(list, 2);
    }

    public static <T> String format(Set<T> set) {
        return format(set, 2);
    }

    public static String format(Object obj, int scale) {
        if (obj == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Class clazz = obj.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sb.append("{");
        int z = 0;
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            field.setAccessible(true);
            String type = field.getType().getName();
            String name = field.getName();
            if (name.startsWith("_")) {
                name = name.substring(1);
            }
            sb.append("\"");
            sb.append(name);
            sb.append("\":");
            try {
                if ("java.lang.String".equals(type)) {
                    Object value = field.get(obj);
                    if (value == null) {
                        sb.append(value);
                    } else {
                        sb.append("\"");
                        sb.append(value);
                        sb.append("\"");
                    }
                } else if ("java.lang.Integer".equals(type) || "int".equals(type)) {
                    sb.append(field.get(obj));
                } else if ("java.lang.Long".equals(type) || "long".equals(type)) {
                    sb.append(field.get(obj));
                } else if ("java.lang.Double".equals(type) || "double".equals(type)) {
                    sb.append(round(field.get(obj), scale));
                } else if ("java.lang.Float".equals(type) || "float".equals(type)) {
                    sb.append(field.get(obj));
                } else if ("java.lang.Byte".equals(type) || "byte".equals(type)) {
                    sb.append(field.get(obj));
                } else if ("java.lang.Character".equals(type) || "char".equals(type)) {
                    if (type == null) {
                        sb.append(field.get(obj));
                    } else {
                        sb.append("\"");
                        sb.append(field.get(obj));
                        sb.append("\"");
                    }
                } else if ("java.lang.Short".equals(type) || "short".equals(type)) {
                    sb.append(field.get(obj));
                } else if ("java.lang.Boolean".equals(type) || "boolean".equals(type)) {
                    sb.append(field.get(obj));
                } else if ("java.math.BigInteger".equals(type)) {
                    sb.append(field.get(obj));
                } else if ("java.math.BigDecimal".equals(type)) {
                    sb.append(round(field.get(obj), scale));
                } else if ("java.util.Map".equals(type)) {
                    sb.append(format((Map) field.get(obj), scale));
                } else if ("java.util.List".equals(type) || "java.util.Set".equals(type)) {
                    sb.append(format((List) field.get(obj), scale));
                } else if ("java.util.Set".equals(type)) {
                    sb.append(format((Set) field.get(obj), scale));
                } else if ("java.util.Date".equals(type)) {
                    if (type == null) {
                        sb.append(field.get(obj));
                    } else {
                        Date date = (Date) field.get(obj);
                        sb.append("\"");
                        sb.append(sdf.format(date));
                        sb.append("\"");
                    }
                } else {
                    sb.append(format(field.get(obj), scale));
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            field.setAccessible(false);
            if (i < declaredFields.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static <V> String format(Map<String, V> map, int scale) {
        if (map == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Set<Entry<String, V>> entrySet = map.entrySet();
        int count = 0;
        for (Entry<String, V> entry : entrySet) {
            String name = entry.getKey();
            V value = entry.getValue();
            sb.append("\"");
            sb.append(name);
            sb.append("\":");
            String type = null;
            if (value == null) {
                sb.append(value);
                continue;
            } else {
                type = value.getClass().getName();
            }
            if ("java.lang.String".equals(type)) {
                sb.append("\"");
                sb.append(value);
                sb.append("\"");
            } else if ("java.lang.Integer".equals(type) || "int".equals(type)) {
                sb.append(value);
            } else if ("java.lang.Long".equals(type) || "long".equals(type)) {
                sb.append(value);
            } else if ("java.lang.Double".equals(type) || "double".equals(type)) {
                sb.append(round(value, scale));
            } else if ("java.lang.Float".equals(type) || "float".equals(type)) {
                sb.append(value);
            } else if ("java.lang.Byte".equals(type) || "byte".equals(type)) {
                sb.append(value);
            } else if ("java.lang.Character".equals(type) || "char".equals(type)) {
                if (type == null) {
                    sb.append(value);
                } else {
                    sb.append("\"");
                    sb.append(value);
                    sb.append("\"");
                }
            } else if ("java.lang.Short".equals(type) || "short".equals(type)) {
                sb.append(value);
            } else if ("java.lang.Boolean".equals(type) || "boolean".equals(type)) {
                sb.append(value);
            } else if ("java.math.BigInteger".equals(type)) {
                sb.append(value);
            } else if ("java.math.BigDecimal".equals(type)) {
                sb.append(round(value, scale));
            } else if ("java.util.Map".equals(type)) {
                sb.append(format((Map) value, scale));
            } else if ("java.util.List".equals(type)) {
                sb.append(format((List) value, scale));
            } else if ("java.util.Set".equals(type)) {
                sb.append(format((Set) value, scale));
            } else if ("java.util.Date".equals(type)) {
                if (type == null) {
                    sb.append(value);
                } else {
                    Date date = (Date) value;
                    sb.append("\"");
                    sb.append(sdf.format(date));
                    sb.append("\"");
                }
            } else {
                sb.append(format(value, scale));
            }
            if (count < map.size() - 1) {
                sb.append(",");
            }
            count++;
        }
        sb.append("}");
        return sb.toString();

    }

    public static <T> String format(List<T> list, int scale) {
        if (list == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            if (t == null) {
                sb.append(t);
                continue;
            }
            if (t instanceof String) {
                sb.append("\"");
                sb.append(t);
                sb.append("\"");
            } else if (t instanceof Integer) {
                sb.append(t);
            } else if (t instanceof Long) {
                sb.append(t);
            } else if (t instanceof Double) {
                sb.append(round(t, scale));
            } else if (t instanceof Float) {
                sb.append(t);
            } else if (t instanceof Byte) {
                sb.append(t);
            } else if (t instanceof Short) {
                sb.append(t);
            } else if (t instanceof Boolean) {
                sb.append(t);
            } else if (t instanceof Integer) {
                sb.append(t);
            } else if (t instanceof BigInteger) {
                sb.append(t);
            } else if (t instanceof BigDecimal) {
                sb.append(round(t, scale));
            } else if (t instanceof Character) {
                sb.append("\"");
                sb.append(t);
                sb.append("\"");
            } else if (t instanceof Date) {
                Date date = (Date) t;
                sb.append("\"");
                sb.append(sdf.format(date));
                sb.append("\"");
            } else if (t instanceof Map) {
                sb.append(format((Map) t, scale));
            } else if (t instanceof List) {
                sb.append(format((List) t, scale));
            } else if (t instanceof Set) {
                sb.append(format((Set) t, scale));
            } else {
                sb.append(format(t, scale));
            }
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static <T> String format(Set<T> set, int scale) {
        if (set == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int count = 0;
        for (T t : set) {
            if (t == null) {
                sb.append(t);
                continue;
            }
            if (t instanceof String) {
                sb.append("\"");
                sb.append(t);
                sb.append("\"");
            } else if (t instanceof Integer) {
                sb.append(t);
            } else if (t instanceof Long) {
                sb.append(t);
            } else if (t instanceof Double) {
                sb.append(round(t, scale));
            } else if (t instanceof Float) {
                sb.append(t);
            } else if (t instanceof Byte) {
                sb.append(t);
            } else if (t instanceof Short) {
                sb.append(t);
            } else if (t instanceof Boolean) {
                sb.append(t);
            } else if (t instanceof Integer) {
                sb.append(t);
            } else if (t instanceof BigInteger) {
                sb.append(t);
            } else if (t instanceof BigDecimal) {
                sb.append(round(t, scale));
            } else if (t instanceof Character) {
                sb.append("\"");
                sb.append(t);
                sb.append("\"");
            } else if (t instanceof Date) {
                Date date = (Date) t;
                sb.append("\"");
                sb.append(sdf.format(date));
                sb.append("\"");
            } else if (t instanceof Map) {
                sb.append(format((Map) t, scale));
            } else if (t instanceof List) {
                sb.append(format((List) t, scale));
            } else if (t instanceof Set) {
                sb.append(format((Set) t, scale));
            } else {
                sb.append(format(t, scale));
            }

            if (count < set.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static String round(Double num, int scale) {
        if (num == null) {
            return null;
        }
        return new BigDecimal(num).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    private static Object round(Object object, int scale) {
        if (object instanceof Double) {
            return round((Double) object, scale);
        } else if (object instanceof java.math.BigDecimal) {
            return ((java.math.BigDecimal) object).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
        }
        return null;
    }
}
