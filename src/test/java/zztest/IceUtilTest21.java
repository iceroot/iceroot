package zztest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest21 {
    // @Test
    public void test1() {
        String startDate = "2016-02-28";
        String endDate = "2016-03-02";
        System.out.println(IceUtil.continuityDate(startDate, endDate));
    }

    // @Test
    public void test2() {
        String startDate = "2016-02-28";
        String endDate = "2016-02-28";
        System.out.println(IceUtil.continuityDate(startDate, endDate));
    }

    // @Test
    public void test3() {
        String startDate = "2016-12-30";
        String endDate = "2017-01-02";
        System.out.println(IceUtil.continuityDate(startDate, endDate));
    }

    // @Test
    public void test4() {
        String startDate = "2017-01-02";
        String endDate = "2016-12-30";
        System.out.println(IceUtil.continuityDate(startDate, endDate));
    }
}
