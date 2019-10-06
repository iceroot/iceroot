package zztest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest8 {
    // @Test
    public void test1() {
        assertEquals("错误", IceUtil.isDate("2018-02-29"), true);
        assertEquals("错误", IceUtil.isDate("2018-02-29 12:27:36"), true);
        assertEquals("错误", IceUtil.isDate("20180229"), false);
    }

    // @Test
    public void test2() {
        assertEquals("错误", IceUtil.isDate("2018-02-29"), true);
        assertEquals("错误", IceUtil.isDate("2018-02-29 12:27:36"), true);
        assertEquals("错误", IceUtil.isDate("20180229"), false);
    }

    // @Test
    public void tes3() {
        double double1 = 1.23;
        double double2 = 1.23;
        assertEquals("错误", IceUtil.equalsDouble(double1, double2), true);
    }

    // @Test
    public void tes4() {
        double double1 = 1.23;
        double double2 = 1.25;
        assertEquals("错误", IceUtil.equalsDouble(double1, double2), false);
    }

    // @Test
    public void tes5() {
        double double1 = 1.00;
        double double2 = 1.0;
        assertEquals("错误", IceUtil.equalsDouble(double1, double2), true);
    }

    // @Test
    public void test6() {
        assertEquals("错误", IceUtil.bearing("east"), "东");
        assertEquals("错误", IceUtil.bearing("west"), "西");
        assertEquals("错误", IceUtil.bearing("south"), "南");
        assertEquals("错误", IceUtil.bearing("north"), "北");
        assertEquals("错误", IceUtil.bearing("center"), "中");
    }

    // @Test
    public void test7() {
        assertEquals("错误", IceUtil.fillZero(0, 1), "0");
        assertEquals("错误", IceUtil.fillZero(1, 1), "1");
        assertEquals("错误", IceUtil.fillZero(123, 5), "00123");
        assertEquals("错误", IceUtil.fillZero(456, 6), "000456");
        assertEquals("错误", IceUtil.fillZero(456, 2), "456");
        assertEquals("错误", IceUtil.fillZero(-456, 6), "-000456");
    }

    // @Test
    public void test8() {
        assertEquals("错误", IceUtil.addByLength("abcdefghijklmn", 1, "|"), "a|b|c|d|e|f|g|h|i|j|k|l|m|n");
        assertEquals("错误", IceUtil.addByLength("abcdefghijklmn", 2, "|"), "ab|cd|ef|gh|ij|kl|mn");
        assertEquals("错误", IceUtil.addByLength("abcdefghijklmn", 3, "|"), "abc|def|ghi|jkl|mn");
        assertEquals("错误", IceUtil.addByLength("abcdefghijklmn", 4, "|"), "abcd|efgh|ijkl|mn");
        assertEquals("错误", IceUtil.addByLength("abcdefghijklmn", 5, "|"), "abcde|fghij|klmn");
    }

}
