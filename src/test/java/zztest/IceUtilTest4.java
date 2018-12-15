package zztest;

import static com.icexxx.util.IceTestUtil.*;
import static com.icexxx.util.IceUtil.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class IceUtilTest4 {
    // @Test
    public void notTest() {
        print(not(null, "yes", "no"));
        print(not("", "yes", "no"));
        print(not("yes", "yes", "no"));
        print(not("no", "yes", "no"));
    }

    // @Test
    public void negative2ZeroTest() {
        BigDecimal num1 = new BigDecimal("-1");
        print(negative2Zero(num1) + "");
        BigDecimal num2 = new BigDecimal("-1.2");
        print(negative2Zero(num2) + "");
        BigDecimal num3 = new BigDecimal("5");
        print(negative2Zero(num3) + "");
        BigDecimal num4 = new BigDecimal("1.3");
        print(negative2Zero(num4) + "");
        BigDecimal num5 = new BigDecimal("0");
        print(negative2Zero(num5) + "");
    }

    // @Test
    public void commaStr2ListTest() {
        print(commaStr2List(null) + "");
        print(commaStr2List("") + "");
        print(commaStr2List("123") + "");
        print(commaStr2List("123,456") + "");
        print(commaStr2List("123,,789") + "");
        print(commaStr2List("123 ,  ,  789  , 127") + "");
        print(commaStr2List("123 ,  ,  789  , 127").get(0) + 123);
    }

    // @Test
    public void addDefaultTest() {
        print(addDefault(null) + "");
        List<Integer> list = new ArrayList<Integer>();
        print(addDefault(list) + "");
        list.add(567);
        print(addDefault(list) + "");
        list.add(789);
        print(addDefault(list) + "");
    }

    // @Test
    public void trueFunctionTest() {
        System.out.println(trueFunction());
        System.out.println(falseFunction());
    }

    // @Test
    public void firstLetterTest() {
        print(firstLetter(null));
        print(firstLetter(""));
        print(firstLetter("abc"));
        print(firstLetter("abc_def_ghi"));
        print(firstLetter("abc_def__ghi"));
        print(firstLetter("_abc_d_ghi"));
    }

    // @Test
    public void createMapTest() {
        Map<String, String> map1 = createMap("name", "hello");
        System.out.println(map1);
        Map<String, String> map2 = createMap("name", "hello", "age", "23");
        System.out.println(map2);
    }

    // @Test
    public void isEmptyStrTest() {
        print(isEmptyStr(null));
        print(isEmptyStr(""));
        print(isEmptyStr(" "));
        print(isEmptyStr("abc"));
        print(isEmptyStr(new java.util.Date()));
    }

    // @Test
    public void toStringTest() {
        print(com.icexxx.util.IceUtil.toString(null));
        print(com.icexxx.util.IceUtil.toString(""));
        print(com.icexxx.util.IceUtil.toString(" "));
        print(com.icexxx.util.IceUtil.toString("abc"));
        print(com.icexxx.util.IceUtil.toString(new java.util.Date()));
        print("".equals(com.icexxx.util.IceUtil.toString(null)));
    }
}
