package zztest;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class IceUtilTest24 {
//     @Test
    public void test1() {
        System.out.println(IceUtil.dateListFillZero(null));
        Map<String, Long> map = new HashMap<String, Long>();
        System.out.println(IceUtil.dateListFillZero(map));
        map.put("2016-02-27", 123L);
        System.out.println(IceUtil.dateListFillZero(map));
        map.put("2016-03-02", 125L);
        System.out.println(IceUtil.dateListFillZero(map));
        map.put("2016-03-07", 127L);
        System.out.println(IceUtil.dateListFillZero(map));
    }

//     @Test
     public void test2() {
         Map<String, Long> map = new HashMap<String, Long>();
         map.put("2016-03-07", 127L);
         map.put("2016-02-26", 126L);
         map.put("2016-02-27", 123L);
         map.put("2016-03-02", 117L);
         map.put("2016-03-09", 125L);
         System.out.println(IceUtil.dateListFillZero(map));
     }

}
