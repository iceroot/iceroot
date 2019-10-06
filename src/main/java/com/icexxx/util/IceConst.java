package com.icexxx.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * 常量工具类
 * 
 * @author IceWater
 * @version 1.0
 */
public class IceConst {
    public static final String OK = "0";
    public static final String SUCCESS = "0";
    public static final String YES = "YES";
    public static final String NO = "NO";
    public static final String ON = "ON";
    public static final String OFF = "OFF";
    public static final String DATE_LONG_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_SHORT_FORMAT = "yyyy-MM-dd";
    public static final BigDecimal ZERO = new BigDecimal("0");
    public static final BigDecimal ONE = new BigDecimal("1");
    public static final BigDecimal HUNDRED = new BigDecimal("100");// 一元等于100分
    public static final long SECOND_OF_DAY = 86400000L;// 一天的毫秒数
    public static final String ALPHABET_LOWER = "abcdefghijklmnopqrstuvwxyz";// 小写字母
    public static final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";// 大写字母
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";// mysql
                                                                      // jdbc驱动类名
    public static final String MYSQL_DRIVER_OLD = "org.gjt.mm.mysql.Driver";// mysql
                                                                            // jdbc驱动类名(旧版本)
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";// oracle
                                                                                 // jdbc驱动类名
    public static final String UTF_8 = "UTF-8";// 字符集 UTF-8
    public static final String GBK = "GBK";// 字符集 GBK
    public static final String ISO_8859_1 = "ISO_8859-1";// 字符集 ISO_8859-1

    public static final String NUMS = "0123456789";// 数字
    public static final String CHARS = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";// 特殊字符
    public static final String SEPARATOR = "`<${separator}>`";// 特殊分隔符
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
