package zztest;

import org.junit.Test;

import com.icexxx.util.IceFileUtil;

public class IceFileUtilTest {
    // @Test
    public void test1() {
        String folder = "C:/Users/Administrator/Desktop/abc";
        boolean isFile = true;
        String newest = IceFileUtil.getNewest(folder, isFile);
        System.out.println(newest);
    }

    // @Test
    public void test2() {
        String folder = "C:/Users/Administrator/Desktop/def";
        boolean isFile = false;
        String newest = IceFileUtil.getNewest(folder, isFile);
        System.out.println(newest);
    }
}
