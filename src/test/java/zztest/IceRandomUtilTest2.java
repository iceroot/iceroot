package zztest;

import org.junit.Test;

import com.icexxx.util.IceRandomUtil;

public class IceRandomUtilTest2 {
    // @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            String randomDateTime = IceRandomUtil.randomDateTime(-500, 100);
            System.out.println(randomDateTime);
        }
    }
}
