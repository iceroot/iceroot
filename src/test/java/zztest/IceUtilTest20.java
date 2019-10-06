package zztest;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest20 {
    // @Test
    public void test1() {
        Map<String, String> map = null;
        System.out.println(IceUtil.keys(map));
    }

    // @Test
    public void test2() {
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(IceUtil.keys(map));
    }

    // @Test
    public void test3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("abc", "ABC");
        System.out.println(IceUtil.keys(map));
    }

    // @Test
    public void test4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("abc", "ABC");
        map.put("def", "123");
        System.out.println(IceUtil.keys(map));
    }
}
