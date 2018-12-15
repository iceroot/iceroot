package com.icexxx.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.prefs.Preferences;

/**
 * 综合工具类
 * 
 * @author IceWater
 * @version 1.0.0
 */
public class IceUtil {
    /**
     * 生成uuid
     * 
     * @return 生成的uuid
     * @since 1.0.0
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * String数组转为Integer数组
     * 
     * @param strs 需要转换的String数组
     * @return 转换后的Integer数组
     * @since 1.0.0
     */
    public static Integer[] convert2Int(String[] strs) {
        Integer[] nums = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++) {
            try {
                nums[i] = Integer.parseInt(strs[i]);
            } catch (NumberFormatException e) {
                nums[i] = null;
            }
        }
        return nums;
    }

    /**
     * 延时若干毫秒
     * 
     * @param milliSecond 需要延时的毫秒数
     * @since 1.0.0
     */
    public static void sleep(long milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析日期字符串(使用yyyy-MM-dd HH:mm:ss格式)
     * 
     * @param str 日期字符串
     * @return 解析后的日期
     * @since 1.0.0
     */
    public static Date parseDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(IceConst.DATE_LONG_FORMAT);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用指定的格式解析日期字符串
     * 
     * @param str 日期字符串
     * @param formatStr 日期格式
     * @return 解析后的日期
     * @since 1.0.0
     */
    public static Date parseDate(String str, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用指定的日期格式格式化字符串
     * 
     * @param date 需要格式化的日期
     * @param formatStr 日期格式
     * @return 格式化后的日期字符串
     * @since 1.0.0
     */
    public static String formatDate(Date date, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(date);
    }

    /**
     * 计算两个日期间隔的天数，忽略时分秒
     * 
     * @param dateStart 开始时间
     * @param dateEnd 结束时间
     * @return 两个日期间隔的天数
     * @since 1.0.0
     */
    public static int dayLength(Date dateStart, Date dateEnd) {
        int sign = 1;
        if (dateStart.after(dateEnd)) {
            Date dateTemp = dateStart;
            dateStart = dateEnd;
            dateEnd = dateTemp;
            sign = -1;
        }
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(dateStart);
        calendarStart.set(Calendar.HOUR_OF_DAY, 1);
        calendarStart.set(Calendar.MINUTE, 0);
        calendarStart.set(Calendar.SECOND, 0);
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(dateEnd);
        calendarEnd.set(Calendar.HOUR_OF_DAY, 2);
        calendarEnd.set(Calendar.MINUTE, 0);
        calendarEnd.set(Calendar.SECOND, 0);
        long diffSecond = calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis();
        long diffDays = diffSecond / IceConst.SECOND_OF_DAY;
        return (int) diffDays * sign;
    }

    /**
     * 获取两个字符串中间的字符
     * 
     * @param str 原始字符串
     * @param left 左边的分隔符(从左边查找)
     * @param right 右边的分隔符(从右边查找)
     * @return 中间的字符串
     * @since 1.0.0
     */
    public static String between(String str, String left, String right) {
        int leftIndex = str.indexOf(left);
        int rightIndex = str.lastIndexOf(right);
        // if (leftIndex == -1) {
        // leftIndex = 0;
        // }
        if (rightIndex == -1) {
            rightIndex = str.length();
        }
        return str.substring(leftIndex + left.length(), rightIndex);
    }

    /**
     * 四舍五入,保留小数点后两位
     * 
     * @param num 需要四舍五入的数字
     * @return 四舍五入后的字符串
     * @since 1.0.0
     */
    public static String round(Double num) {
        return String.format("%.2f", num);
    }

    /**
     * 四舍五入,保留小数点后两位
     * 
     * @param num 需要四舍五入的数字
     * @return 四舍五入后的字符串
     * @since 1.0.0
     */
    public static String round(int num) {
        return num + ".00";
    }

    /**
     * 获取集合的第一个元素
     * 
     * @param list 原始集合
     * @param <T> 泛型
     * @return 集合中的第一个元素
     * @since 1.0.0
     */
    public static <T> T first(List<T> list) {
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * 获取数组中的第一个元素
     * 
     * @param array 原始数组
     * @param <T> 泛型
     * @return 数组中的第一个元素
     * @since 1.0.0
     */
    public static <T> T first(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        } else {
            return array[0];
        }
    }

    /**
     * 时间转为秒数
     * 
     * @param timeStr 字符串时分秒(HH:mm:ss)格式
     * @return 时分秒转换后的秒数
     * @since 1.0.0
     */
    public static int time2second(String timeStr) {
        String[] hms = timeStr.split(":");
        int hmsLength = hms.length;
        if (hmsLength == 2) {
            return Integer.parseInt(hms[0]) * 60 + Integer.parseInt(hms[1]);
        } else if (hmsLength == 3) {
            return Integer.parseInt(hms[0]) * 3600 + Integer.parseInt(hms[1]) * 60 + Integer.parseInt(hms[2]);
        } else if (hmsLength == 1) {
            return Integer.parseInt(hms[0]);
        } else {
            throw new RuntimeException("时间[" + timeStr + "]不是一个有效地时间格式");
        }
    }

    /**
     * 秒数转为时间格式(HH:mm:ss)
     * 
     * @param seconds 需要转换的秒数
     * @return 转换后的字符串
     * @since 1.0.0
     */
    public static String second2time(int seconds) {
        int hour = seconds / 3600;
        int other = seconds % 3600;
        int minute = other / 60;
        int second = other % 60;
        StringBuilder sb = new StringBuilder();
        if (hour < 10) {
            sb.append("0");
        }
        sb.append(hour);
        sb.append(":");
        if (minute < 10) {
            sb.append("0");
        }
        sb.append(minute);
        sb.append(":");
        if (second < 10) {
            sb.append("0");
        }
        sb.append(second);
        return sb.toString();
    }

    /**
     * 下划线字符串转为驼峰形式
     * 
     * @param str 原始字符串
     * @return 转换后的字符串
     * @since 1.0.0
     */
    public static String camelCase(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chs = str.toCharArray();
        boolean isUnderLine = false;
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (ch == '_') {
                isUnderLine = true;
            } else {
                if (isUnderLine) {
                    sb.append(String.valueOf(ch).toUpperCase());
                } else {
                    sb.append(String.valueOf(ch).toLowerCase());
                }
                isUnderLine = false;
            }
        }
        return sb.toString();
    }

    /**
     * 驼峰转为下划线形式
     * 
     * @param str 原始字符串
     * @return 转换后的字符串
     * @since 1.0.0
     */
    public static String underLine(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (Character.isUpperCase(ch)) {
                sb.append("_");
            }
            sb.append(ch);
        }
        return sb.toString().toLowerCase();
    }

    /**
     * 字符串转为int,无法转化时取默认值
     * 
     * @param numStr 需要转换的字符串
     * @param defaultValue 无法转换时的默认值
     * @return 转换后的int值
     * @since 1.0.0
     */
    public static int toInt(String numStr, int defaultValue) {
        try {
            return Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 判断枚举和字符串是否相等,以实际值为标准
     * 
     * @param enm 需要比较的枚举值
     * @param enumValue 需要比较的字符串
     * @return 比较结果
     * @since 1.0.0
     */
    public static boolean equalsEnum(Enum<?> enm, String enumValue) {
        if (enm == null) {
            if (enumValue == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (enumValue == null) {
                return false;
            } else {
                return enm.toString().equals(enumValue);
            }
        }
    }

    /**
     * 判断两个枚举是否相等
     * 
     * @param enm 第一个枚举变量
     * @param enumValue 第二个枚举变量
     * @return 比较结果
     * @since 1.0.0
     */
    public static boolean equalsEnum(Enum<?> enm, Enum<?> enumValue) {
        if (enm == null) {
            if (enumValue == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (enumValue == null) {
                return false;
            } else {
                return enm.equals(enumValue);
            }
        }
    }

    /**
     * 判断枚举和字符串是否相等
     * 
     * @param enm 需要比较的枚举值
     * @param enumValue 需要比较的字符串
     * @param ignoreCase 是否忽略大小写
     * @return 比较结果
     * @since 1.0.0
     */
    public static boolean equalsEnum(Enum<?> enm, String enumValue, boolean ignoreCase) {
        if (enm == null) {
            if (enumValue == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (enumValue == null) {
                return false;
            } else {
                if (ignoreCase) {
                    return enm.toString().equalsIgnoreCase(enumValue);
                } else {
                    return enm.toString().equals(enumValue);
                }
            }
        }
    }

    /**
     * 分页彩虹算法
     * 
     * @param currentPage 当前页
     * @param pageCount 总页数
     * @param displayCount 每屏展示的页数
     * @return 分页条
     * @since 1.0.0
     */
    public static int[] rainbow(int currentPage, int pageCount, int displayCount) {// TODO
        boolean isEven = true;
        isEven = displayCount % 2 == 0;
        int left = displayCount / 2;
        int right = displayCount / 2;

        int length = displayCount;
        if (isEven) {
            right++;
        }
        if (pageCount < displayCount) {
            length = pageCount;
        }
        int[] result = new int[length];
        if (pageCount >= displayCount) {
            if (currentPage <= left) {
                for (int i = 0; i < result.length; i++) {
                    result[i] = i + 1;
                }
            } else if (currentPage > pageCount - right) {
                for (int i = 0; i < result.length; i++) {
                    result[i] = i + pageCount - displayCount + 1;
                }
            } else {
                for (int i = 0; i < result.length; i++) {
                    result[i] = i + currentPage - left + (isEven ? 1 : 0);
                }
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                result[i] = i + 1;
            }
        }
        return result;

    }

    /**
     * 分页彩虹算法(默认展示10页)
     * 
     * @param currentPage 当前页
     * @param pageCount 总页数
     * @return 分页条
     * @since 1.0.0
     */
    public static int[] rainbow(int currentPage, int pageCount) {
        return rainbow(currentPage, pageCount, 10);
    }

    /**
     * 判断是否为闰年(考虑了3200年是否闰年问题)
     * 
     * @param year 需要判断闰年的年份
     * @return 是否为闰年
     * @since 1.0.0
     */
    public static boolean isLeapYear(int year) {
        if (year < 1) {
            throw new RuntimeException("公元元年以前的年份暂不支持,不支持的年份为" + year);
        }
        if (year < 1600) {
            return year % 4 == 0;
        } else {
            if (year % 3200 == 0) {
                return false;
            } else if (year % 400 == 0) {
                return true;
            } else if (year % 100 == 0) {
                return false;
            } else if (year % 4 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 判断某个月的天数(忽略1582年10月缺失十天问题)
     * 
     * @param year 年份
     * @param month 月数
     * @return 该月的天数
     * @since 1.0.0
     */
    public static int monthDays(int year, int month) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    /**
     * 路径去掉扩展名
     * 
     * @param fullName 原来的路径
     * @return 去掉扩展名的路径
     * @since 1.0.0
     */
    public static String pathRemoveExt(String fullName) {
        fullName = fullName.replace("\\", "/");
        int slashIndex = fullName.lastIndexOf("/");
        int pointIndex = fullName.lastIndexOf(".");
        if (pointIndex > slashIndex) {
            return fullName.substring(0, pointIndex);
        }
        return fullName;
    }

    /**
     * 判断是否存在指定名称指定值的环境变量
     * 
     * @param key 环境变量的名称
     * @param value 环境变量的值
     * @return 是否存在该名称该值的环境变量
     * @since 1.0.0
     */
    public static boolean hasEnv(String key, String value) {
        if (value == null || "".equals(value.trim())) {
            return false;
        }
        Preferences preferences = Preferences.systemRoot().node("/ice_water");
        return value.equalsIgnoreCase(preferences.get(key, "_null_mode_"));
    }

    /**
     * 判断是否为开发模式
     * 
     * @return 是否为开发模式
     * @since 1.0.0
     */
    public static boolean isDevMode() {
        return hasEnv("dev_java_mode", "_programming_mode_");
    }

    /**
     * 初始化环境数据
     * 
     * @param key 环境数据键名称
     * @param value 环境数据值名称
     * @since 1.0.0
     */
    public static void initEnv(String key, String value) {
        Preferences preferences = Preferences.systemRoot().node("/ice_water");
        if (key == null || "".equals(key.trim())) {
            key = "dev_java_mode";
        }
        preferences.put(key, value);
    }

    /**
     * 对字符串指定位置进行屏蔽(使用星号代替,基于前开后闭原则)
     * 
     * @param str 原字符串
     * @param start 需要屏蔽的起始位置
     * @param end 需要屏蔽的结束位置
     * @return 结果字符串
     * @since 1.0.0
     */
    public static String mistWord(String str, int start, int end) {
        if (str == null) {
            return null;
        }
        if ("".equals(str.trim())) {
            return "";
        }
        if (start < 0) {
            throw new RuntimeException("开始位置不可为负数");
        }
        if (end < 0) {
            throw new RuntimeException("结束位置不可为负数");
        }
        if (end < start) {
            int temp = start;
            start = end;
            end = temp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, start));
        if (end >= str.length()) {
            end = str.length() - 1;
        }
        int len = end - start;
        for (int i = 0; i < len; i++) {
            sb.append("*");
        }
        sb.append(str.substring(end + 1));
        return sb.toString();
    }

    /**
     * 调用有参方法
     * 
     * @param obj 需要调用方法的对象,静态方法则传入Class对象
     * @param methodName 方法名称
     * @param paramValue 方法值
     * @param paramType 方法类型
     * @return 方法的返回参数(没有返回值返回null)
     * @since 1.0.0
     */
    public static Object executeMethod(Object obj, String methodName, Object[] paramValue, Class<?>[] paramType) {
        Object result = null;
        try {
            if (obj instanceof Class) {
                Class<?> clazz = (Class<?>) obj;
                Method declaredMethod = clazz.getDeclaredMethod(methodName, paramType);
                declaredMethod.setAccessible(true);
                result = declaredMethod.invoke(null, paramValue);
                declaredMethod.setAccessible(false);
            } else {
                Class<?> clazz = obj.getClass();
                Method declaredMethod = clazz.getDeclaredMethod(methodName, paramType);
                declaredMethod.setAccessible(true);
                result = declaredMethod.invoke(obj, paramValue);
                declaredMethod.setAccessible(false);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 调用无参方法
     * 
     * @param obj 需要调用方法的对象,静态方法则传入Class对象
     * @param methodName 方法名称
     * @return 方法的返回参数(没有返回值返回null)
     * @since 1.0.0
     */
    public static Object executeMethod(Object obj, String methodName) {
        Object[] paramValue = new Object[] {};
        Class<?>[] paramType = new Class[] {};
        return executeMethod(obj, methodName, paramValue, paramType);
    }

    /**
     * 计算身份证校验位
     * 
     * @param numStr 身份证前17位
     * @return 计算的校验值
     * @since 1.0.0
     */
    public static String idCardlastValid(String numStr) {
        if (numStr == null) {
            throw new RuntimeException("输入的参数不能为空");
        }
        if (numStr.length() < 17) {
            throw new RuntimeException("输入的参数长度至少为17位");
        }
        String sub = numStr.substring(0, 17);
        int[] coefficient = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        String[] valid = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
        int sum = 0;
        for (int i = 0; i < sub.length(); i++) {
            int numCur = sub.charAt(i) - 48;
            sum += numCur * coefficient[i];
        }
        sum %= 11;
        return valid[sum];
    }

    /**
     * 判断校验位是否正确
     * 
     * @param numStr 18位证件号
     * @return 校验码是否正确
     * @since 1.0.0
     */
    public static boolean idCardValid(String numStr) {
        if (numStr == null) {
            throw new RuntimeException("输入的参数不能为空");
        }
        if (numStr.length() != 18) {
            throw new RuntimeException("输入的参数长度应为为18位");
        }
        String idCardlastValid = idCardlastValid(numStr);
        String lastChar = numStr.substring(17);
        return idCardlastValid.equalsIgnoreCase(lastChar);
    }

    /**
     * 使用指定的分割符拆分字符串
     * 
     * @param str 源字符串
     * @param limitChar 分隔符
     * @return 拆分后的字符串
     * @since 1.0.0
     */
    public static String[] splitTrim(String str, String limitChar) {
        if (str == null) {
            return null;
        }
        if ("".equals(str) || limitChar == null || "".equals(limitChar)) {
            return new String[] { str };
        }
        int limitLength = limitChar.length();
        if (limitLength > str.length()) {
            return new String[] { str };
        }
        List<String> list = new ArrayList<String>();
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i + limitLength > str.length()) {
                break;
            }
            String cur = str.substring(i, i + limitLength);
            if (limitChar.equals(cur)) {
                list.add(str.substring(start, i));
                start = i + limitLength;
                i += limitLength - 1;
            }
        }
        list.add(str.substring(start));
        int splitLength = list.size();
        String[] result = new String[splitLength];
        for (int i = 0; i < splitLength; i++) {
            result[i] = list.get(i).trim();
        }
        return result;
    }

    /**
     * 使用逗号拆分字符串
     * 
     * @param str 需要拆分的字符串
     * @return 拆分后的字符串
     * @since 1.0.0
     */
    public static String[] splitTrim(String str) {
        return splitTrim(str, ",");
    }

    /**
     * 根据url获取数据库驱动名称
     * 
     * @param url jdbc url
     * @return 获取的数据库驱动名称
     * @since 1.0.0
     */
    public static String getDriverName(String url) {
        if (url == null || "".equals(url)) {
            return null;
        }
        if (url.startsWith("jdbc:")) {
            String body = url.substring("jdbc:".length());
            if (body.startsWith("oracle")) {
                return "oracle.jdbc.driver.OracleDriver";
            } else if (body.startsWith("mysql")) {
                return "com.mysql.jdbc.Driver";
            } else if (body.startsWith("microsoft")) {
                return "com.microsoft.jdbc.sqlserver.SQLServerDriver";
            } else if (body.startsWith("sqlserver")) {
                return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            } else if (body.startsWith("db2")) {
                return "com.ibm.db2.jcc.DB2Driver";
            } else if (body.startsWith("postgresql")) {
                return "org.postgresql.Driver";
            } else if (body.startsWith("sybase")) {
                return "com.sybase.jdbc3.jdbc.SybDriver";
            } else if (body.startsWith("informix-sqli")) {
                return "com.informix.jdbc.IfxDriver";
            } else if (body.startsWith("teradata")) {
                return "com.ncr.teradata.TeraDriver";
            } else if (body.startsWith("netezza")) {
                return "org.netezza.Driver";
            } else if (body.startsWith("sqlite")) {
                return "org.sqlite.JDBC";
            } else if (body.startsWith("odbc")) {
                return "sun.jdbc.odbc.JdbcOdbcDriver";
            } else if (body.startsWith("derby")) {
                return "org.apache.derby.jdbc.ClientDriver";
            } else if (body.startsWith("hive2")) {
                return "org.apache.hive.jdbc.HiveDriver";
            } else if (body.startsWith("hive")) {
                return "org.apache.hadoop.hive.jdbc.HiveDriver";
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 根据url获取数据库名称
     * 
     * @param url jdbc url
     * @return 获取的数据库名称
     * @since 1.0.0
     */
    public static String getDatabaseName(String url) {
        if (url == null || "".equals(url)) {
            return null;
        }
        int indexOf = -1;
        String body = null;
        if (url.startsWith("jdbc:oracle")) {
            indexOf = url.indexOf("@");
            body = url.substring(indexOf + "@".length());
            if (body.startsWith("//")) {
                body = body.substring("//".length());
            }
            int paramLimit = body.indexOf("?");
            if (paramLimit != -1) {
                body = body.substring(0, paramLimit);
            }
            String[] split = body.split(":");
            if (split.length == 3) {
                return split[2];
            } else {
                return null;
            }
        } else {
            indexOf = url.indexOf("//");
            body = url.substring(indexOf + "//".length());
            int paramLimit = body.indexOf("?");
            if (paramLimit != -1) {
                body = body.substring(0, paramLimit);
            }
            indexOf = body.indexOf("/");
            if (indexOf == -1 || indexOf == body.length() - 1) {
                return null;
            } else {
                return body.substring(indexOf + 1);
            }
        }
    }

    /**
     * 将url参数转为map
     * 
     * 例如： find.html?name=zs&amp;age=18
     * 
     * @param url 需要转换的url
     * @return 转换后的map
     * @since 1.0.0
     */
    public static Map<String, String> url2map(String url) {
        int questionIndex = url.indexOf("?");
        String after = url;
        if (questionIndex != -1) {
            after = url.substring(questionIndex + 1);
        }
        String[] pairs = after.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < pairs.length; i++) {
            String pair = pairs[i];
            if (pair != null && !"".equals(pair)) {
                String[] param = pair.split("=");
                if (param.length > 1) {
                    String key = param[0];
                    String value = param[1];
                    map.put(key, value);
                } else if (param.length == 1) {
                    String key = param[0];
                    map.put(key, "");
                }
            }
        }
        return map;
    }

    /**
     * 通过java执行命令行
     * 
     * @param command 需要执行的命令
     * @return 命令执行后的返回结果
     * @since 1.0.0
     */
    public static String cmd(String command) {// linux由于环境问题暂未测试
        String osName = System.getProperty("os.name").toLowerCase();
        Runtime runtime = Runtime.getRuntime();
        String commandStr = command;
        String charset = "UTF-8";
        if (osName != null && osName.startsWith("windows")) {
            commandStr = "cmd.exe /c " + commandStr;
            charset = "GBK";
        }
        StringBuilder sb = new StringBuilder();
        Process process = null;
        String newLine = "\n";
        try {
            process = runtime.exec(commandStr);
            process.waitFor();
            InputStream inputStream = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(newLine);
            }
            String result = sb.toString();
            if (result != null && !"".equals(result.trim()) && !"null".equals(result)) {
                return result;
            }
            InputStream errorStream = process.getErrorStream();
            sb = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(errorStream, charset));
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(newLine);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (process != null) {
                process.destroy();
                process = null;
            }
        }
        return null;
    }

    /**
     * 获取当前类的类名
     * 
     * @param obj 当前类上下文(默认传入this.如果是静态方法传入null,传入null效率会比传入this低一些)
     * @return 当前类的类名
     * @since 1.0.0
     */
    public static String getClassName(final Object obj) {
        if (obj != null) {
            String className = new Object() {
                public String getName() {
                    return obj.getClass().getName();
                }
            }.getName();
            return className;
        } else {
            return Thread.currentThread().getStackTrace()[2].getClassName();
        }
    }

    /**
     * 判断一个字符串是否为json(不严格判断,仅判断开始结尾)
     * 
     * @param str 原始字符串
     * @return 字符串是否为json
     * @since 2.0.0
     */
    public static boolean isJson(String str) {
        if (str == null || "".equals(str)) {
            return false;
        } else {
            str = str.trim();
            if (str.startsWith("{") && str.endsWith("}")) {
                return true;
            }
            if (str.startsWith("[") && str.endsWith("]")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 替换路径中的斜线
     * 
     * @param str 需要替换的字符串
     * @return 替换后的字符串
     * @since 2.0.0
     */
    public static String replaceSlash(String str) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return "";
        }
        return str.replace("\\", "/");
    }

    /**
     * 在字符串前后添加百分号
     * 
     * @param str 原始字符串
     * @return 添加百分号以后的字符串
     * @since 2.0.0
     */
    public static String like(String str) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return "";
        }
        return "%" + str + "%";
    }

    /**
     * 获取桌面位置原始路径(使用操作系统原始分割线)
     * 
     * @return 桌面位置原始路径
     * @since 2.0.0
     */
    public static String desktopOriginal() {
        String osName = System.getProperty("os.name");
        String userName = System.getProperty("user.name");
        if ("Windows 7".equalsIgnoreCase(osName)) {
            return "C:\\Users\\" + userName + "\\Desktop";
        }
        if ("Windows xp".equalsIgnoreCase(osName)) {
            return "C:\\Documents and Settings\\" + userName + "\\桌面";
        }
        if (osName.startsWith("linux")) {
            return "/home/" + userName + "/Desktop";
        }
        if (osName.toLowerCase().startsWith("Windows".toLowerCase())) {
            return "C:\\Users\\" + userName + "\\Desktop";
        }
        if (osName.toLowerCase().startsWith("Linux".toLowerCase())) {
            return "/home/" + userName + "/Desktop";
        }
        if (osName.toLowerCase().startsWith("Mac".toLowerCase())) {
            return "/Users/" + userName + "/Desktop";
        }
        throw new RuntimeException("无法获取操作系统的桌面位置");
    }

    /**
     * 获取桌面位置标准路径(使用Linux系统分割线)
     * 
     * @return 桌面位置标准路径
     * @since 2.0.0
     */
    public static String desktop() {
        return desktopOriginal().replace("\\", "/");
    }

    /**
     * 对日期字符串进行标准化,统一转化为yyyy-MM-dd格式
     * 
     * @param dateStr 原始日期字符串
     * @return 标准化后的日期字符串
     * @since 2.0.0
     */
    public static String dateStandard(String dateStr) {
        String oldDateStr = dateStr;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (dateStr == null) {
            return null;
        }
        if ("".equals(dateStr)) {
            return "";
        }
        dateStr = dateStr.trim();
        int dateLength = dateStr.length();
        if (dateLength == 8) {// yyyyMMdd
            boolean allDigital = true;
            char[] charArray = dateStr.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char ch = charArray[i];
                if (!Character.isDigit(ch)) {
                    allDigital = false;
                    break;
                }
            }
            // 全为数字
            if (allDigital) {
                SimpleDateFormat sdfShort = new SimpleDateFormat("yyyyMMdd");
                try {
                    return sdf.format(sdfShort.parse(dateStr));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        if (dateStr.contains("年")) {
            dateStr = dateStr.replace("天", "日");
            if (!dateStr.endsWith("年") && !dateStr.endsWith("月") && !dateStr.endsWith("日")) {
                dateStr = dateStr + "日";
            }
            char[] charArray = dateStr.toCharArray();
            StringBuilder sb = new StringBuilder();
            String yearStr = null;
            String monthStr = null;
            String dayStr = null;
            for (int i = 0; i < charArray.length; i++) {
                char ch = charArray[i];
                if (ch == '年') {
                    yearStr = sb.toString();
                    sb = new StringBuilder();
                } else if (ch == '月') {
                    monthStr = sb.toString();
                    sb = new StringBuilder();
                } else if (ch == '日') {
                    dayStr = sb.toString();
                    sb = new StringBuilder();
                } else {
                    sb.append(ch);
                }
            }
            if (yearStr.length() < 4) {
                int padLength = 4 - yearStr.length();
                StringBuilder padZero = new StringBuilder();
                for (int i = 0; i < padLength; i++) {
                    padZero.append("0");
                }
                yearStr = padZero + yearStr;
            }
            if (monthStr.length() < 2) {
                monthStr = "0" + monthStr;
            }
            if (dayStr.length() < 2) {
                dayStr = "0" + dayStr;
            }
            sb = new StringBuilder();
            sb.append(yearStr);
            sb.append("-");
            sb.append(monthStr);
            sb.append("-");
            sb.append(dayStr);
            return sb.toString();
        }
        if (dateStr.contains(" ")) {
            int spaceIndex = dateStr.indexOf(" ");
            dateStr = dateStr.substring(0, spaceIndex);
        }
        dateStr = dateStr.replace(".", "-");
        dateStr = dateStr.replace("/", "-");
        dateStr = dateStr.replace("_", "-");
        dateStr = dateStr.replace("\\", "-");
        dateStr = dateStr.replace("|", "-");
        dateLength = dateStr.length();
        String[] dateArray = dateStr.split("-");
        if (dateArray.length != 3) {
            throw new RuntimeException("字符串:" + oldDateStr + "不是一个日期");
        }
        if (dateArray[0].length() > 2) {// 前面至少三位数
            if (dateLength == 10) {// yyyy-MM-dd
                return dateStr;
            } else {
                Date date = null;
                try {
                    date = sdf.parse(dateStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return sdf.format(date);
            }
        } else if (dateArray[2].length() > 2) {// 后面至少三位数
            SimpleDateFormat sdfYearAfter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = null;
            try {
                date = sdfYearAfter.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return sdf.format(date);
        } else {
            throw new RuntimeException("字符串:" + oldDateStr + "不是一个日期");
        }
    }

    /**
     * 根据二维表的某一列对二维表进行排序,返回排序后的二维表(使用默认排序器)
     * 
     * @param data 需要排序的二维表
     * @param index 排序的列的索引
     * @return 排序好的二维表
     * @since 2.0.0
     */
    public static String[][] sortTable(String[][] data, int index) {
        Map<String, String[]> map = new HashMap<String, String[]>();
        List<String> listKeys = new ArrayList<String>();

        for (int i = 0; i < data.length; i++) {
            String[] row = data[i];
            String key = row[index];
            map.put(key, row);
            listKeys.add(key);
        }
        Collections.sort(listKeys);
        String[][] result = new String[listKeys.size()][];
        for (int i = 0; i < listKeys.size(); i++) {
            String key = listKeys.get(i);
            result[i] = map.get(key);
        }
        return result;
    }

    /**
     * 根据二维表的某一列对二维表进行排序,返回排序后的二维表
     * 
     * @param data 需要排序的二维表
     * @param index 排序的列的索引
     * @param comparator 排序器
     * @return 排序好的二维表
     * @since 2.0.0
     */
    public static String[][] sortTable(String[][] data, int index, Comparator<String> comparator) {
        Map<String, String[]> map = new HashMap<String, String[]>();
        List<String> listKeys = new ArrayList<String>();

        for (int i = 0; i < data.length; i++) {
            String[] row = data[i];
            String key = row[index];
            map.put(key, row);
            listKeys.add(key);
        }
        Collections.sort(listKeys, comparator);
        String[][] result = new String[listKeys.size()][];
        for (int i = 0; i < listKeys.size(); i++) {
            String key = listKeys.get(i);
            result[i] = map.get(key);
        }
        return result;
    }

    /**
     * 对象转字符串,考虑null
     * 
     * @param obj 原始对象
     * @return 转换后的字符串
     * @since 2.0.0
     */
    public static String toStringConsiderNull(Object obj) {
        if (obj == null) {
            return null;
        } else {
            return obj.toString();
        }
    }

    /**
     * 去掉特殊字符 \ufeff
     * 
     * @param str 原始字符串
     * @return 去掉特殊字符后的字符串
     * @since 2.0.0
     */
    public static String removeFEFF(String str) {
        return str.replace("\ufeff", "");
    }

    /**
     * 计算除法,除数为零使用默认值
     * 
     * @param num1 被除数
     * @param num2 除数
     * @param defaultValue 除数为零使用的默认值
     * @return 计算结果
     * @since 2.0.0
     */
    public static String defaultDivisionZero(Double num1, Double num2, String defaultValue) {
        if (num1 == null || num2 == null) {
            return "0";
        }
        Double microscopic = 0.000000000000001;
        if (num2 > 0) {
            if (num2 - 0 < microscopic) {
                return defaultValue;
            }
        } else if (num2 < 0) {
            if (0 - num2 > microscopic) {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
        return new Double(num1 / num2).toString();
    }

    /**
     * 去掉集合中的第一个元素
     * 
     * @param list 原始集合
     * @param <T> 泛型
     * @return 去掉第一个元素的新集合
     * @since 2.0.0
     */
    public static <T> List<T> removeFirst(List<T> list) {
        if (list != null && list.size() > 0) {
            List<T> newList = new ArrayList<T>();
            for (int i = 1; i < list.size(); i++) {
                T t = list.get(i);
                newList.add(t);
            }
            return newList;
        } else {
            return list;
        }
    }

    /**
     * 去掉集合中的最后一个元素
     * 
     * @param list 原始集合
     * @param <T> 泛型
     * @return 去掉最后一个元素的新集合
     * @since 2.0.0
     */
    public static <T> List<T> removeLast(List<T> list) {
        if (list != null && list.size() > 0) {
            List<T> newList = new ArrayList<T>();
            for (int i = 0; i < list.size() - 1; i++) {
                T t = list.get(i);
                newList.add(t);
            }
            return newList;
        } else {
            return list;
        }
    }

    /**
     * 如果集合不存在创建新集合,否则使用原来的集合
     * 
     * @param list 原始集合
     * @param <T> 泛型
     * @return 新集合
     * @since 2.0.0
     */
    public static <T> List<T> newListIfNull(List<T> list) {
        if (list == null) {
            return new ArrayList<T>();
        } else {
            return list;
        }
    }

    /**
     * 去掉List中Map元素的泛型
     * 
     * @param list 原始集合
     * @param <T> 泛型
     * @return 去掉泛型后的集合
     * @since 2.0.0
     */
    public static <T> List<Map<String, Object>> removeGeneric(List<Map<String, T>> list) {
        if (list == null) {
            return null;
        }
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, T> map = list.get(i);
            Map<String, Object> newMap = new HashMap<String, Object>();
            newMap.putAll(map);
            result.add(newMap);
        }
        return result;
    }

    /**
     * 去掉开始和结尾的指定字符
     * 
     * @param str 原始字符串
     * @param prefix 前缀
     * @param suffix 后缀
     * @return 去掉开始和结尾后的字符
     * @since 2.0.0
     */
    public static String removeFirstAndLast(String str, String prefix, String suffix) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return "";
        }
        if (str.startsWith(prefix)) {
            str = str.substring(prefix.length());
        }
        if (str.endsWith(suffix)) {
            str = str.substring(0, str.length() - suffix.length());
        }
        return str;
    }

    /**
     * 计算百分比
     * 
     * @param num 原始数据(小数)
     * @param newScale 计算完百分比后小数点后的位数
     * @return 计算结果
     * @since 2.0.0
     */
    public static String percentage(Double num, int newScale) {
        BigDecimal decimal = new BigDecimal(num);
        BigDecimal hundred = new BigDecimal("100");
        decimal = decimal.multiply(hundred);
        return decimal.setScale(newScale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 数组去重复
     * 
     * @param array 原始数组
     * @param <T> 泛型
     * @return 去掉重复后的数组
     * @since 2.0.0
     */
    public static <T> T[] distinct(T[] array) {
        if (array == null) {
            return null;
        }
        if (array.length < 2) {
            return array;
        }
        List<T> newList = new ArrayList<T>();
        for (int i = 0; i < array.length; i++) {
            T t = array[i];
            if (!newList.contains(t)) {
                newList.add(t);
            }
        }
        T[] result = createGenericArray(newList);
        for (int i = 0; i < newList.size(); i++) {
            result[i] = newList.get(i);
        }
        return result;
    }

    private static <T> T[] createGenericArray(List<T> list) {
        T t = list.get(0);
        if (t instanceof String) {
            String[] array = new String[list.size()];
            return (T[]) array;
        }
        if (t instanceof Integer) {
            Integer[] array = new Integer[list.size()];
            return (T[]) array;
        }
        if (t instanceof Long) {
            Long[] array = new Long[list.size()];
            return (T[]) array;
        }
        if (t instanceof Double) {
            Double[] array = new Double[list.size()];
            return (T[]) array;
        }
        if (t instanceof Boolean) {
            Boolean[] array = new Boolean[list.size()];
            return (T[]) array;
        }
        if (t instanceof Character) {
            Character[] array = new Character[list.size()];
            return (T[]) array;
        }
        if (t instanceof Byte) {
            Byte[] array = new Byte[list.size()];
            return (T[]) array;
        }
        if (t instanceof Short) {
            Short[] array = new Short[list.size()];
            return (T[]) array;
        }
        if (t instanceof Float) {
            Float[] array = new Float[list.size()];
            return (T[]) array;
        }
        if (t instanceof java.sql.Date) {
            java.sql.Date[] array = new java.sql.Date[list.size()];
            return (T[]) array;
        }
        if (t instanceof java.util.Date) {
            java.util.Date[] array = new java.util.Date[list.size()];
            return (T[]) array;
        }
        if (t instanceof List) {
            List[] array = new List[list.size()];
            return (T[]) array;
        }
        if (t instanceof Map) {
            Map[] array = new Map[list.size()];
            return (T[]) array;
        }
        if (t instanceof java.util.Set) {
            java.util.Set[] array = new java.util.Set[list.size()];
            return (T[]) array;
        }
        if (t instanceof java.math.BigInteger) {
            java.math.BigInteger[] array = new java.math.BigInteger[list.size()];
            return (T[]) array;
        }
        if (t instanceof java.math.BigDecimal) {
            java.math.BigDecimal[] array = new java.math.BigDecimal[list.size()];
            return (T[]) array;
        }
        throw new RuntimeException("不可识别的类型:" + t.getClass());
    }

    private static <T> T[] createGenericArray(T[] array) {
        T t = array[0];
        if (t instanceof String) {
            String[] newArray = new String[array.length];
            return (T[]) newArray;
        }
        if (t instanceof Integer) {
            Integer[] newArray = new Integer[array.length];
            return (T[]) newArray;
        }
        if (t instanceof Long) {
            Long[] newArray = new Long[array.length];
            return (T[]) newArray;
        }
        if (t instanceof Double) {
            Double[] newArray = new Double[array.length];
            return (T[]) newArray;
        }
        if (t instanceof Boolean) {
            Boolean[] newArray = new Boolean[array.length];
            return (T[]) newArray;
        }
        if (t instanceof Character) {
            Character[] newArray = new Character[array.length];
            return (T[]) newArray;
        }
        if (t instanceof Byte) {
            Byte[] newArray = new Byte[array.length];
            return (T[]) newArray;
        }
        if (t instanceof Short) {
            Short[] newArray = new Short[array.length];
            return (T[]) newArray;
        }
        if (t instanceof Float) {
            Float[] newArray = new Float[array.length];
            return (T[]) newArray;
        }
        if (t instanceof java.sql.Date) {
            java.sql.Date[] newArray = new java.sql.Date[array.length];
            return (T[]) newArray;
        }
        if (t instanceof java.util.Date) {
            java.util.Date[] newArray = new java.util.Date[array.length];
            return (T[]) newArray;
        }
        if (t instanceof List) {
            List[] newArray = new List[array.length];
            return (T[]) newArray;
        }
        if (t instanceof Map) {
            Map[] newArray = new Map[array.length];
            return (T[]) newArray;
        }
        if (t instanceof java.util.Set) {
            java.util.Set[] newArray = new java.util.Set[array.length];
            return (T[]) newArray;
        }
        if (t instanceof java.math.BigInteger) {
            java.math.BigInteger[] newArray = new java.math.BigInteger[array.length];
            return (T[]) newArray;
        }
        if (t instanceof java.math.BigDecimal) {
            java.math.BigDecimal[] newArray = new java.math.BigDecimal[array.length];
            return (T[]) newArray;
        }
        throw new RuntimeException("不可识别的类型:" + t.getClass());
    }

    /**
     * 复制集合
     * 
     * @param list 原始集合
     * @param <T> 泛型
     * @return 复制后的集合
     * @since 2.0.0
     */
    public static <T> List<T> createList(List<T> list) {
        if (list == null) {
            return null;
        }
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            result.add(t);
        }
        return result;
    }

    /**
     * 复制Map
     * 
     * @param map 原始Map
     * @return 复制后的Map
     * @param <K> 泛型Map键
     * @param <V> 泛型Map值
     * @since 2.0.0
     */
    public static <K, V> Map<K, V> createMap(Map<K, V> map) {
        if (map == null) {
            return null;
        }
        Map<K, V> result = new HashMap<K, V>();
        result.putAll(map);
        return result;
    }

    /**
     * 判断是否为空或空字符串
     * 
     * @param obj 需要判断的对象
     * @return 是否为空字符串
     * @since 2.0.0
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if ("".equals(obj)) {
            return true;
        }
        return false;
    }

    /**
     * 获取中午
     * 
     * @param date 原始日期对象
     * @return 日期对象修改时间为中午
     * @since 2.0.0
     */
    public static Date noon(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 数组转为集合
     * 
     * @param array 原始数组
     * @param <T> 泛型
     * @return 转换后的集合
     * @since 2.0.0
     */
    public static <T> List<T> toList(T[] array) {
        if (array == null) {
            return null;
        }
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    /**
     * 集合转为数组
     * 
     * @param list 原始集合
     * @param <T> 泛型
     * @return 转换后的数组
     * @since 2.0.0
     */
    public static <T> T[] toArray(List<T> list) {
        if (list == null) {
            return null;
        }
        T[] array = createGenericArray(list);
        return list.toArray(array);
    }

    /**
     * 对Map进行迭代
     * 
     * @param map 原始Map
     * @param <K> 泛型Map键
     * @param <V> 泛型Map值
     * @return Map迭代结果
     * @since 2.0.0
     */
    public static <K, V> List<Map.Entry<K, V>> forMap(Map<K, V> map) {
        if (map == null) {
            return null;
        }
        Set<Entry<K, V>> entrySet = map.entrySet();
        List<Entry<K, V>> list = new ArrayList<Entry<K, V>>(entrySet);
        return list;
    }

    /**
     * 星期序号转星期名称
     * 
     * @param num 星期序号
     * @return 星期名称
     * @since 2.0.0
     */
    public static String weekName(int num) {
        switch (num) {
        case 0:
            return "星期日";
        case 1:
            return "星期一";
        case 2:
            return "星期二";
        case 3:
            return "星期三";
        case 4:
            return "星期四";
        case 5:
            return "星期五";
        case 6:
            return "星期六";
        case 7:
            return "星期日";
        default:
            throw new RuntimeException("给定的星期序号错误:" + num);
        }
    }

    /**
     * 将数组截取为指定长度,长度不足补null
     * 
     * @param array 原始数组
     * @param size 需要截取的数组长度
     * @param <T> 泛型
     * @return 截取后的新数组
     * @since 2.0.0
     */
    public static <T> T[] subArray(T[] array, int size) {
        if (size < 0) {
            throw new RuntimeException("给定的数组长度错误:" + size);
        }
        if (array == null || array.length == 0) {
            return null;
        } else {
            List<T> list = new ArrayList<T>();
            for (int i = 0; i < size; i++) {
                if (i < array.length) {
                    list.add(array[i]);
                } else {
                    list.add(null);
                }
            }
            T[] newArray = createGenericArray(list);
            return list.toArray(newArray);
        }
    }

    /**
     * 替换字符串,保留原始的大小写
     * 
     * @param str 原始字符串
     * @param oldStr 需要替换的字符串
     * @param newStr 替换成的字符串
     * @return 替换后的字符串
     * @since 2.0.0
     */
    public static String replaceCap(String str, String oldStr, String newStr) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return "";
        }
        if (oldStr != null && !"".equals(oldStr) && newStr != null) {
            str = str.replace(cap(oldStr), cap(newStr));
            str = str.replace(uncap(oldStr), uncap(newStr));
        }
        return str;
    }

    private static String cap(String str) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return "";
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String uncap(String str) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return "";
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    /**
     * sql对特殊字符转义
     * 
     * @param sql 原始sql
     * @return 转换后的sql
     * @since 2.0.0
     */
    public static String sqlHtml(String sql) {
        if (sql == null) {
            return null;
        }
        if ("".equals(sql)) {
            return "";
        }
        sql = sql.replace("<", "&lt;");
        sql = sql.replace(">", "&gt;");
        return sql;
    }

    /**
     * sql对特殊字符反转义
     * 
     * @param sql 原始sql
     * @return 转换后的sql
     * @since 2.0.0
     */
    public static String sqlChar(String sql) {
        if (sql == null) {
            return null;
        }
        if ("".equals(sql)) {
            return "";
        }
        sql = sql.replace("&lt;", "<");
        sql = sql.replace("&gt;", ">");
        return sql;
    }

    /**
     * 计算两个日期间隔的月数
     * 
     * @param ymd1 第一个日期
     * @param ymd2 第二个日期
     * @return 两个日期间隔的月数
     * @since 2.0.0
     */
    public static int diffMonth(String ymd1, String ymd2) {
        ymd1 = ymd1.replace(".", "-");
        ymd1 = ymd1.replace("_", "-");
        ymd1 = ymd1.replace("/", "-");
        ymd2 = ymd2.replace(".", "-");
        ymd2 = ymd2.replace("_", "-");
        ymd2 = ymd2.replace("/", "-");
        String[] ymd1Array = ymd1.split("-");
        String[] ymd2Array = ymd2.split("-");
        if (ymd1Array.length < 2) {
            throw new RuntimeException("日期格式不正确:" + ymd1);
        }
        if (ymd2Array.length < 2) {
            throw new RuntimeException("日期格式不正确:" + ymd2);
        }
        int month1 = Integer.parseInt(ymd1Array[0]) * 12 + Integer.parseInt(ymd1Array[1]);
        int month2 = Integer.parseInt(ymd2Array[0]) * 12 + Integer.parseInt(ymd2Array[1]);
        return month2 - month1;
    }

    /**
     * 去掉字符串前两个单词
     * 
     * @param str 原始字符串
     * @param prefix1 第一个前缀
     * @param prefix2 第二个前缀
     * @return 去掉两个前缀后的字符串
     * @since 2.0.0
     */
    public static String removeDoubleFirst(String str, String prefix1, String prefix2) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return "";
        }
        str = str.trim();
        if (prefix1 != null && !"".equals(prefix1)) {
            if (str.startsWith(prefix1)) {
                str = str.substring(prefix1.length());
            }
        }
        str = str.trim();
        if (prefix2 != null && !"".equals(prefix2)) {
            if (str.startsWith(prefix2)) {
                str = str.substring(prefix2.length());
            }
        }
        str = str.trim();
        return str;
    }

    /**
     * 去掉字符串后两个单词
     * 
     * @param str 原始字符串
     * @param prefix1 第一个前缀
     * @param prefix2 第二个前缀
     * @return 去掉两个后缀以后的字符串
     * @since 2.0.0
     */
    public static String removeDoubleLast(String str, String prefix1, String prefix2) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return "";
        }
        str = str.trim();
        if (prefix2 != null && !"".equals(prefix2)) {
            if (str.endsWith(prefix2)) {
                str = str.substring(0, str.length() - prefix2.length());
            }
        }
        str = str.trim();
        if (prefix1 != null && !"".equals(prefix1)) {
            if (str.endsWith(prefix1)) {
                str = str.substring(0, str.length() - prefix1.length());
            }
        }
        str = str.trim();
        return str;
    }

    /**
     * 从url获取数据库名称
     * 
     * @param url JDBC url
     * @return 获取的数据库名称
     * @since 2.0.0
     */
    public static String urlDatabaseName(String url) {
        if (url == null || "".equals(url)) {
            return null;
        }
        url = url.toLowerCase();
        if (url.startsWith("jdbc:mysql:")) {
            return "mysql";
        } else if (url.startsWith("jdbc:oracle:")) {
            return "oracle";
        } else if (url.startsWith("jdbc:sqlserver:")) {
            return "sqlserver2005";
        } else if (url.startsWith("jdbc:microsoft:sqlserver:")) {
            return "sqlserver2000";
        } else if (url.startsWith("jdbc:db2:")) {
            return "db2";
        } else if (url.startsWith("jdbc:sybase:Tds:".toLowerCase())) {
            return "sybase";
        } else if (url.startsWith("jdbc:postgresql:")) {
            return "postgresql";
        } else if (url.startsWith("jdbc:sqlite:")) {
            return "sqlite";
        } else if (url.startsWith("jdbc:hive2:")) {
            return "hive2";
        } else if (url.startsWith("jdbc:hive:")) {
            return "hive";
        } else if (url.startsWith("jdbc:derby:")) {
            return "derby";
        } else {
            throw new RuntimeException("不可识别的数据库格式:" + url);
        }
    }

    /**
     * 判断数组是否包含指定字符串(不区分大小写,数组的元素进行trim)
     * 
     * @param array 指定的数组
     * @param str 包含的对象
     * @return 是否包含指定字符串
     * @since 2.0.0
     */
    public static boolean contain(String[] array, String str) {
        if (array == null || array.length == 0) {
            return false;
        }
        if (str == null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < array.length; i++) {
                String cur = array[i];
                if (cur == null) {
                    continue;
                }
                if (str.equalsIgnoreCase(cur.trim())) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 替换字符串引号外的字符
     * 
     * @param str 原始字符串
     * @param oldStr 需要替换的字符串
     * @param newStr 替换成的字符串
     * @return 替换后的字符串
     * @since 2.0.0
     */
    public static String replaceQuotationOut(String str, String oldStr, String newStr) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return "";
        }
        if (oldStr == null || "".equals(oldStr) || newStr == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder span = new StringBuilder();
        int stack = 0;
        int quot = 0;
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (ch == '\'') {
                if (stack == 0) {
                    sb.append(span.toString().replace(oldStr, newStr));
                    span = new StringBuilder("\'");
                } else if (stack == 1) {
                    if (quot == 2) {
                        span.append("\'");
                    }
                } else if (stack == 2) {
                    span.append("\'");
                }
                if (quot == 0) {
                    stack++;
                    quot = 1;
                } else if (quot == 1) {
                    stack--;
                    if (stack == 0) {
                        quot = 0;
                    } else if (stack == 1) {
                        quot = 2;
                    }
                } else if (quot == 2) {
                    stack++;
                    quot = 1;
                }
                if (stack == 0) {
                    sb.append(span);
                    span = new StringBuilder("\'");
                }
            } else if (ch == '\"') {
                if (stack == 0) {
                    sb.append(span.toString().replace(oldStr, newStr));
                    span = new StringBuilder("\"");
                } else if (stack == 1) {
                    if (quot == 1) {
                        span.append("\"");
                    }
                } else if (stack == 2) {
                    span.append("\"");
                }
                if (quot == 0) {
                    stack++;
                    quot = 2;
                } else if (quot == 1) {
                    stack++;
                    quot = 2;
                } else if (quot == 2) {
                    stack--;
                    if (stack == 0) {
                        quot = 0;
                    } else if (stack == 1) {
                        quot = 1;
                    }
                }
                if (stack == 0) {
                    sb.append(span);
                    span = new StringBuilder("\"");
                }
            } else {
                span.append(ch);
            }
        }
        sb.append(span.toString().replace(oldStr, newStr));
        return sb.toString();
    }

    /**
     * 获取二维数组中的某一列
     * 
     * @param table 二维数组
     * @param index 列序号
     * @return 需要获取的二维数组的某一列
     * @since 2.0.0
     */
    public static String[] arrayColumn(String[][] table, int index) {
        if (table == null) {
            return null;
        }
        if (index < 0) {
            throw new RuntimeException("列序号不正确:" + index);
        }
        String[] columns = new String[table.length];
        for (int i = 0; i < table.length; i++) {
            try {
                columns[i] = table[i][index];
            } catch (ArrayIndexOutOfBoundsException e) {
                columns[i] = null;
            }
        }
        return columns;
    }

    /**
     * 将单个值变为数组
     * 
     * @param t 原始数据
     * @param <T> 泛型
     * @return 根据原始数据创建的数组
     * @since 2.0.0
     */
    public static <T> T[] array2simple(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof String) {
            String[] newArray = new String[] { (String) t };
            return (T[]) newArray;
        }
        if (t instanceof Integer) {
            Integer[] newArray = new Integer[] { (Integer) t };
            return (T[]) newArray;
        }
        if (t instanceof Long) {
            Long[] newArray = new Long[] { (Long) t };
            return (T[]) newArray;
        }
        if (t instanceof Double) {
            Double[] newArray = new Double[] { (Double) t };
            return (T[]) newArray;
        }
        if (t instanceof Boolean) {
            Boolean[] newArray = new Boolean[] { (Boolean) t };
            return (T[]) newArray;
        }
        if (t instanceof Character) {
            Character[] newArray = new Character[] { (Character) t };
            return (T[]) newArray;
        }
        if (t instanceof Byte) {
            Byte[] newArray = new Byte[] { (Byte) t };
            return (T[]) newArray;
        }
        if (t instanceof Short) {
            Short[] newArray = new Short[] { (Short) t };
            return (T[]) newArray;
        }
        if (t instanceof Float) {
            Float[] newArray = new Float[] { (Float) t };
            return (T[]) newArray;
        }
        if (t instanceof java.sql.Date) {
            java.sql.Date[] newArray = new java.sql.Date[] { (java.sql.Date) t };
            return (T[]) newArray;
        }
        if (t instanceof java.util.Date) {
            java.util.Date[] newArray = new java.util.Date[] { (java.util.Date) t };
            return (T[]) newArray;
        }
        if (t instanceof List) {
            List[] newArray = new List[] { (List) t };
            return (T[]) newArray;
        }
        if (t instanceof Map) {
            Map[] newArray = new Map[] { (Map) t };
            return (T[]) newArray;
        }
        if (t instanceof java.util.Set) {
            java.util.Set[] newArray = new java.util.Set[] { (java.util.Set) t };
            return (T[]) newArray;
        }
        if (t instanceof java.math.BigInteger) {
            java.math.BigInteger[] newArray = new java.math.BigInteger[] { (java.math.BigInteger) t };
            return (T[]) newArray;
        }
        if (t instanceof java.math.BigDecimal) {
            java.math.BigDecimal[] newArray = new java.math.BigDecimal[] { (java.math.BigDecimal) t };
            return (T[]) newArray;
        }
        throw new RuntimeException("不可识别的类型:" + t.getClass());
    }

    /**
     * 单个值转为List
     * 
     * @param t 原始值
     * @param <T> 泛型
     * @return 转换后的List
     * @since 2.0.0
     */
    public static <T> List<T> simple2List(T t) {
        if (t == null) {
            return null;
        }
        List<T> list = new ArrayList<T>();
        list.add(t);
        return list;
    }

    /**
     * 单个值转为Map
     * 
     * @param key 传入的键
     * @param value 传入的值
     * @param <K> 泛型Map键
     * @param <V> 泛型Map值
     * @return 返回的Map
     * @since 2.0.0
     */
    public static <K, V> Map<K, V> simple2Map(K key, V value) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(key, value);
        return map;
    }

    /**
     * 判断url是否以http开头或https开头
     * 
     * @param url 原始url
     * @return 是否以http或https开头
     * @since 2.0.0
     */
    public static boolean isHttp(String url) {
        if (url == null || "".equals(url)) {
            return false;
        }
        url = url.trim();
        url = url.toLowerCase();
        if (url.startsWith("http://") || url.startsWith("https://")) {
            return true;
        }
        return false;
    }

    /**
     * 比较两个版本号
     * 
     * @param version1 第一个版本号
     * @param version2 第二个版本号
     * @return 比较结果(-1,1,0) 1小于 0等于 -1大于
     * @since 2.0.0
     */
    @Deprecated
    public static int versionCompare(String version1, String version2) {
        if (version1 == null || "".equals(version1)) {
            throw new RuntimeException("第一个版本号为空或空字符串");
        }
        if (version2 == null || "".equals(version2)) {
            throw new RuntimeException("第二个版本号为空或空字符串");
        }
        version1 = version1.trim();
        version2 = version2.trim();
        if (version1.toLowerCase().startsWith("v")) {
            version1 = version1.substring(1);
        }
        if (version2.toLowerCase().startsWith("v")) {
            version2 = version2.substring(1);
        }
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");
        int length1 = array1.length;
        int length2 = array2.length;
        int min = length1;
        if (length2 < length1) {
            min = length2;
        }
        for (int i = 0; i < min; i++) {
            int num1 = Integer.parseInt(array1[i]);
            int num2 = Integer.parseInt(array2[i]);
            if (num1 > num2) {
                return -1;
            } else if (num1 < num2) {
                return 1;
            }
        }
        if (length1 > length2) {
            return -1;
        } else if (length1 < length2) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 比较两个版本号
     * 
     * @param version1 第一个版本号
     * @param version2 第二个版本号
     * @return 比较结果(-1,1,0) -1小于 0等于 1大于
     * @since 2.0.1
     */
    public static int version(String version1, String version2) {
        if (version1 == null || "".equals(version1)) {
            throw new RuntimeException("第一个版本号为空或空字符串");
        }
        if (version2 == null || "".equals(version2)) {
            throw new RuntimeException("第二个版本号为空或空字符串");
        }
        version1 = version1.trim();
        version2 = version2.trim();
        if (version1.toLowerCase().startsWith("v")) {
            version1 = version1.substring(1);
        }
        if (version2.toLowerCase().startsWith("v")) {
            version2 = version2.substring(1);
        }
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");
        int length1 = array1.length;
        int length2 = array2.length;
        int min = length1;
        if (length2 < length1) {
            min = length2;
        }
        for (int i = 0; i < min; i++) {
            int num1 = Integer.parseInt(array1[i]);
            int num2 = Integer.parseInt(array2[i]);
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        if (length1 > length2) {
            return 1;
        } else if (length1 < length2) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * 求平均数
     * 
     * @param list 原始数据
     * @return 原始数据的平均数
     * @since 2.0.1
     */
    public static double avg(List<Double> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        double sum = 0d;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sum += list.get(i);
        }
        return sum / size;
    }

    /**
     * 获取从左数左边的字符串
     * 
     * @param str 原始字符串
     * @param subStr 子字符串
     * @return 字符串截取结果
     * @since 2.0.1
     */
    public static String getLeftFromLeft(String str, String subStr) {
        if (str == null || "".equals(str)) {
            return str;
        }
        if (subStr == null || "".equals(subStr)) {
            return str;
        }
        int index = str.indexOf(subStr);
        if (index == -1) {
            return str;
        }
        return str.substring(0, index);
    }

    /**
     * 获取从右数左边的字符串
     * 
     * @param str 原始字符串
     * @param subStr 子字符串
     * @return 字符串截取结果
     * @since 2.0.1
     */
    public static String getLeftFromRight(String str, String subStr) {
        if (str == null || "".equals(str)) {
            return str;
        }
        if (subStr == null || "".equals(subStr)) {
            return str;
        }
        int index = str.lastIndexOf(subStr);
        if (index == -1) {
            return str;
        }
        return str.substring(0, index);
    }

    /**
     * 获取从左数右边的字符串
     * 
     * @param str 原始字符串
     * @param subStr 子字符串
     * @return 字符串截取结果
     * @since 2.0.1
     */
    public static String getRightFromLeft(String str, String subStr) {
        if (str == null || "".equals(str)) {
            return str;
        }
        if (subStr == null || "".equals(subStr)) {
            return str;
        }
        int index = str.indexOf(subStr);
        if (index == -1) {
            return str;
        }
        return str.substring(index + subStr.length());
    }

    /**
     * 获取从右数右边的字符串
     * 
     * @param str 原始字符串
     * @param subStr 子字符串
     * @return 字符串截取结果
     * @since 2.0.1
     */
    public static String getRightFromRight(String str, String subStr) {
        if (str == null || "".equals(str)) {
            return str;
        }
        if (subStr == null || "".equals(subStr)) {
            return str;
        }
        int index = str.lastIndexOf(subStr);
        if (index == -1) {
            return str;
        }
        return str.substring(index + subStr.length());
    }

    /**
     * 包装字符串
     * 
     * @param str 原始字符串
     * @param left 左边的字符串
     * @param right 右边的字符串
     * @return 拼接后的字符串
     * @since 2.0.1
     */
    public static String wrap(String str, String left, String right) {
        StringBuilder sb = new StringBuilder();
        if (left != null) {
            sb.append(left);
        }
        if (str != null) {
            sb.append(str);
        }
        if (right != null) {
            sb.append(right);
        }
        return sb.toString();
    }

    /**
     * 去掉左右的字符串
     * 
     * @param str 原始字符串
     * @param left 左边的子字符串
     * @param right 右边的子字符串
     * @return 切割后的字符串
     * @since 2.0.1
     */
    public static String unWrap(String str, String left, String right) {
        if (str == null || "".equals(str)) {
            return str;
        }
        if (left != null && !"".equals(left)) {
            if (str.startsWith(left)) {
                str = str.substring(left.length());
            }
        }
        if (right != null && !"".equals(right)) {
            if (str.endsWith(right)) {
                str = str.substring(0, str.length() - right.length());
            }
        }
        return str;
    }

    /**
     * 求最大值
     * 
     * @param num1 第一个数字
     * @param num2 第二个数字
     * @param num3 第三个数字
     * @return 最大的数字
     * @since 2.0.1
     */
    public static double max(double num1, double num2, double num3) {
        double max = num1;
        if (num2 > max) {
            max = num2;
        }
        if (num3 > max) {
            return num3;
        }
        return max;
    }

    /**
     * 求最小值
     * 
     * @param num1 第一个数字
     * @param num2 第二个数字
     * @param num3 第三个数字
     * @return 最小的数字
     * @since 2.0.1
     */
    public static int min(int num1, int num2, int num3) {
        int min = num1;
        if (num2 < min) {
            min = num2;
        }
        if (num3 < min) {
            return num3;
        }
        return min;
    }

    /**
     * 求最大值
     * 
     * @param num1 第一个数字
     * @param num2 第二个数字
     * @param num3 第三个数字
     * @return 最大的数字
     * @since 2.0.1
     */
    public static int max(int num1, int num2, int num3) {
        int max = num1;
        if (num2 > max) {
            max = num2;
        }
        if (num3 > max) {
            return num3;
        }
        return max;
    }

    /**
     * 求最小值
     * 
     * @param num1 第一个数字
     * @param num2 第二个数字
     * @param num3 第三个数字
     * @return 最小的数字
     * @since 2.0.1
     */
    public static double min(double num1, double num2, double num3) {
        double min = num1;
        if (num2 < min) {
            min = num2;
        }
        if (num3 < min) {
            return num3;
        }
        return min;
    }

    /**
     * 去除字符串结尾的斜线
     * 
     * @param str 原始字符串
     * @return 结果字符串
     * @since 2.0.1
     */
    public static String removeSlash(String str) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        if (str.endsWith("/")) {
            return str.substring(0, str.length() - 1);
        } else {
            return str;
        }
    }

    /**
     * 在字符串末尾添加斜线
     * 
     * @param str 原始字符串
     * @return 结果字符串
     * @since 2.0.1
     */
    public static String addSlash(String str) {
        if (str == null || "".equals(str)) {
            return "/";
        }
        if (str.endsWith("/")) {
            return str;
        } else {
            return str + "/";
        }
    }

    /**
     * 截取字符串左边n个字符串
     * 
     * @param str 原始字符串
     * @param size 截取的字符串个数
     * @return 结果字符串
     * @since 2.0.1
     */
    public static String left(String str, int size) {
        if (str == null || "".equals(str)) {
            return str;
        }
        if (size > 0) {
            if (size > str.length()) {
                return str;
            } else {
                return str.substring(0, size);
            }
        } else if (size == 0) {
            return "";
        } else {
            size = -size;
            if (size > str.length()) {
                return str;
            }
            return str.substring(str.length() - size);
        }
    }

    /**
     * 截取字符串右边n个字符串
     * 
     * @param str 原始字符串
     * @param size 截取的字符串个数
     * @return 结果字符串
     * @since 2.0.1
     */
    public static String right(String str, int size) {
        if (str == null || "".equals(str)) {
            return str;
        }
        if (size > 0) {
            if (size > str.length()) {
                return str;
            }
            return str.substring(str.length() - size);
        } else if (size == 0) {
            return "";
        } else {
            size = -size;
            if (size > str.length()) {
                return str;
            }
            return str.substring(0, size);
        }
    }

    /**
     * 对字符串进行循环移位
     * 
     * @param str 原始字符串
     * @param offest 移动的位数
     * @return 移位后的字符串
     * @since 2.0.1
     */
    public static String move(String str, int offest) {
        if (str == null || "".equals(str)) {
            return str;
        }
        int length = str.length();
        if (offest < 0) {
            if (offest < -length) {
                offest = offest % length;
            }
            offest = offest + length;
        }
        if (offest > length) {
            offest = offest % length;
        }
        return str.substring(length - offest) + str.substring(0, length - offest);
    }

    /**
     * 对字符串进行替换
     * 
     * @param bys 原始字节数组
     * @param offset 移动量
     * @return 替换后的字节数组
     * @since 2.0.1
     */
    public static byte[] replacement(byte[] bys, int offset) {
        if (bys == null) {
            return null;
        }
        if (bys.length == 0) {
            return bys;
        }
        int length = bys.length;
        if (bys == null || length == 0) {
            return bys;
        }
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            result[i] = (byte) (bys[i] + (byte) offset);
        }
        return result;
    }

    /**
     * 向map添加数据,重复时保留原来的
     * 
     * @param map 原始Map
     * @param <K> key 键
     * @param <V> value 值
     * @param key 键
     * @param value 值
     * @return 返回的新Map
     * @since 2.0.1
     */
    public static <K, V> Map<K, V> put(Map<K, V> map, K key, V value) {
        V valueOld = map.get(key);
        if (valueOld == null) {
            map.put(key, value);
        }
        return map;
    }

    /**
     * List&lt;Object&gt;转为List&lt;String&gt;
     * 
     * @param list 原始List
     * @return 转换后的List
     * @since 2.0.1
     */
    public static List<String> listString(List<Object> list) {
        if (list == null) {
            return null;
        }
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            Object object = list.get(i);
            String current = null;
            if (object != null) {
                current = object + "";
            }
            result.add(current);
        }
        return result;
    }

    /**
     * 将List 转为 List&lt;String&gt;
     * 
     * @param list 原始List
     * @return 转换后的List
     * @since 2.0.1
     */
    public static List<String> list(List list) {
        if (list == null) {
            return null;
        }
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            Object object = list.get(i);
            String current = null;
            if (object != null) {
                current = object + "";
            }
            result.add(current);
        }
        return result;
    }

    /**
     * map值类型转为字符串
     * 
     * @param map 原始Map
     * @return 转换后的Map
     * @since 2.0.1
     */
    public static Map<String, String> mapString(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Map<String, String> result = new HashMap<String, String>();
        if (map.isEmpty()) {
            return result;
        }
        Set<Entry<String, Object>> entrySet = map.entrySet();
        Iterator<Entry<String, Object>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            Object value = next.getValue();
            if (value == null) {
                result.put(key, null);
            } else {
                result.put(key, value + "");
            }
        }
        return result;
    }

    /**
     * map值类型转为字符串
     * 
     * @param map 原始Map
     * @return 转换后的Map
     * @since 2.0.1
     */
    public static Map<String, String> map(Map map) {
        if (map == null) {
            return null;
        }
        Map<String, String> result = new HashMap<String, String>();
        if (map.isEmpty()) {
            return result;
        }
        Set<Entry<String, Object>> entrySet = map.entrySet();
        Iterator<Entry<String, Object>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            Object value = next.getValue();
            if (value == null) {
                result.put(key, null);
            } else {
                result.put(key, value + "");
            }
        }
        return result;
    }

    /**
     * 集合完全去重复(只要重复了就删除)
     * 
     * @param list 原始集合
     * @param <T> 泛型
     * @return 去重复后的集合
     * @since 2.0.1
     */
    public static <T> List<T> deduplication(List<T> list) {
        if (list == null) {
            return null;
        }
        if (list.size() <= 1) {
            return list;
        }
        List<T> repeatList = new ArrayList<T>();
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < list.size(); i++) {
            T current = list.get(i);
            int index = repeatList.indexOf(current);
            if (index == -1) {
                int indexResult = result.indexOf(current);
                if (indexResult == -1) {
                    result.add(current);
                } else {
                    result.remove(current);
                    repeatList.add(current);
                }
            }
        }
        return result;
    }

    /**
     * 将字符串转化为数字
     * 
     * @param str 原始字符串
     * @return 转换后的数字
     * @since 2.0.1
     */
    public static Integer parseInt(String str) {
        if (str == null || "".equals(str.trim())) {
            return null;
        }
        str = str.trim();
        boolean negative = str.startsWith("-");
        if (negative) {
            str = str.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            } else {
                break;
            }
        }
        if (sb.length() == 0) {
            return null;
        }
        int num = Integer.parseInt(sb.toString());
        if (negative) {
            num = -num;
        }
        return num;
    }

    /**
     * 多个map合并
     * 
     * @param list 存放map的集合
     * @param <K> 键
     * @param <V> 值
     * @return 合并后的Map
     * @since 2.0.1
     */
    public static <K, V> Map<K, V> join(List<Map<K, V>> list) {
        if (list == null) {
            return null;
        }
        Map<K, V> result = new HashMap<K, V>();
        for (int i = 0; i < list.size(); i++) {
            Map<K, V> map = list.get(i);
            if (map != null) {
                result.putAll(map);
            }
        }
        return result;
    }

    /**
     * 判断一个数字是否在开闭区间内
     * 
     * @param expression 开闭区间表达式
     * @param num 需要判断的数字
     * @return 判断结果
     * @since 2.0.1
     */
    public static boolean contain(String expression, int num) {
        if (expression == null || "".equals(expression.trim())) {
            throw new RuntimeException("表达式不能为空");
        }
        if (!expression.startsWith("[") && !expression.startsWith("(")) {
            throw new RuntimeException("表达式必须以[或(开头");
        }
        if (!expression.endsWith("]") && !expression.endsWith(")")) {
            throw new RuntimeException("表达式必须以]或)结尾");
        }
        String exp = expression.substring(0, expression.length() - 1);
        int index = exp.indexOf(",");
        if (index == -1) {
            throw new RuntimeException("表达式中间必须含有逗号");
        }
        String left = expression.substring(0, 1);
        String right = expression.substring(expression.length() - 1);
        String leftNumStr = exp.substring(1, index);
        String rightNumStr = exp.substring(index + 1);
        leftNumStr = leftNumStr.trim();
        rightNumStr = rightNumStr.trim();
        int leftNum = 0;
        try {
            leftNum = Integer.parseInt(leftNumStr);
        } catch (NumberFormatException e) {
            throw new RuntimeException("表达式" + expression + "含有非数字" + leftNumStr);
        }
        int rightNum = 0;
        try {
            rightNum = Integer.parseInt(rightNumStr);
        } catch (NumberFormatException e) {
            throw new RuntimeException("表达式" + expression + "含有非数字" + rightNumStr);
        }
        boolean flag = false;
        if ("[".equals(left)) {
            if (num >= leftNum) {
                flag = true;
            }
        } else if ("(".equals(left)) {
            if (num > leftNum) {
                flag = true;
            }
        }
        if (!flag) {
            return false;
        }
        if ("]".equals(right)) {
            if (num <= rightNum) {
                flag = true;
            }
        } else if (")".equals(right)) {
            if (num < rightNum) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 创建文件夹
     * 
     * @param fileName 文件(夹)名称
     * @return 是否进行了文件夹创建
     * @since 2.0.1
     */
    public static boolean mkdir(String fileName) {
        if (fileName == null || "".equals(fileName.trim())) {
            throw new RuntimeException("文件名称不可为空");
        }
        fileName = fileName.replace("\\", "/");
        File file = new File(fileName);
        if (file.exists()) {
            return false;
        }
        if (fileName.endsWith("/")) {
            return file.mkdirs();
        }
        int index = fileName.lastIndexOf("/");
        if (index == -1) {
            return file.mkdirs();
        }
        String simpleName = fileName.substring(index + 1);
        int indexPoint = simpleName.lastIndexOf(".");
        if (indexPoint == -1) {
            return file.mkdirs();
        }
        String folder = fileName.substring(0, index);
        file = new File(folder);
        if (file.exists()) {
            return false;
        }
        return file.mkdirs();
    }

    /**
     * 修改字符串的值
     * 
     * @param str 原始字符串
     * @param value 新值
     * @since 2.0.1
     */
    public static void change(String str, String value) {
        try {
            Field fieldValue = String.class.getDeclaredField("value");
            fieldValue.setAccessible(true);
            fieldValue.set(str, value.toCharArray());
            fieldValue.setAccessible(false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 月份的名称
     * 
     * @param month 月份序号,从0开始
     * @return 月份名称
     * @since 2.0.1
     */
    public static String monthName(int month) {
        switch (month) {
        case 0:
            return "一月";
        case 1:
            return "二月";
        case 2:
            return "三月";
        case 3:
            return "四月";
        case 4:
            return "五月";
        case 5:
            return "六月";
        case 6:
            return "七月";
        case 7:
            return "八月";
        case 8:
            return "九月";
        case 9:
            return "十月";
        case 10:
            return "十一月";
        case 11:
            return "十二月";
        default:
            throw new RuntimeException("月份的数值必须在0-11之间");
        }
    }

    /**
     * 为逗号分隔的每个字符串增加单引号
     * 
     * @param str 原始字符串
     * @return 拼接后的新字符串
     * @since 2.0.1
     */
    public static String wrapChar(String str) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return "''";
        }
        String[] array = str.split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append("'");
            String current = array[i];
            if (current != null) {
                sb.append(current.trim());
            }
            sb.append("'");
            if (i != array.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * 替换字符串中的模板,找不到不替换
     * 
     * @param str 原始字符串
     * @param map 替换的字符串键值表
     * @return 替换后的字符串
     * @since 2.0.1
     */
    public static String template(String str, Map<String, String> map) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        char[] chs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder keyBuilder = new StringBuilder();
        boolean inner = false;
        int length = str.length();
        int trunk = length - 3;// ${}的长度
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (inner) {
                if (ch != '}') {
                    keyBuilder.append(ch);
                    continue;
                } else {
                    String key = keyBuilder.toString();
                    String value = map.get(key);
                    if (value != null) {
                        sb.append(value);
                    } else {
                        sb.append("${");
                        sb.append(key);
                        sb.append("}");
                    }
                    inner = false;
                    keyBuilder = new StringBuilder();
                }
            } else {
                if (i < trunk) {
                    if (ch == '$' && chs[i + 1] == '{') {
                        inner = true;
                        i++;
                    } else {
                        sb.append(ch);
                    }
                } else {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 字符串取相反值
     * 
     * @param value 原始值
     * @param trueValue 枚举值1
     * @param falseValue 枚举值2
     * @return 获取的相反值
     * @since 2.0.2
     */
    public static String not(String value, String trueValue, String falseValue) {
        if (value == null || "".equals(value)) {
            return value;
        }
        if (value.equals(trueValue)) {
            return falseValue;
        }
        if (value.equals(falseValue)) {
            return trueValue;
        }
        return value;
    }

    /**
     * 负数转为零
     * 
     * @param num 原始数字
     * @return 转换后的结果
     * @since 2.0.2
     */
    public static BigDecimal negative2Zero(BigDecimal num) {
        if (num == null) {
            return null;
        }
        if (num.compareTo(new BigDecimal("0")) == -1) {
            return new BigDecimal("0");
        } else {
            return num;
        }
    }

    /**
     * 逗号分隔字符串转List
     * 
     * @param str 逗号分隔的字符串
     * @return 转换后的数组
     * @since 2.0.2
     */
    public static List<Integer> commaStr2List(String str) {
        List<Integer> list = new ArrayList<Integer>();
        if (str == null || "".equals(str)) {
            return list;
        }
        str = str.trim();
        String[] strArray = str.split(",");
        for (int i = 0; i < strArray.length; i++) {
            String numberStr = strArray[i];
            if (numberStr == null || "".equals(numberStr.trim())) {
                continue;
            }
            Integer num = null;
            try {
                num = Integer.parseInt(numberStr.trim());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (num != null) {
                list.add(num);
            }
        }
        return list;
    }

    /**
     * 如果集合为空,添加-1
     * 
     * @param list 原始集合
     * @return 处理后的集合
     * @since 2.0.2
     */
    public static List<Integer> addDefault(List<Integer> list) {
        List<Integer> result = new ArrayList<Integer>();
        if (list == null || list.size() == 0) {
            result.add(-1);
            return result;
        } else {
            return list;
        }
    }

    /**
     * 返回真值
     * 
     * @return 返回的值
     * @since 2.0.2
     */
    public static boolean trueFunction() {
        return true;
    }

    /**
     * 返回假值
     * 
     * @return 返回的值
     * @since 2.0.2
     */
    public static boolean falseFunction() {
        return false;
    }

    /**
     * 返回首字母拼接后的字符串
     * 
     * @param str 原始字符串
     * @return 首字母拼接后的字符串
     * @since 2.0.2
     */
    public static String firstLetter(String str) {
        if (str == null) {
            return null;
        }
        str = str.trim();
        String[] strArray = str.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            String word = strArray[i];
            if (word != null && !"".equals(word)) {
                sb.append(word.charAt(0));
            }
        }
        return sb.toString();
    }

    /**
     * 根据键和值创建Map
     * 
     * @param key 键
     * @param value 值
     * @return 创建后的Map
     * @since 2.0.2
     */
    public static Map<String, String> createMap(String key, String value) {
        Map<String, String> map = new HashMap<String, String>();
        map.put(key, value);
        return map;
    }

    /**
     * 根据键和值创建Map
     * 
     * @param key1 第一个键
     * @param value1 第一个值
     * @param key2 第二个键
     * @param value2 第二个值
     * @return 创建后的Map
     * @since 2.0.2
     */
    public static Map<String, String> createMap(String key1, String value1, String key2, String value2) {
        Map<String, String> map = new HashMap<String, String>();
        map.put(key1, value1);
        map.put(key2, value2);
        return map;
    }

    /**
     * 判断是否为null或空字符串
     * 
     * @param val 需要判断的值
     * @return 是否为null或空字符串
     * @since 2.0.2
     */
    public static boolean isEmptyStr(Object val) {
        if (val == null || "".equals(val)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 对象转为字符串,null转为空字符串
     * 
     * @param val 原始值
     * @return 转化后的数值
     * @since 2.0.2
     */
    public static String toString(Object val) {
        if (val == null || "".equals(val)) {
            return "";
        } else {
            return val + "";
        }
    }
}
