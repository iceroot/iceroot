package zztest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.icexxx.util.IceStatic;
import com.icexxx.util.IceUtil;

public class IceUtilTest26 {
    // @Test
    public void test1() {
        IceStatic.add("abc");
        System.out.println(IceStatic.getList());
    }

    // @Test
    public void test2() {
        IceStatic.put("abc", "def");
        System.out.println(IceStatic.getMap());
    }

    // @Test
    public void test3() {
        Date date = parseDate("2017-01-01 15:23:47");
        IceStatic.setDate(date);
        System.out.println(IceStatic.getDate());
    }

    private Date parseDate(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
