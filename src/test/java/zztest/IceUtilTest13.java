package zztest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest13 {
    // @Test
    public void test1() {
        List<Integer> list = null;
        assertEquals("错误", IceUtil.sumInteger(list).intValue(), 0);
    }

    // @Test
    public void test2() {
        List<Integer> list = new ArrayList<Integer>();
        assertEquals("错误", IceUtil.sumInteger(list).intValue(), 0);
    }

    // @Test
    public void test3() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        assertEquals("错误", IceUtil.sumInteger(list).intValue(), 5);
    }

    // @Test
    public void test4() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(6);
        assertEquals("错误", IceUtil.sumInteger(list).intValue(), 11);
    }

    // @Test
    public void test5() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(6);
        list.add(8);
        assertEquals("错误", IceUtil.sumInteger(list).intValue(), 19);
    }
}
