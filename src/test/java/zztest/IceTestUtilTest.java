package zztest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.icexxx.util.IceTestUtil;

public class IceTestUtilTest {
    // @Test
    public void test1() {
        List<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add(null);
        list.add("");
        list.add("ghi");
        list.add("jkl");
        IceTestUtil.debug(list);
    }

    // @Test
    public void test2() {
        List<String> list = new ArrayList<String>();
        IceTestUtil.debug(list);
    }

    // @Test
    public void test3() {
        List<String> list = null;
        IceTestUtil.debug(list);
    }
}
