package zztest;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.icexxx.util.IceMathUtil;

public class IceMathUtilTest {
    // @Test
    public void test() {
        BigDecimal factorial = IceMathUtil.factorial(0);
        assertEquals("错误", factorial.toString(), "1");
        assertEquals("错误", IceMathUtil.factorial(0).toString(), "1");
        assertEquals("错误", IceMathUtil.factorial(1).toString(), "1");
        assertEquals("错误", IceMathUtil.factorial(2).toString(), "2");
        assertEquals("错误", IceMathUtil.factorial(3).toString(), "6");
        assertEquals("错误", IceMathUtil.factorial(4).toString(), "24");
        assertEquals("错误", IceMathUtil.factorial(5).toString(), "120");
        assertEquals("错误", IceMathUtil.factorial(6).toString(), "720");
    }
}
