package zztest;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.icexxx.util.IceNumUtil;

public class IceNumUtilTest {
    // @Test
    public void test1() {
        Integer num = new Integer("123");
        assertEquals("错误", IceNumUtil.equals(123, num), true);
        assertEquals("错误", IceNumUtil.equals(123, num) + "", "true");
        assertEquals("错误", IceNumUtil.equals(125, num), false);
        assertEquals("错误", IceNumUtil.equals(125, num) + "", "false");
    }

    // @Test
    public void test2() {
        Long num = new Long("123");
        assertEquals("错误", IceNumUtil.equals(123, num), true);
        assertEquals("错误", IceNumUtil.equals(123, num) + "", "true");
        assertEquals("错误", IceNumUtil.equals(125, num), false);
        assertEquals("错误", IceNumUtil.equals(125, num) + "", "false");
    }

    // @Test
    public void test3() {
        BigDecimal num = new BigDecimal("123");
        assertEquals("错误", IceNumUtil.equals(123, num), true);
        assertEquals("错误", IceNumUtil.equals(123, num) + "", "true");
        assertEquals("错误", IceNumUtil.equals(125, num), false);
        assertEquals("错误", IceNumUtil.equals(125, num) + "", "false");
    }

    // @Test
    public void test4() {
        Byte num = new Byte("123");
        assertEquals("错误", IceNumUtil.equals(123, num), true);
        assertEquals("错误", IceNumUtil.equals(123, num) + "", "true");
        assertEquals("错误", IceNumUtil.equals(125, num), false);
        assertEquals("错误", IceNumUtil.equals(125, num) + "", "false");
    }
}
