package zztest;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.icexxx.util.IceNumUtil;

public class IceNumUtilTest3 {
    // @Test
    public void test1() {
        Integer num = null;
        Integer _null = null;
        assertEquals("错误", IceNumUtil.equals(123L, num), false);
        assertEquals("错误", IceNumUtil.equals(_null, num), true);
    }

    // @Test
    public void test2() {
        Long num = null;
        Integer _null = null;
        assertEquals("错误", IceNumUtil.equals(123L, num), false);
        assertEquals("错误", IceNumUtil.equals(_null, num), true);
    }

    // @Test
    public void test3() {
        BigDecimal num = null;
        Integer _null = null;
        assertEquals("错误", IceNumUtil.equals(123L, num), false);
        assertEquals("错误", IceNumUtil.equals(_null, num), true);
    }

    // @Test
    public void test4() {
        Byte num = null;
        Integer _null = null;
        assertEquals("错误", IceNumUtil.equals(123L, num), false);
        assertEquals("错误", IceNumUtil.equals(_null, num), true);
    }
}
