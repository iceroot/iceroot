package zztest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest25 {
    // @Test
    public void test1() {
        Date date = parseDate("2017-01-02 15:23:47");
        Date startDate = parseDate("2017-01-01 15:23:47");
        Date endDate = parseDate("2017-01-03 15:23:47");
        System.out.println(IceUtil.betweenDate(date, startDate, endDate));
    }

    // @Test
    public void test2() {
        Date date = parseDate("2017-01-01 15:23:47");
        Date startDate = parseDate("2017-01-01 15:23:47");
        Date endDate = parseDate("2017-01-01 15:23:48");
        System.out.println(IceUtil.betweenDate(date, startDate, endDate));
    }

    // @Test
    public void test3() {
        Date date = parseDate("2017-01-01 15:23:47");
        Date startDate = null;
        Date endDate = parseDate("2017-01-01 15:23:48");
        System.out.println(IceUtil.betweenDate(date, startDate, endDate));
    }

    // @Test
    public void test4() {
        Date date = parseDate("2017-01-01 15:23:47");
        Date startDate = parseDate("2017-01-01 15:23:47");
        Date endDate = null;
        System.out.println(IceUtil.betweenDate(date, startDate, endDate));
    }

    // @Test
    public void test5() {
        Date date = parseDate("2017-01-01 15:23:47");
        Date startDate = parseDate("2017-01-01 15:23:46");
        Date endDate = null;
        System.out.println(IceUtil.betweenDate(date, startDate, endDate));
    }

    // @Test
    public void test6() {
        Date date = parseDate("2017-01-01 15:23:47");
        Date startDate = parseDate("2017-01-01 15:23:47");
        Date endDate = parseDate("2017-01-01 15:23:47");
        System.out.println(IceUtil.betweenDate(date, startDate, endDate));
    }

    // @Test
    public void test7() {
        Date date = parseDate("2018-01-01 15:23:47");
        Date startDate = parseDate("2017-01-01 15:23:47");
        Date endDate = parseDate("2017-01-02 15:23:47");
        System.out.println(IceUtil.betweenDate(date, startDate, endDate));
    }

    // @Test
    public void test8() {
        Date date = parseDate("2017-01-01 15:23:48");
        Date startDate = parseDate("2017-01-01 15:23:47");
        Date endDate = parseDate("2017-01-01 15:23:48");
        System.out.println(IceUtil.betweenDate(date, startDate, endDate));
    }

    // @Test
    public void test9() {
        Date date = parseDate("2016-12-31 00:00:00");
        Date startDate = parseDate("2017-01-01 00:00:00");
        Date endDate = parseDate("2017-01-03 00:00:00");
        System.out.println(IceUtil.betweenDate(date, startDate, endDate));
    }

    private Date parseDate(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
