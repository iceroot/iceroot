package zztest;

import static com.icexxx.util.IceTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.icexxx.util.IceConvertUtil;

public class IceConvertUtilTest {
    // @Test
    public void toStrArray() {
        List<Integer> list = null;
        print(IceConvertUtil.toStrArray(list) + "");
        list = new ArrayList<Integer>();
        print(IceConvertUtil.toStrArray(list) + "");
        list.add(123);
        list.add(456);
        list.add(789);
        print(IceConvertUtil.toStrArray(list) + "");
        List<String> list2 = IceConvertUtil.toStrArray(list);
        print(list2.get(0) + 45);
    }

    // @Test
    public void toObjectArray() {
        List<Integer> list = null;
        print(IceConvertUtil.toObjectArray(list) + "");
        list = new ArrayList<Integer>();
        print(IceConvertUtil.toObjectArray(list) + "");
        list.add(123);
        list.add(456);
        list.add(789);
        print(IceConvertUtil.toObjectArray(list) + "");
        List<Object> list2 = IceConvertUtil.toObjectArray(list);
        print(list2.get(0) + "");
    }

    // @Test
    public void toIntArray() {
        List<String> list = null;
        print(IceConvertUtil.toIntArray(list) + "");
        list = new ArrayList<String>();
        print(IceConvertUtil.toIntArray(list) + "");
        list.add("123");
        list.add("456");
        list.add("789");
        print(IceConvertUtil.toIntArray(list) + "");
        List<Integer> list2 = IceConvertUtil.toIntArray(list);
        print(list2.get(0) + 123);
    }
}
