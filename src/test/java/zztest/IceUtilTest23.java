package zztest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest23 {
//     @Test
    public void test1() {
        System.out.println(IceUtil.array2List(null));
        List<String[]> list = new ArrayList<String[]>();
        System.out.println(IceUtil.array2List(null));
        list.add(new String[] {});
        System.out.println(IceUtil.array2List(list));
        list.add(new String[] {"aaa"});
        System.out.println(IceUtil.array2List(list));
        list.add(new String[] {"aaa", "bbb"});
        System.out.println(IceUtil.array2List(list));
    }

//    @Test
    public void test2() {
        System.out.println(IceUtil.list2array(null));
        List<List<String>> list = new ArrayList<List<String>>();
        System.out.println(IceUtil.list2array(list));
        list.add(list1());
        System.out.println(IceUtil.list2array(list));
        list.add(list2());
        System.out.println(IceUtil.list2array(list));
    }

//    @Test
    public void test3() {
        System.out.println(IceUtil.list2array(null));
        List<List<String>> list = new ArrayList<List<String>>();
        System.out.println(IceUtil.list2array(list));
        list.add(list1());
        System.out.println(Arrays.toString(IceUtil.list2array(list).get(0)));
        list.add(list2());
        System.out.println(Arrays.toString(IceUtil.list2array(list).get(1)));
    }

    private List<String> list1() {
        List<String> list = new ArrayList<String>();
        list.add("aaa1");
//        list.add(null);
        list.add("aaa2");
        list.add("aaa3");
        return list;
    }

    private List<String> list2() {
        List<String> list = new ArrayList<String>();
        list.add("bbb1");
        list.add("bbb2");
        list.add("bbb3");
        return list;
    }
}
