package zztest;

import com.icexxx.util.IceUtil;

import static org.junit.Assert.*;

import org.junit.Test;

//import junit.framework.Assert;

public class IceDateTest {

    // @Test
    public void standard() {
        // IceUtil.dateStandard("2017")
        assertEquals("错误", "abc", "abc");
        assertEquals("错误", IceUtil.dateStandard("2017-1-1"), "2017-01-01");
        assertEquals("错误", IceUtil.dateStandard("2017-12-15"), "2017-12-15");
        assertEquals("错误", IceUtil.dateStandard("2017-12-3"), "2017-12-03");
        assertEquals("错误", IceUtil.dateStandard("2017-7-15"), "2017-07-15");
        assertEquals("错误", IceUtil.dateStandard("2017.7.10"), "2017-07-10");
        assertEquals("错误", IceUtil.dateStandard("2015/6/26"), "2015-06-26");
        assertEquals("错误", IceUtil.dateStandard("2014_3_6"), "2014-03-06");
        assertEquals("错误", IceUtil.dateStandard("2017年12月3日"), "2017-12-03");
        assertEquals("错误", IceUtil.dateStandard("5月7日2016年"), "2016-05-07");
        assertEquals("错误", IceUtil.dateStandard("8日10月2016年"), "2016-10-08");
        assertEquals("错误", IceUtil.dateStandard("2017年6月14"), "2017-06-14");
        assertEquals("错误", IceUtil.dateStandard("2013年11月28天"), "2013-11-28");
        assertEquals("错误", IceUtil.dateStandard("1.3.2005"), "2005-03-01");
        assertEquals("错误", IceUtil.dateStandard("15-3-2001"), "2001-03-15");
        assertEquals("错误", IceUtil.dateStandard("12-10-2002"), "2002-10-12");
        assertEquals("错误", IceUtil.dateStandard("202-5-9"), "0202-05-09");
        assertEquals("错误", IceUtil.dateStandard("1234-12-5"), "1234-12-05");
        assertEquals("错误", IceUtil.dateStandard("20150203"), "2015-02-03");
        assertEquals("错误", IceUtil.dateStandard("20160216"), "2016-02-16");
        assertEquals("错误", IceUtil.dateStandard("2016-02-16 13"), "2016-02-16");
        assertEquals("错误", IceUtil.dateStandard("2016-03-16 13:57"), "2016-03-16");
        assertEquals("错误", IceUtil.dateStandard("2016-04-16 13:57:26"), "2016-04-16");
        System.out.println(IceUtil.dateStandard(null));
        System.out.println(IceUtil.dateStandard(""));
    }

}
