package com.icexxx.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.prefs.Preferences;
/**
 * 综合工具类
 * @author IceWater
 * @date 2017-02-24
 * @version 1.0
 */
public class IceUtil {
    /**
     * 生成uuid
     * @return 生成的uuid
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * String数组转为Integer数组
     * @param strs 需要转换的String数组
     * @return 转换后的Integer数组
     */
    public static Integer[] convert2Int(String[] strs) {
        Integer[] nums = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++) {
            try {
                nums[i] = Integer.parseInt(strs[i]);
            } catch (NumberFormatException e) {
                // e.printStackTrace();
                nums[i] = null;
            }
        }
        return nums;
    }

    /**
     * 延时若干毫秒
     * 
     * @param millinSecond 需要延时的毫秒数
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
     * @param str 日期字符串
     * @return 解析后的日期
     */
    public static Date parseDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(IceConst.DATE_LONG_FORMAT);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 使用指定的格式解析日期字符串
     * @param str 日期字符串
     * @param formatStr 日期格式
     * @return 解析后的日期
     */
    public static Date parseDate(String str, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用指定的日期格式格式化字符串
     * @param date 需要格式化的日期
     * @param formatStr 日期格式
     * @return 格式化后的日期字符串
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
     * @param str 原始字符串
     * @param left 左边的分隔符(从左边查找)
     * @param right 右边的分隔符(从右边查找)
     * @return 中间的字符串
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
     * @param num 需要四舍五入的数字
     * @return 四舍五入后的字符串
     */
    public static String round(Double num) {
        return String.format("%.2f", num);
    }

    /**
     * 四舍五入,保留小数点后两位
     * @param num 需要四舍五入的数字
     * @return 四舍五入后的字符串
     */
    public static String round(int num) {
        return num + ".00";
    }

    /**
     * 获取集合的第一个元素
     * @param list 原始集合
     * @return 集合中的第一个元素
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
     * @param array 原始数组
     * @return 数组中的第一个元素
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
     * @param timeStr 字符串时分秒(HH:mm:ss)格式
     * @return 时分秒转换后的秒数
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
     * @param seconds 需要转换的秒数
     * @return 转换后的字符串
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
     * @param str 原始字符串
     * @return 转换后的字符串
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
     * @param str 原始字符串
     * @return 转换后的字符串
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
     * @param numStr 需要转换的字符串
     * @param defaultValue 无法转换时的默认值
     * @return 转换后的int值
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
     * @param enm 需要比较的枚举值
     * @param enumValue 需要比较的字符串
     * @return 比较结果
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
     * @param enm 第一个枚举变量
     * @param enumValue 第二个枚举变量
     * @return 比较结果
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
     * @param enm 需要比较的枚举值
     * @param enumValue 需要比较的字符串
     * @param ignoreCase 是否忽略大小写
     * @return 比较结果
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
            // if(currentPage<=pageCount){
            for (int i = 0; i < result.length; i++) {
                result[i] = i + 1;
            }
            // }else{
            // throw new
            // RuntimeException("当前页"+currentPage+"不应该大于总页数"+pageCount);
            // }
        }
        return result;

    }
    
    /**
     * 分页彩虹算法(默认展示10页)
     * @param currentPage 当前页
     * @param pageCount 总页数
     * @return 分页条
     */
    public static int[] rainbow(int currentPage, int pageCount) {
        return rainbow(currentPage, pageCount, 10);
    }

    /**
     * 判断是否为闰年(考虑了3200年是否闰年问题)
     * @param year 需要判断闰年的年份
     * @return 是否为闰年
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
     * @param year 年份
     * @param month 月数
     * @return 该月的天数
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
     * @param fullName 原来的路径
     * @return 去掉扩展名的路径
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
     * @param key 环境变量的名称
     * @param value 环境变量的值
     * @return 是否存在该名称该值的环境变量
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
     * @return 是否为开发模式
     */
    public static boolean isDevMode(){
        return hasEnv("dev_java_mode", "_programming_mode_");
    }
    
    /**
     * 初始化环境数据
     * 
     * @param key
     *            环境数据键名称
     * @param value
     *            环境数据值名称
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
     * @param str 原字符串
     * @param start 需要屏蔽的起始位置
     * @param end 需要屏蔽的结束位置
     * @return 结果字符串
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
     * @param obj 需要调用方法的对象,静态方法则传入Class对象
     * @param methodName 方法名称
     * @param paramValue 方法值
     * @param paramType 方法类型
     * @return 方法的返回参数(没有返回值返回null)
     */
    public static Object executeMethod(Object obj,String methodName,Object[]paramValue,Class<?>[]paramType){
        Object result = null;
        try {
            if(obj instanceof Class){
                Class<?>clazz=(Class<?>)obj;
                Method declaredMethod = clazz.getDeclaredMethod(methodName, paramType);
                declaredMethod.setAccessible(true);
                result = declaredMethod.invoke(null, paramValue);
                declaredMethod.setAccessible(false);
            }else{
                Class<?>clazz=obj.getClass();
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
     * @param obj 需要调用方法的对象,静态方法则传入Class对象
     * @param methodName 方法名称
     * @return 方法的返回参数(没有返回值返回null)
     */
    public static Object executeMethod(Object obj, String methodName) {
        Object[] paramValue = new Object[] {};
        Class<?>[] paramType = new Class[] {};
        return executeMethod(obj, methodName, paramValue, paramType);
    }

    /**
     * 计算身份证校验位
     * 
     * @param numStr
     *            身份证前17位
     * @return 计算的校验值
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
     * @param numStr
     *            18位证件号
     * @return 校验码是否正确
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
     * @param str
     *            源字符串
     * @param limitChar
     *            分隔符
     * @return 拆分后的字符串
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
     * @param str
     *            需要拆分的字符串
     * @return 拆分后的字符串
     */
    public static String[] splitTrim(String str) {
        return splitTrim(str, ",");
    }
    /**
     * 根据url获取数据库驱动名称
     * @param url  jdbc url
     * @return 获取的数据库驱动名称
     */
    public static String getDriverName(String url){
        if(url==null||"".equals(url)){
            return null;
        }
        if(url.startsWith("jdbc:")){
            String body=url.substring("jdbc:".length());
            if(body.startsWith("oracle")){
                return "oracle.jdbc.driver.OracleDriver";
            }else if(body.startsWith("mysql")){
                return "com.mysql.jdbc.Driver";
            }else if(body.startsWith("microsoft")){
                return "com.microsoft.jdbc.sqlserver.SQLServerDriver";
            }else if(body.startsWith("sqlserver")){
                return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            }else if(body.startsWith("db2")){
                return "com.ibm.db2.jcc.DB2Driver";
            }else if(body.startsWith("postgresql")){
                return "org.postgresql.Driver";
            }else if(body.startsWith("sybase")){
                return "com.sybase.jdbc3.jdbc.SybDriver";
            }else if(body.startsWith("informix-sqli")){
                return "com.informix.jdbc.IfxDriver";
            }else if(body.startsWith("teradata")){
                return "com.ncr.teradata.TeraDriver";
            }else if(body.startsWith("netezza")){
                return "org.netezza.Driver";
            }else if(body.startsWith("sqlite")){
                return "org.sqlite.JDBC";
            }else if(body.startsWith("odbc")){
                return "sun.jdbc.odbc.JdbcOdbcDriver";
            }else if(body.startsWith("derby")){
                return "org.apache.derby.jdbc.EmbeddedDriver";
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    /**
     * 根据url获取数据库名称
     * 
     * @param url
     *            jdbc url
     * @return 获取的数据库名称
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
     * 例如： find.html?name=zs&age=18
     * 
     * @param url
     *            需要转换的url
     * @return 转换后的map
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
     * @param command 需要执行的命令
     * @return 命令执行后的返回结果
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
}
