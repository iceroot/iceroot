package zztest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest22 {
//     @Test
    public void test1() {
        System.out.println(IceUtil.second2date(1571472996));
        System.out.println(IceUtil.date2second(new Date()));
    }

//    @Test
    public void test2() {
        System.out.println(IceUtil.temperature4c2f(0));
        System.out.println(IceUtil.temperature4f2c(0));
        System.out.println(IceUtil.temperature4c2f(1));
        System.out.println(IceUtil.temperature4f2c(1));
        System.out.println(IceUtil.temperature4c2f(-40));
        System.out.println(IceUtil.temperature4f2c(-40));
    }
}
