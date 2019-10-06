package zztest;

import org.junit.Test;

import com.icexxx.util.IceException;

public class IceExceptionUtil {
    // @Test
    public void test() {
        try {
            throw new IceException(1001, "参数为空");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("--------------------");
            System.out.println(e);
        }
    }
}
