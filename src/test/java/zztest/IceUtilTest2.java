package zztest;

import static com.icexxx.util.IceTestUtil.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest2 {

    // @Test
    public void isJson() {
        print(IceUtil.isJson(null));
        print(IceUtil.isJson(""));
        print(IceUtil.isJson("[]"));
        print(IceUtil.isJson("{}"));
        print("===========");
        print(IceUtil.isJson("[abc]"));
        print(IceUtil.isJson("{def}"));
        print(IceUtil.isJson("[]zzz"));
        print(IceUtil.isJson("{}rrr"));
        print(IceUtil.isJson("yyy"));
    }

    // @Test
    public void replaceSlash() {
        print(IceUtil.replaceSlash(null));
        print(IceUtil.replaceSlash(""));
        print(IceUtil.replaceSlash("C:\\Users\\Administrator\\Desktop"));
        print(IceUtil.replaceSlash("/home/root/Desktop"));
    }

    // @Test
    public void like() {
        print(IceUtil.like(null));
        print(IceUtil.like(""));
        print(IceUtil.like("abc"));
        print(IceUtil.like("%ff%"));
    }

    // @Test
    public void desktopOriginal() {
        print(IceUtil.desktopOriginal());
        print(IceUtil.desktop());
    }

    // @Test
    public void toStringConsiderNull() {
        print(IceUtil.toStringConsiderNull(null));
        print(IceUtil.toStringConsiderNull(12));
    }

    // @Test
    public void removeFEFF() {
        print(IceUtil.removeFEFF("a\ufeffb"));
        print(IceUtil.removeFEFF("a\ufeffb").length());
        print("a﻿b".length());
        print("a\ufeffb");
    }

    // @Test
    public void defaultDivisionZero() {
        Double num1 = 100d;
        Double num2 = 10d;
        String defaultValue = "169";
        print(IceUtil.defaultDivisionZero(num1, num2, defaultValue));
        print(IceUtil.defaultDivisionZero(num1, 0d, defaultValue));
        print(IceUtil.defaultDivisionZero(num1, 0.0, defaultValue));
        print(IceUtil.defaultDivisionZero(num1, 0.00, defaultValue));
        print(IceUtil.defaultDivisionZero(num1, 0.000, defaultValue));
        print(IceUtil.defaultDivisionZero(num1, 0.0001, defaultValue));
    }

    // @Test
    public void removeFirst() {
        List<String> list = new ArrayList<String>();
        print(IceUtil.removeFirst(null) + "");
        print(IceUtil.removeFirst(list) + "");
        list.add("aaa");
        print(IceUtil.removeFirst(list) + "");
        list.add("bbb");
        print(IceUtil.removeFirst(list) + "");
        list.add("ccc");
        print(IceUtil.removeFirst(list) + "");
    }

    // @Test
    public void removeLast() {
        List<String> list = new ArrayList<String>();
        print(IceUtil.removeLast(null) + "");
        print(IceUtil.removeLast(list) + "");
        list.add("aaa");
        print(IceUtil.removeLast(list) + "");
        list.add("bbb");
        print(IceUtil.removeLast(list) + "");
        list.add("ccc");
        print(IceUtil.removeLast(list) + "");
    }

    // @Test
    public void newListIfNull() {
        List<String> list = new ArrayList<String>();
        print(IceUtil.newListIfNull(null) + "");
        print(IceUtil.newListIfNull(list) + "");
        list.add("aaa");
        print(IceUtil.newListIfNull(list) + "");
        list.add("bbb");
        print(IceUtil.newListIfNull(list) + "");
        list.add("ccc");
        print(IceUtil.newListIfNull(list) + "");
    }

    // @Test
    public void removeGeneric() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        print(IceUtil.removeGeneric(null) + "");
        print(IceUtil.removeGeneric(list) + "");
        Map<String, String> map = new HashMap<String, String>();
        map.put("aaa", "bbb");
        list.add(map);
        print(IceUtil.removeGeneric(list) + "");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("aaa", "bbb");
        map2.put("ccc", "ddd");
        list.add(map2);
        print(IceUtil.removeGeneric(list) + "");
        Map<String, String> map3 = new HashMap<String, String>();
        list.add(map3);
        print(IceUtil.removeGeneric(list) + "");
        List<Map<String, Object>> removeGeneric = IceUtil.removeGeneric(list);
        print(removeGeneric + "");
    }

    // @Test
    public void removeFirstAndLast() {
        print(IceUtil.removeFirstAndLast(null, "", ""));
        print(IceUtil.removeFirstAndLast("", "", ""));
        print(IceUtil.removeFirstAndLast("abcdefg", "ab", "fg"));
        print(IceUtil.removeFirstAndLast("abcde", "abcdef", "fg"));
        print(IceUtil.removeFirstAndLast("abcde", "ab", "fg"));
        print(IceUtil.removeFirstAndLast("<AAA>", "<", ">"));
        print(IceUtil.removeFirstAndLast("<span>test</span>", "<span>", "</span>"));
    }

    // @Test
    public void percentage() {
        print(IceUtil.percentage(12d, 2));
        print(IceUtil.percentage(12.0, 2));
        print(IceUtil.percentage(12.1, 2));
        print(IceUtil.percentage(12.12, 2));
        print(IceUtil.percentage(12.123, 2));
        print(IceUtil.percentage(12.125, 2));
        System.out.println("--------------");
        print(IceUtil.percentage(12.234, 2));
        print(IceUtil.percentage(12.235, 2));
        print(IceUtil.percentage(12.3451, 2));
        print(IceUtil.percentage(12.3455, 2));
        print(IceUtil.percentage(12.56783, 2));
        print(IceUtil.percentage(12.56785, 2));
        print(IceUtil.percentage(12.5678501, 2));
        print(IceUtil.percentage(12.56786, 2));
        print(IceUtil.percentage(12.56789, 2));
    }

    // @Test
    public void distinct() {
        String[] arrays = null;
        print(IceUtil.distinct(arrays));
        print(IceUtil.distinct(new String[] {}));
        print(IceUtil.distinct(new String[] { "aaa" }));
        print(IceUtil.distinct(new String[] { "aaa", "bbb" }));
        print(IceUtil.distinct(new String[] { "ccc", "ccc" }));
        print(IceUtil.distinct(new String[] { "aaa", "bbb", "aaa" }));
        print(IceUtil.distinct(new String[] { "aaa", "bbb", "ccc", "ddd", "bbb", "ddd" }));
    }

    // @Test
    public void distinct2() {
        String[] arrays = null;
        print(IceUtil.distinct(arrays));
        print(IceUtil.distinct(new Integer[] {}));
        print(IceUtil.distinct(new Integer[] { 11 }));
        print(IceUtil.distinct(new Integer[] { 11, 11 }));
        print(IceUtil.distinct(new Integer[] { 11, 12 }));
        print(IceUtil.distinct(new Integer[] { 11, 12, 11 }));
        print(IceUtil.distinct(new Integer[] { 11, 12, 13, 14, 15, 11, 13 }));
    }

    // @Test
    public void createList() {
        print(IceUtil.createList(null) + "");
        List<String> list = new ArrayList<String>();
        print(IceUtil.createList(list) + "");
        list.add("aaa");
        print(IceUtil.createList(list) + "");
        list.add("bbb");
        print(IceUtil.createList(list) + "");
        list.add("ccc");
        print(IceUtil.createList(list) + "");
        List<String> list4 = IceUtil.createList(list);
        list.add("ddd");
        print(list + "");
        print(list4 + "");
    }

    // @Test
    public void createMap() {
        print(IceUtil.createMap(null) + "");
        Map<String, String> map = new HashMap<String, String>();
        print(IceUtil.createMap(map) + "");
        map.put("aaa", "bbb");
        print(IceUtil.createMap(map) + "");
        map.put("ccc", "ddd");
        print(IceUtil.createMap(map) + "");
        Map<String, String> map2 = IceUtil.createMap(map);
        map.put("eee", "fff");
        print(map2 + "");
        print(map + "");
    }

    // @Test
    public void isEmpty() {
        print(IceUtil.isEmpty(null));
        print(IceUtil.isEmpty(""));
        print(IceUtil.isEmpty(" "));
        print(IceUtil.isEmpty("a"));
        System.out.println("------------");
        Object obj = "";
        print(IceUtil.isEmpty(obj));
        Object date = new Date();
        print(IceUtil.isEmpty(date));
    }

    // @Test
    public void noon() {
        System.out.println(IceUtil.noon(null));
        print(IceUtil.noon(new Date()));
    }

    // @Test
    public void toList() {
        print(IceUtil.toList(null) + "");
        String[] array1 = new String[] {};
        print(IceUtil.toList(array1) + "");
        print(IceUtil.toList(new String[] { "aaa" }) + "");
        print(IceUtil.toList(new String[] { "aaa", "bbb" }) + "");
        List<String> list = IceUtil.toList(new String[] { "aaa", "bbb", "ccc" });
        print(list + "");
    }

    // @Test
    public void toArray() {
        String[] array = null;
        array = IceUtil.toArray(null);
        print(array);
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        array = IceUtil.toArray(list);
        print(array);
        list.add("bbb");
        array = IceUtil.toArray(list);
        print(array);
        list.add("ccc");
        array = IceUtil.toArray(list);
        print(array);
        list.add("ddd");
        array = IceUtil.toArray(list);
        print(array);
    }

    // @Test
    public void forMap() {
        System.out.println(IceUtil.forMap(null));
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(IceUtil.forMap(map));
        map.put("aaa", "bbb");
        System.out.println(IceUtil.forMap(map));
        map.put("ccc", "ddd");
        System.out.println(IceUtil.forMap(map));
        List<Entry<String, String>> list = IceUtil.forMap(map);
        for (int i = 0; i < list.size(); i++) {
            Entry<String, String> entry = list.get(i);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    // @Test
    public void weekName() {
        print(IceUtil.weekName(0));
        print(IceUtil.weekName(1));
        print(IceUtil.weekName(2));
        print(IceUtil.weekName(3));
        print(IceUtil.weekName(4));
        print(IceUtil.weekName(5));
        print(IceUtil.weekName(6));
        print(IceUtil.weekName(7));
        // print(IceUtil.weekName(8));
        // print(IceUtil.weekName(-1));
    }

    // @Test
    public void subArray() {
        // print(Arrays.toString(IceUtil.subArray(null, -1)));
        print(Arrays.toString(IceUtil.subArray(null, 0)));
        print(Arrays.toString(IceUtil.subArray(null, 1)));
        print(Arrays.toString(IceUtil.subArray(null, 2)));
        print(Arrays.toString(IceUtil.subArray(new String[] {}, 3)));
        System.out.println("--------------");
        print(Arrays.toString(IceUtil.subArray(new String[] { "aaaa" }, 3)));
        print(Arrays.toString(IceUtil.subArray(new String[] { "aaa", "bbb" }, 3)));
        print(Arrays.toString(IceUtil.subArray(new String[] { "aaa", "bbb", "ccc" }, 3)));
        print(Arrays.toString(IceUtil.subArray(new String[] { "aaa", "bbb", "ccc", "ddd", "eee" }, 3)));
        print(Arrays.toString(IceUtil.subArray(new String[] { "aaa", "bbb", "ccc", "ddd", "eee", "fff" }, 3)));
    }

    // @Test
    // public void cap(){
    // print(IceUtil.cap(null));
    // print(IceUtil.cap(""));
    // print(IceUtil.cap("abcd"));
    // print(IceUtil.cap("abcdEfgHijkl"));
    // print(IceUtil.uncap(null));
    // print(IceUtil.uncap(""));
    // print(IceUtil.uncap("abcd"));
    // print(IceUtil.uncap("abcdEfgHijkl"));
    // }
    // @Test
    public void replaceCap() {
        print(IceUtil.replaceCap("footballabc", "ball", "book"));
        print(IceUtil.replaceCap("footballabcFootBalldef", "ball", "book"));
        print(IceUtil.replaceCap(null, "ball", "book"));
        print(IceUtil.replaceCap("", "ball", "book"));
        print(IceUtil.replaceCap("abc", null, "book"));
    }

    // @Test
    public void sqlHtml() {
        print(IceUtil.sqlHtml(null));
        print(IceUtil.sqlHtml(""));
        print(IceUtil.sqlHtml("a>12 && b<13"));
    }

    // @Test
    public void sqlChar() {
        print(IceUtil.sqlChar(null));
        print(IceUtil.sqlChar(""));
        print(IceUtil.sqlChar("a&gt;12 && b&lt;13"));
    }

    // @Test
    public void diffMonth() {
        print(IceUtil.diffMonth("2017-12-01", "2017-12-31"));
        print(IceUtil.diffMonth("2016-12-01", "2017-12-31"));
        print(IceUtil.diffMonth("2016-12-01", "2017-1-31"));
        print(IceUtil.diffMonth("2016-12-01", "2017-2"));
        print(IceUtil.diffMonth("2016-5-01", "2016-8"));
        print(IceUtil.diffMonth("2016-12", "2017-01-31"));
        print(IceUtil.diffMonth("2017-12", "2017-11-31"));
    }

    // @Test
    public void removeDoubleFirst() {
        print(IceUtil.removeDoubleFirst(null, "", ""));
        print(IceUtil.removeDoubleFirst("", "", ""));
        print(IceUtil.removeDoubleFirst("abc", null, ""));
        print(IceUtil.removeDoubleFirst("abc", "", ""));
        print(IceUtil.removeDoubleFirst("abc", "", null));
        print(IceUtil.removeDoubleFirst("abc", "", ""));
        print(IceUtil.removeDoubleFirst("  abc   ", "", "") + "<");
        System.out.println("------------------");
        print(IceUtil.removeDoubleFirst("  abc  def ghi ", "abc", "def") + "<");
        print(IceUtil.removeDoubleFirst("  abc  def ghi ", "def", "abc") + "<");
    }

    // @Test
    public void removeDoubleLast() {
        print(IceUtil.removeDoubleLast(null, "", ""));
        print(IceUtil.removeDoubleLast("", "", ""));
        print(IceUtil.removeDoubleLast("abc", null, ""));
        print(IceUtil.removeDoubleLast("abc", "", ""));
        print(IceUtil.removeDoubleLast("abc", "", null));
        print(IceUtil.removeDoubleLast("abc", "", ""));
        print(IceUtil.removeDoubleLast("  abc   ", "", "") + "<");
        System.out.println("------------------");
        print(IceUtil.removeDoubleLast("  abc  def ghi ", "def", "ghi") + "<");
        print(IceUtil.removeDoubleLast("  abc  def ghi ", "ghi", "def") + "<");
    }

    // @Test
    public void contain() {
        print(IceUtil.contain(null, null));
        print(IceUtil.contain(null, ""));
        print(IceUtil.contain(null, "abc"));
        print(IceUtil.contain(new String[] {}, null));
        print(IceUtil.contain(new String[] {}, ""));
        print(IceUtil.contain(new String[] {}, "abc"));
        System.out.println("--------------");
        print(IceUtil.contain(new String[] { "abc" }, null));
        print(IceUtil.contain(new String[] { "abc" }, ""));
        print(IceUtil.contain(new String[] { "", "def" }, ""));
        print(IceUtil.contain(new String[] { "abc" }, "abc"));
        print(IceUtil.contain(new String[] { "   abc   " }, "ABC"));
        print(IceUtil.contain(new String[] { "   ABC   ", "def", "ghi" }, "abc"));
        print(IceUtil.contain(new String[] { "   ABC   ", null, "ghi" }, null));
    }

    // @Test
    public void replaceQuotationOut() {
        print(IceUtil.replaceQuotationOut(null, "def", "DEF"));
        print(IceUtil.replaceQuotationOut("", "def", "DEF"));
        print(IceUtil.replaceQuotationOut("aaa", null, "DEF"));
        print(IceUtil.replaceQuotationOut("bbb", "b", "DEF"));
        print(IceUtil.replaceQuotationOut("ccc", "c", null));
        print(IceUtil.replaceQuotationOut("abcdefghdefijklmn", "def", ""));
        System.out.println("---------");
        print(IceUtil.replaceQuotationOut("abcdefghijkldefmnop", "def", "DEF"));
        print(IceUtil.replaceQuotationOut("abcdef\"ghdefi\"jkldefmn", "def", "DEF"));
        print(IceUtil.replaceQuotationOut("abcdef\'ghdefi\'jkldefmn", "def", "DEF"));
        print(IceUtil.replaceQuotationOut("abcdef\'gh\"xyzdefiu\"vw\'jkldefmn", "def", "DEF"));
        print(IceUtil.replaceQuotationOut("abcdef\"gh\'xyzdefiu\'vw\"jkldefmn", "def", "DEF"));
        System.out.println("---------");
        print(IceUtil.replaceQuotationOut("abcdefghijkldefmnopabcdefghijkldefmnop", "def", "DEF"));
        print(IceUtil.replaceQuotationOut("abcdef\"ghdefi\"jkldefmnabcdef\"ghdefi\"jkldefmn", "def", "DEF"));
        print(IceUtil.replaceQuotationOut("abcdef\'ghdefi\'jkldefmnabcdef\'ghdefi\'jkldefmn", "def", "DEF"));
        print(IceUtil.replaceQuotationOut("abcdef\'gh\"xyzdefiu\"vw\'jkldefmnabcdef\'gh\"xyzdefiu\"vw\'jkldefmn", "def",
                "DEF"));
        print(IceUtil.replaceQuotationOut("abcdef\"gh\'xyzdefiu\'vw\"jkldefmnabcdef\"gh\'xyzdefiu\'vw\"jkldefmn", "def",
                "DEF"));
    }

    // @Test
    public void arrayColumn() {
        // print(IceUtil.arrayColumn(new String[][]{},-1));
        print(IceUtil.arrayColumn(null, 0));
        print(IceUtil.arrayColumn(new String[][] {}, 0));
        print(IceUtil.arrayColumn(new String[][] { {} }, 0));
        print(IceUtil.arrayColumn(new String[][] { { "aaa" } }, 0));
        print(IceUtil.arrayColumn(
                new String[][] { { "aaa", "bbb", "ccc" }, { "ddd", "eee", "fff" }, { "ggg", "hhh", "iii" } }, 0));
        print(IceUtil.arrayColumn(
                new String[][] { { "aaa", "bbb", "ccc" }, { "ddd", "eee", "fff" }, { "ggg", "hhh", "iii" } }, 1));
        print(IceUtil.arrayColumn(
                new String[][] { { "aaa", "bbb", "ccc" }, { "ddd", "eee", "fff", "yyy" }, { "ggg", "hhh", "iii" } },
                3));

    }

    // @Test
    public void array2simple() {
        print(Arrays.toString(IceUtil.array2simple(null)));
        print(Arrays.toString(IceUtil.array2simple("abc")));
        print(Arrays.toString(IceUtil.array2simple(15)));
        print(Arrays.toString(IceUtil.array2simple(new Date())));
    }

    // @Test
    public void simple2List() {
        print(IceUtil.simple2List(null) + "");
        print(IceUtil.simple2List("abc") + "");
        print(IceUtil.simple2List(15) + "");
        print(IceUtil.simple2List(new Date()) + "");
        List<Date> list = IceUtil.simple2List(new Date());
        list.add(new Date());
        print(list + "");
    }

    // @Test
    public void simple2Map() {
        print(IceUtil.simple2Map(null, "abc") + "");
        print(IceUtil.simple2Map("def", null) + "");
        print(IceUtil.simple2Map("efg", "jkl") + "");
    }

    // @Test
    public void isHttp() {
        print(IceUtil.isHttp(null));
        print(IceUtil.isHttp(""));
        print(IceUtil.isHttp("http://"));
        print(IceUtil.isHttp("https://"));
        print(IceUtil.isHttp("http://www.test.com"));
        print(IceUtil.isHttp("https://www.test.com"));
        print(IceUtil.isHttp("www.test.com"));
    }

    // @Test
    public void versionCompare() {
        // print(IceUtil.versionCompare(null, null));
        // print(IceUtil.versionCompare("", ""));
        // print(IceUtil.versionCompare("1", ""));
        print(IceUtil.versionCompare("1", "2"));
        print(IceUtil.versionCompare("2", "1"));
        print(IceUtil.versionCompare("3", "3"));
        print(IceUtil.versionCompare("1.1", "1.2"));
        print(IceUtil.versionCompare("1.2", "1.1"));
        print(IceUtil.versionCompare("3.0.0", "3.0.0"));
        System.out.println("-----------");
        print(IceUtil.versionCompare("1.3.7", "1.3.17"));
        print(IceUtil.versionCompare("1.3.6", "1.3.7"));
        print(IceUtil.versionCompare("1.3.6.1", "1.3.7"));
        print(IceUtil.versionCompare("3.0.0", "3.0.0.0"));
        print(IceUtil.versionCompare("3.0.0", "V3.0.0.0"));
    }
}
