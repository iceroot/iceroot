package zztest;

//import org.junit.Assert;
import org.junit.Test;

import com.icexxx.util.IceFormat;

import static junit.framework.TestCase.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IceFormatTest {
    // @Test
    public void format1() {
        assertEquals(IceFormat.format(12, 2, RoundingMode.HALF_UP), "12.00");
        // assertEquals(IceFormat.format(12.565, 2, RoundingMode.HALF_UP),
        // "12.57");
        assertEquals(IceFormat.format(12.5651, 2, RoundingMode.HALF_UP), "12.57");
        assertEquals(IceFormat.format("12.565", 2, RoundingMode.HALF_UP), "12.57");
        assertEquals(IceFormat.format(new BigDecimal("12.565"), 2, RoundingMode.HALF_UP), "12.57");
        assertEquals(IceFormat.format(12.634, 2, RoundingMode.HALF_UP), "12.63");
        assertEquals(IceFormat.format("15.781", 2, RoundingMode.CEILING), "15.79");
        assertEquals(IceFormat.format("15.780", 2, RoundingMode.CEILING), "15.78");
        // assertEquals(IceFormat.format("15.780", 2, RoundingMode.CEILING),
        // "15.79");
    }

    // @Test
    public void round1() {
        assertEquals(IceFormat.round(12, 4), "12.0000");
        assertEquals(IceFormat.round("12.39995", 4), "12.4000");
        assertEquals(IceFormat.round("12.39454", 4), "12.3945");
        assertEquals(IceFormat.round(new BigDecimal("12.39995"), 4), "12.4000");
    }

    // @Test
    public void round2() {
        assertEquals(IceFormat.round(12), "12.00");
        assertEquals(IceFormat.round("12.39995"), "12.40");
        assertEquals(IceFormat.round("12.39456"), "12.39");
        assertEquals(IceFormat.round(new BigDecimal("12.39995")), "12.40");
    }

    // @Test
    public void floor1() {
        assertEquals(IceFormat.floor(12, 4), "12.0000");
        assertEquals(IceFormat.floor("12.39995", 4), "12.3999");
        assertEquals(IceFormat.floor("12.39454", 4), "12.3945");
        assertEquals(IceFormat.floor(new BigDecimal("12.39995"), 4), "12.3999");
    }

    // @Test
    public void floor2() {
        assertEquals(IceFormat.floor(12), "12.00");
        assertEquals(IceFormat.floor("12.39995"), "12.39");
        assertEquals(IceFormat.floor("12.39456"), "12.39");
        assertEquals(IceFormat.floor(new BigDecimal("12.39995")), "12.39");
    }

    // @Test
    public void ceil1() {
        assertEquals(IceFormat.ceil(12, 4), "12.0000");
        assertEquals(IceFormat.ceil("12.39995", 4), "12.4000");
        assertEquals(IceFormat.ceil("12.39454", 4), "12.3946");
        assertEquals(IceFormat.ceil(new BigDecimal("12.39995"), 4), "12.4000");
    }

    // @Test
    public void ceil2() {
        assertEquals(IceFormat.ceil(12), "12.00");
        assertEquals(IceFormat.ceil("12.39995"), "12.40");
        assertEquals(IceFormat.ceil("12.39456"), "12.40");
        assertEquals(IceFormat.ceil(new BigDecimal("12.39995")), "12.40");
    }

    // @Test
    public void natural() {
        assertEquals(IceFormat.natural("27.34567"), "27.34567");
        assertEquals(IceFormat.natural("1230.0001"), "1230.0001");
        assertEquals(IceFormat.natural("1230.000100"), "1230.0001");
        assertEquals(IceFormat.natural("1230.5600"), "1230.56");
        assertEquals(IceFormat.natural("1230.30"), "1230.3");
        assertEquals(IceFormat.natural("1230."), "1230");
        assertEquals(IceFormat.natural("1230.1"), "1230.1");
    }

    // @Test
    public void ceilNatural() {
        assertEquals(IceFormat.ceilNatural("27.34567"), "27.35");
        assertEquals(IceFormat.ceilNatural("72.991"), "73");
        assertEquals(IceFormat.ceilNatural("157.896"), "157.9");
        assertEquals(IceFormat.ceilNatural("1230.4567"), "1230.46");
        assertEquals(IceFormat.ceilNatural("1230.00"), "1230");
        assertEquals(IceFormat.ceilNatural(123.993), "124");
        assertEquals(IceFormat.ceilNatural("17."), "17");
    }

    // @Test
    public void roundNatural() {
        assertEquals(IceFormat.roundNatural("27.34567"), "27.35");
        assertEquals(IceFormat.roundNatural("72.991"), "72.99");
        assertEquals(IceFormat.roundNatural("157.896"), "157.9");
        assertEquals(IceFormat.roundNatural("1230.4567"), "1230.46");
        assertEquals(IceFormat.roundNatural("1230.00"), "1230");
        assertEquals(IceFormat.roundNatural(123.993), "123.99");
        assertEquals(IceFormat.roundNatural("17."), "17");
    }

    // @Test
    public void floorNatural() {
        assertEquals(IceFormat.floorNatural("27.34567"), "27.34");
        assertEquals(IceFormat.floorNatural("72.991"), "72.99");
        assertEquals(IceFormat.floorNatural("157.896"), "157.89");
        assertEquals(IceFormat.floorNatural("1230.4567"), "1230.45");
        assertEquals(IceFormat.floorNatural("1230.00"), "1230");
        assertEquals(IceFormat.floorNatural(123.993), "123.99");
        assertEquals(IceFormat.floorNatural("17."), "17");
        assertEquals(IceFormat.floorNatural("17.0001"), "17");
    }
}
