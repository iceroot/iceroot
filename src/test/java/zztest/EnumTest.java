package zztest;

import static com.icexxx.util.IceTestUtil.print;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class EnumTest {
    // @Test
    public void convert2Int() {
        print(IceUtil.equalsEnum(Type.CLICK, "CLICK"));
        print(IceUtil.equalsEnum(Type.CLICK, "Click"));
        print(IceUtil.equalsEnum(Type.CLICK, "Click", true));
        print(IceUtil.equalsEnum(Type.CLICK, "Click", false));
        print("-------------");
        String nul = null;
        Type nulType = null;
        print(IceUtil.equalsEnum(nulType, nul));
        print(IceUtil.equalsEnum(null, "Click"));
        print(IceUtil.equalsEnum(Type.CLICK, nul));
        print(IceUtil.equalsEnum(Type.CLICK, Type.CLICK));
    }
}
