package zztest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest9 {
    // @Test
    public void test1() {
        for (int i = 1; i < 21; i++) {
            System.out.println(IceUtil.circleNum(i));
        }
    }

    // @Test
    public void test2() {
        System.out.println(IceUtil.circleNum(0));
    }

    // @Test
    public void tes3() {
        System.out.println(IceUtil.circleNum(21));
    }
}
