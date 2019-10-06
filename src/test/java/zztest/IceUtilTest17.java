package zztest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest17 {
    // @Test
    public void test1() {
        List<Long> list = null;
        List<Long> addNegativeOne = IceUtil.addNegativeOne(list);
        System.out.println(addNegativeOne);
    }

    // @Test
    public void test2() {
        List<Long> list = new ArrayList<Long>();
        List<Long> addNegativeOne = IceUtil.addNegativeOne(list);
        System.out.println(addNegativeOne);
    }

    // @Test
    public void test3() {
        List<Long> list = new ArrayList<Long>();
        list.add(123L);
        List<Long> addNegativeOne = IceUtil.addNegativeOne(list);
        System.out.println(addNegativeOne);
    }

    // @Test
    public void test4() {
        List<Long> list = new ArrayList<Long>();
        list.add(123L);
        list.add(456L);
        List<Long> addNegativeOne = IceUtil.addNegativeOne(list);
        System.out.println(addNegativeOne);
    }
}
