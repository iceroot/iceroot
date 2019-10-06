package zztest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest7 {
    // @Test
    public void test() {
        assertEquals("错误", IceUtil.convertDesc(0), "0秒");
        assertEquals("错误", IceUtil.convertDesc(1), "1秒");
        assertEquals("错误", IceUtil.convertDesc(59), "59秒");
        assertEquals("错误", IceUtil.convertDesc(60), "1分");
        assertEquals("错误", IceUtil.convertDesc(61), "1分1秒");
        assertEquals("错误", IceUtil.convertDesc(120), "2分");
        assertEquals("错误", IceUtil.convertDesc(121), "2分1秒");
        assertEquals("错误", IceUtil.convertDesc(1201), "20分1秒");
        assertEquals("错误", IceUtil.convertDesc(1221), "20分21秒");
        assertEquals("错误", IceUtil.convertDesc(3600), "1时");
        assertEquals("错误", IceUtil.convertDesc(3601), "1时1秒");
        assertEquals("错误", IceUtil.convertDesc(86400), "1天");
        assertEquals("错误", IceUtil.convertDesc(86401), "1天1秒");
        assertEquals("错误", IceUtil.convertDesc(86461), "1天1分1秒");
        assertEquals("错误", IceUtil.convertDesc(90061), "1天1时1分1秒");
    }
}
