package zztest;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.icexxx.util.IceDate;

public class IceDateTest2 {
    // @Test
    public void test1() {
        Date date = new IceDate("2016-02-29 12:36:57");
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        assertEquals("错误", sdf.format(date), "2016-02-29 12:36:57");
        assertEquals("错误", date.toString(), "2016-02-29 12:36:57");
    }

    // @Test
    public void test2() {
        Date date = new IceDate("2016-02-29");
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals("错误", sdf.format(date), "2016-02-29");
        assertEquals("错误", date.toString(), "2016-02-29 00:00:00");
    }
}
