package zztest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest14 {
    // @Test
    public void test1() {
        List<Long> list = null;
        assertEquals("错误", IceUtil.sum(list).intValue(), 0);
    }

    // @Test
    public void test2() {
        List<Long> list = new ArrayList<Long>();
        assertEquals("错误", IceUtil.sum(list).intValue(), 0);
    }

    // @Test
    public void test3() {
        List<Long> list = new ArrayList<Long>();
        list.add(5L);
        assertEquals("错误", IceUtil.sum(list).intValue(), 5);
    }

    // @Test
    public void test4() {
        List<Long> list = new ArrayList<Long>();
        list.add(5L);
        list.add(6L);
        assertEquals("错误", IceUtil.sum(list).intValue(), 11);
    }

    // @Test
    public void test5() {
        List<Long> list = new ArrayList<Long>();
        list.add(5L);
        list.add(6L);
        list.add(8L);
        assertEquals("错误", IceUtil.sum(list).intValue(), 19);
    }
}
