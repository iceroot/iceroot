package zztest;

import java.util.Map;

import org.junit.Test;

import com.icexxx.util.IceExpression;

public class IceExpressionTest {
    // @Test
    public void toMap1() {
        Map map = IceExpression.toMap("name", "abc");
        System.out.println(map);
    }

    // @Test
    public void toMap2() {
        Map map = IceExpression.toMap("abc.def", "book");
        System.out.println(map);
        System.out.println(map.get("abc"));
        Map map2 = (Map) map.get("abc");
        System.out.println(map2.get("def"));
    }

    // @Test
    public void toMap3() {
        Map map = IceExpression.toMap("abc.def.ghi", "book");
        System.out.println(map);
        System.out.println(map.get("abc"));
        Map map2 = (Map) map.get("abc");
        System.out.println(map2.get("def"));
        Map map3 = (Map) map2.get("def");
        System.out.println(map3.get("ghi"));
    }
}
