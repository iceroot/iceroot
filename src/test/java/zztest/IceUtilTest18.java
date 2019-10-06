package zztest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest18 {
    // @Test
    public void test1() {
        List<Integer> list = null;
        List<Integer> addNegativeOne = IceUtil.addNegativeOneInteger(list);
        System.out.println(addNegativeOne);
    }

    // @Test
    public void test2() {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> addNegativeOne = IceUtil.addNegativeOneInteger(list);
        System.out.println(addNegativeOne);
    }

    // @Test
    public void test3() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(123);
        List<Integer> addNegativeOne = IceUtil.addNegativeOneInteger(list);
        System.out.println(addNegativeOne);
    }

    // @Test
    public void test4() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(123);
        list.add(456);
        List<Integer> addNegativeOne = IceUtil.addNegativeOneInteger(list);
        System.out.println(addNegativeOne);
    }
}
