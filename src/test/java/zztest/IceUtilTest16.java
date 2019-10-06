package zztest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest16 {
    // @Test
    public void test1() {
        List<String> list = null;
        assertEquals("错误", IceUtil.lastIndexOf(list, "aaa", 5), -1);
    }

    // @Test
    public void test2() {
        List<String> list = new ArrayList<String>();
        assertEquals("错误", IceUtil.lastIndexOf(list, "aaa", 5), -1);
    }

    // @Test
    public void test3() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        assertEquals("错误", IceUtil.lastIndexOf(list, "aaa", 5), -1);
    }

    // @Test
    public void test4() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        assertEquals("错误", IceUtil.lastIndexOf(list, "aaa", 0), 0);
    }

    // @Test
    public void test5() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        assertEquals("错误", IceUtil.lastIndexOf(list, "aaa", 1), 0);
    }

    // @Test
    public void test6() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        assertEquals("错误", IceUtil.lastIndexOf(list, "bbb", 1), 1);
    }

    // @Test
    public void test7() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("bbb");
        list.add("eee");
        assertEquals("错误", IceUtil.lastIndexOf(list, "bbb", 1), 1);
    }

    // @Test
    public void test8() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("bbb");
        list.add("eee");
        list.add("fff");
        assertEquals("错误", IceUtil.lastIndexOf(list, "bbb", 4), 4);
    }

    // @Test
    public void test9() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("bbb");
        list.add("eee");
        list.add("fff");
        assertEquals("错误", IceUtil.lastIndexOf(list, "bbb", 5), 4);
    }

    // @Test
    public void test10() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("bbb");
        list.add("eee");
        list.add("fff");
        assertEquals("错误", IceUtil.lastIndexOf(list, "bbb", 3), 1);
    }
}
