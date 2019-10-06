package zztest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest5 {
    // @Test
    public void test1() {
        List<String> list1 = null;
        List<String> list2 = null;
        assertEquals("错误", IceUtil.equalsSize(list1, list2), true);
    }

    // @Test
    public void test2() {
        List<String> list1 = null;
        List<String> list2 = new ArrayList<String>();
        assertEquals("错误", IceUtil.equalsSize(list1, list2), true);
    }

    // @Test
    public void test3() {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = null;
        assertEquals("错误", IceUtil.equalsSize(list1, list2), true);
    }

    // @Test
    public void test4() {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        assertEquals("错误", IceUtil.equalsSize(list1, list2), true);
    }

    // @Test
    public void test5() {
        List<String> list1 = new ArrayList<String>();
        list1.add("abc");
        List<String> list2 = new ArrayList<String>();
        assertEquals("错误", IceUtil.equalsSize(list1, list2), false);
    }

    // @Test
    public void test6() {
        List<String> list1 = new ArrayList<String>();
        list1.add("abc");
        List<String> list2 = new ArrayList<String>();
        list2.add("def");
        assertEquals("错误", IceUtil.equalsSize(list1, list2), true);
    }
}
