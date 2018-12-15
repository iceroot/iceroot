package com.icexxx.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 随机数相关工具类
 * 
 * @author IceWater
 * @version 2.0.2
 */
public class IceRandomUtil {
    /**
     * 随机生成手机号
     * 
     * @return 生成的手机号
     * @since 2.0.2
     */
    public static String randomPhone() {
        List<String> segmentList = segmentPhone();
        Random ran = new Random();
        int size = segmentList.size();
        String segmentStr = segmentList.get(ran.nextInt(size));
        StringBuilder sb = new StringBuilder(segmentStr);
        for (int i = 0; i < 8; i++) {
            sb.append(ran.nextInt(10));
        }
        return sb.toString();
    }

    private static List<String> segmentPhone() {
        List<String> segment = new ArrayList<String>();
        int[] numSecond = { 3, 4, 5, 7, 8 };
        for (int i = 0; i < numSecond.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("1");
            sb.append(numSecond[i]);
            for (int j = 0; j < 10; j++) {
                StringBuilder temp = new StringBuilder(sb.toString());
                temp.append(j);
                segment.add(temp.toString());
            }
        }
        segment.remove("154");
        segment.add("166");
        segment.add("198");
        segment.add("199");
        return segment;
    }

    /**
     * 随机生成身份证号
     * 
     * @return 生成的内容
     * @since 2.0.2
     */
    public static String randomIdentityCard() {
        String[] provinceCodeArray = { "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35",
                "36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64",
                "65", "71", "81", "82" };
        Random ran = new Random();
        int provinceIndex = ran.nextInt(provinceCodeArray.length);
        String province = provinceCodeArray[provinceIndex];
        int cityInt = ran.nextInt(70) + 1;
        String city = cityInt + "";
        if (city.length() == 1) {
            city = "0" + city;
        }
        String birthday = randomDate(0, 1000);
        StringBuilder sb = new StringBuilder();
        sb.append(province);
        sb.append(city);
        for (int i = 0; i < 2; i++) {
            sb.append(ran.nextInt(10));
        }
        sb.append(birthday);
        for (int i = 0; i < 3; i++) {
            sb.append(ran.nextInt(10));
        }
        String before = sb.toString();
        String lastStr = IceUtil.idCardlastValid(before);
        return before + lastStr;
    }

    private static String randomDate(int start, int end) {
        Random ran = new Random(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        int value = ran.nextInt(end - start) + start;
        cal.set(Calendar.DAY_OF_MONTH, value);
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = cal.getTime();
        return dateFormat.format(date);
    }
}
