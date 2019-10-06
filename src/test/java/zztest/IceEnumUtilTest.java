package zztest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.icexxx.util.IceEnumUtil;

import zztest.pojo.StatusEnum;

public class IceEnumUtilTest {
    // @Test
    public void test() {
        assertEquals("错误", IceEnumUtil.equals(StatusEnum.START, 1), true);
        assertEquals("错误", IceEnumUtil.equals(StatusEnum.USE, 2), true);
        assertEquals("错误", IceEnumUtil.equals(StatusEnum.END, 3), true);
        assertEquals("错误", IceEnumUtil.equals(StatusEnum.START, 3), false);
        assertEquals("错误", IceEnumUtil.equals(StatusEnum.USE, 1), false);
        assertEquals("错误", IceEnumUtil.equals(StatusEnum.END, 2), false);
    }
}
