package zztest;

import static com.icexxx.util.IceSwitchUtil.*;

import org.junit.Test;

import junit.framework.TestCase;

public class IceSwitchUtilTest {
    // @Test
    public void constellationTest() {
        TestCase.assertEquals(constellation("0101"), "摩羯座");
        TestCase.assertEquals(constellation("0119"), "摩羯座");
        TestCase.assertEquals(constellation("0120"), "水瓶座");
        TestCase.assertEquals(constellation("0218"), "水瓶座");
        TestCase.assertEquals(constellation("0219"), "双鱼座");
        TestCase.assertEquals(constellation("0320"), "双鱼座");
        TestCase.assertEquals(constellation("0321"), "白羊座");
        TestCase.assertEquals(constellation("0420"), "白羊座");
        TestCase.assertEquals(constellation("0421"), "金牛座");
        TestCase.assertEquals(constellation("0520"), "金牛座");
        TestCase.assertEquals(constellation("0521"), "双子座");
        TestCase.assertEquals(constellation("0621"), "双子座");
        TestCase.assertEquals(constellation("0622"), "巨蟹座");
        TestCase.assertEquals(constellation("0722"), "巨蟹座");
        TestCase.assertEquals(constellation("0723"), "狮子座");
        TestCase.assertEquals(constellation("0822"), "狮子座");
        TestCase.assertEquals(constellation("0823"), "处女座");
        TestCase.assertEquals(constellation("0922"), "处女座");
        TestCase.assertEquals(constellation("0923"), "天秤座");
        TestCase.assertEquals(constellation("1022"), "天秤座");
        TestCase.assertEquals(constellation("1023"), "天蝎座");
        TestCase.assertEquals(constellation("1121"), "天蝎座");
        TestCase.assertEquals(constellation("1122"), "射手座");
        TestCase.assertEquals(constellation("1221"), "射手座");
        TestCase.assertEquals(constellation("1231"), "摩羯座");
    }
}
