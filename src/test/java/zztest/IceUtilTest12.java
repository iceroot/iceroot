package zztest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest12 {
    // @Test
    public void test1() {
        assertEquals("错误", IceUtil.jdbc2javaType("varchar2"), "String");
        assertEquals("错误", IceUtil.jdbc2javaType("int"), "int");
        assertEquals("错误", IceUtil.jdbc2javaType("datetime"), "Date");
        // assertEquals("错误", IceUtil.jdbc2javaType("zzz"), "Date");
    }

    // @Test
    public void test2() {
        assertEquals("错误", IceUtil.isPic("bmp"), true);
        assertEquals("错误", IceUtil.isPic("png"), true);
        assertEquals("错误", IceUtil.isPic("txt"), false);
    }

    // @Test
    public void test3() {
        assertEquals("错误", IceUtil.isPic("bmp"), true);
        assertEquals("错误", IceUtil.isPic("png"), true);
        assertEquals("错误", IceUtil.isPic("txt"), false);
    }
}
