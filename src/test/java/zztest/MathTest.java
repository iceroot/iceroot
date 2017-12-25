package zztest;

import static com.icexxx.util.IceTestUtil.*;

import org.junit.Test;

import com.icexxx.util.IceMathUtil;

public class MathTest {
    // @Test
    public void add() {
        print(IceMathUtil.add("12.3", "24.5"));
    }

    // @Test
    public void subtract() {
        print(IceMathUtil.subtract("12.3", "24.5"));
        print(IceMathUtil.subtract("112.3", "24.5"));
    }

    // @Test
    public void multiply() {
        print(IceMathUtil.multiply("12", "12"));
        print(IceMathUtil.multiply("112.3", "24.5"));
    }

    // @Test
    public void divide() {
        print(IceMathUtil.divide("1", "98"));
        print(IceMathUtil.divide("1", "98", 6));
        print(IceMathUtil.divide("1", "7", 10));
        print(IceMathUtil.divide("1", "7", 4));
    }

    // @Test
    public void negate() {
        print(IceMathUtil.negate("25"));
        print(IceMathUtil.negate("-25"));
    }
}
