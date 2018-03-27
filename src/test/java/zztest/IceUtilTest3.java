package zztest;

import static junit.framework.TestCase.assertEquals;

import static com.icexxx.util.IceTestUtil.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icexxx.util.IceUtil;

public class IceUtilTest3 {
    // @Test
    public void testVersion() {
        System.out.println("----------------------------------");
        // Assert.assertEquals(expected, actual);
        assertEquals("", "");
        print(IceUtil.version("1.1", "1.2"));
        print(IceUtil.version("1.2", "1.2"));
        System.out.println("1.0".compareTo("1.2"));
    }

    /**
     * Test method for {@link com.icexxx.util.IceUtil#avg(java.util.List)}.
     */
    // @Test
    public void testAvg() {
        List<Double> list = new ArrayList<Double>();
        // list.add(1.3);
        // list.add(1.4);
        // list.add(1.5);
        print(IceUtil.avg(list));
        print(IceUtil.avg(null));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#getLeftFromLeft(java.lang.String, java.lang.String)}
     * .
     */
    // @Test
    public void testGetLeftFromLeft() {
        print(IceUtil.getLeftFromLeft(null, null));
        print(IceUtil.getLeftFromLeft("", ""));
        print(IceUtil.getLeftFromLeft("abcdefghijklmndefopqrstuvwxyz", "def"));
        print(IceUtil.getLeftFromLeft("abcdefghijklmndefopqrstuvwxyz", "hello"));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#getLeftFromRight(java.lang.String, java.lang.String)}
     * .
     */
    // @Test
    public void testGetLeftFromRight() {
        print(IceUtil.getLeftFromRight(null, null));
        print(IceUtil.getLeftFromRight("", ""));
        print(IceUtil.getLeftFromRight("abcdefghijklmndefopqrstuvwxyz", "def"));
        print(IceUtil.getLeftFromRight("abcdefghijklmndefopqrstuvwxyz", "hello"));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#getRightFromLeft(java.lang.String, java.lang.String)}
     * .
     */
    // @Test
    public void testGetRightFromLeft() {
        print(IceUtil.getRightFromLeft(null, null));
        print(IceUtil.getRightFromLeft("", ""));
        print(IceUtil.getRightFromLeft("abcdefghijklmndefopqrstuvwxyz", "def"));
        print(IceUtil.getRightFromLeft("abcdefghijklmndefopqrstuvwxyz", "hello"));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#getRightFromRight(java.lang.String, java.lang.String)}
     * .
     */
    // @Test
    public void testGetRightFromRight() {
        print(IceUtil.getRightFromRight(null, null));
        print(IceUtil.getRightFromRight("", ""));
        print(IceUtil.getRightFromRight("abcdefghijklmndefopqrstuvwxyz", "def"));
        print(IceUtil.getRightFromRight("abcdefghijklmndefopqrstuvwxyz", "hello"));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#wrap(java.lang.String, java.lang.String, java.lang.String)}
     * .
     */
    // @Test
    public void testWrap() {
        print(IceUtil.wrap("abc", null, null));
        print(IceUtil.wrap("abc", null, ")"));
        print(IceUtil.wrap("abc", "(", null));
        print(IceUtil.wrap("abc", "(", ")"));
        print(IceUtil.wrap(null, "(", ")"));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#unWrap(java.lang.String, java.lang.String, java.lang.String)}
     * .
     */
    // @Test
    public void testUnWrap() {
        print(IceUtil.unWrap(null, "(", ")"));
        print(IceUtil.unWrap("(abc)", "(", ")"));
        print(IceUtil.unWrap("(abc(def)gh)", "(", ")"));
        print(IceUtil.unWrap("(abc(def)gh)", "(", ")"));
        print(IceUtil.unWrap("abc(def)gh)", "(", ")"));
        print(IceUtil.unWrap("(abc(def)gh", "(", ")"));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#max(double, double, double)}.
     */
    // @Test
    public void testMaxDoubleDoubleDouble() {
        print(IceUtil.max(1.1, 1.9, 1.6));
        print(IceUtil.max(2.1, 1.9, 1.6));
        print(IceUtil.max(2.1, 1.9, 9.6));
    }

    /**
     * Test method for {@link com.icexxx.util.IceUtil#min(int, int, int)}.
     */
    // @Test
    public void testMinIntIntInt() {
        print(IceUtil.min(1.1, 1.9, 1.6));
        print(IceUtil.min(2.1, 1.9, 1.6));
        print(IceUtil.min(2.1, 1.9, 9.6));
    }

    /**
     * Test method for {@link com.icexxx.util.IceUtil#max(int, int, int)}.
     */
    // @Test
    public void testMaxIntIntInt() {
        print(IceUtil.max(23, 26, 25));
        print(IceUtil.max(27, 26, 25));
        print(IceUtil.max(23, 26, 29));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#min(double, double, double)}.
     */
    // @Test
    public void testMinDoubleDoubleDouble() {
        print(IceUtil.min(23, 26, 25));
        print(IceUtil.min(27, 18, 25));
        print(IceUtil.min(23, 26, 21));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#removeSlash(java.lang.String)}.
     */
    // @Test
    public void testRemoveSlash() {
        print(IceUtil.removeSlash(null));
        print(IceUtil.removeSlash(""));
        print(IceUtil.removeSlash("a"));
        print(IceUtil.removeSlash("abc"));
        print(IceUtil.removeSlash("abc/"));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#addSlash(java.lang.String)}.
     */
    // @Test
    public void testAddSlash() {
        print(IceUtil.addSlash(null));
        print(IceUtil.addSlash(""));
        print(IceUtil.addSlash("a"));
        print(IceUtil.addSlash("abc"));
        print(IceUtil.addSlash("abc/"));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#left(java.lang.String, int)}.
     */
    // @Test
    public void testLeft() {
        print(IceUtil.left(null, 5));
        print(IceUtil.left("", 5));
        print(IceUtil.left("abcdefghijklmn", 5));
        print(IceUtil.left("abcdefghijklmn", 55));
        print(IceUtil.left("abcdefghijklmn", 0));
        print(IceUtil.left("abcdefghijklmn", -1));
        print(IceUtil.left("abcdefghijklmn", -5));
        print(IceUtil.left("xyz", 3));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#right(java.lang.String, int)}.
     */
    // @Test
    public void testRight() {
        print(IceUtil.right(null, 5));
        print(IceUtil.right("", 5));
        print(IceUtil.right("abcdefghijklmn", 5));
        print(IceUtil.right("abcdefghijklmn", 55));
        print(IceUtil.right("abcdefghijklmn", 0));
        print(IceUtil.right("abcdefghijklmn", -1));
        print(IceUtil.right("abcdefghijklmn", -5));
        print(IceUtil.right("xyz", 3));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#move(java.lang.String, int)}.
     */
    // @Test
    public void testMove() {
        print(IceUtil.move(null, 3));
        print(IceUtil.move("", 3));
        print(IceUtil.move("abcdefghijklmn", 3));
        print(IceUtil.move("abcdefghijklmn", -3));
        print(IceUtil.move("abcdefghijklmn", 0));
        print(IceUtil.move("abcdefghijklmn", 14));
        print(IceUtil.move("abcdefghijklmn", 15));
        print(IceUtil.move("abcdefghijklmn", -15));
    }

    /**
     * Test method for {@link com.icexxx.util.IceUtil#replacement(byte[], int)}.
     */
    // @Test
    public void testReplacement() {
        try {
            System.out.println(IceUtil.replacement(null, 3));
            print(Arrays.toString(IceUtil.replacement("".getBytes(), 3)));
            print(new String(IceUtil.replacement("abcdefghijklmn".getBytes(), 3), "UTF-8"));
            print(new String(IceUtil.replacement("abcdefghijklmn".getBytes(), -3), "UTF-8"));
            print(new String(IceUtil.replacement("abcdefghijklmn".getBytes(), 259), "UTF-8"));
            print(new String(IceUtil.replacement("abcdefghijklmn".getBytes(), -259), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#put(java.util.Map, java.lang.Object, java.lang.Object)}
     * .
     */
    // @Test
    public void testPut() {
        // User user1=new User();
        // user1.setAddr("addr111");
        // user1.setAge("123111");
        // user1.setName("tianye111");
        // User user2=new User();
        // user2.setAddr("addr222");
        // user2.setAge("123222");
        // user2.setName("tianye222");
        // User user3=new User();
        // user3.setAddr("addr333");
        // user3.setAge("123333");
        // user3.setName("tianye333");
        // Map<String,User>map=new HashMap<String,User>();
        // IceUtil.put(map, "aaa", user1);
        // IceUtil.put(map, "bbb", user2);
        // IceUtil.put(map, "bbb", user3);
        // System.out.println(map);
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#listString(java.util.List)}.
     */
    // @Test
    public void testListString() {
        List<String> list1 = IceUtil.listString(null);
        System.out.println(list1);
        List<Object> list = new ArrayList<Object>();
        List<String> list2 = IceUtil.listString(list);
        System.out.println(list2);
        list.add("abcd");
        List<String> list3 = IceUtil.listString(list);
        System.out.println(list3);
        list.add(new java.util.Date());
        List<String> list4 = IceUtil.listString(list);
        System.out.println(list4);
        list.add(456);
        List<String> list5 = IceUtil.listString(list);
        System.out.println(list5);
        list.add(null);
        List<String> list6 = IceUtil.listString(list);
        System.out.println(list6);
    }

    /**
     * Test method for {@link com.icexxx.util.IceUtil#list(java.util.List)}.
     */
    // @Test
    public void testList() {
        List<String> list1 = IceUtil.list(null);
        System.out.println(list1);
        List<Object> list = new ArrayList<Object>();
        List<String> list2 = IceUtil.list(list);
        System.out.println(list2);
        list.add("abcd");
        List<String> list3 = IceUtil.list(list);
        System.out.println(list3);
        list.add(new java.util.Date());
        List<String> list4 = IceUtil.list(list);
        System.out.println(list4);
        list.add(456);
        List<String> list5 = IceUtil.list(list);
        System.out.println(list5);
        list.add(null);
        List<String> list6 = IceUtil.list(list);
        System.out.println(list6);
    }

    /**
     * Test method for {@link com.icexxx.util.IceUtil#mapString(java.util.Map)}.
     */
    // @Test
    public void testMapString() {
        System.out.println(IceUtil.mapString(null));
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, String> map1 = IceUtil.mapString(map);
        System.out.println(map1);
        map.put("abc", "def");
        Map<String, String> map2 = IceUtil.mapString(map);
        System.out.println(map2);
        map.put("fff", 456);
        Map<String, String> map3 = IceUtil.mapString(map);
        System.out.println(map3);
        map.put("ggg", new java.util.Date());
        Map<String, String> map4 = IceUtil.mapString(map);
        System.out.println(map4);
        map.put("kkk", null);
        Map<String, String> map5 = IceUtil.mapString(map);
        System.out.println(map5);
    }

    /**
     * Test method for {@link com.icexxx.util.IceUtil#map(java.util.Map)}.
     */
    // @Test
    public void testMap() {
        System.out.println(IceUtil.map(null));
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, String> map1 = IceUtil.map(map);
        System.out.println(map1);
        map.put("abc", "def");
        Map<String, String> map2 = IceUtil.map(map);
        System.out.println(map2);
        map.put("fff", 456);
        Map<String, String> map3 = IceUtil.map(map);
        System.out.println(map3);
        map.put("ggg", new java.util.Date());
        Map<String, String> map4 = IceUtil.map(map);
        System.out.println(map4);
        map.put("kkk", null);
        Map<String, String> map5 = IceUtil.map(map);
        System.out.println(map5);
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#deduplication(java.util.List)}.
     */
    // @Test
    public void testDeduplication() {
        System.out.println(IceUtil.deduplication(null));
        List<String> list = new ArrayList<String>();
        System.out.println(IceUtil.deduplication(list));
        list.add("aaa");
        System.out.println(IceUtil.deduplication(list));
        list.add("bbb");
        System.out.println(IceUtil.deduplication(list));
        list.add("ccc");
        System.out.println(IceUtil.deduplication(list));
        list.add("aaa");
        System.out.println(IceUtil.deduplication(list));
        list.add("aaa");
        System.out.println(IceUtil.deduplication(list));
        list.add("bbb");
        System.out.println(IceUtil.deduplication(list));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#parseInt(java.lang.String)}.
     */
    // @Test
    public void testParseInt() {
        Integer num1 = IceUtil.parseInt(null);
        System.out.println(num1);
        Integer num2 = IceUtil.parseInt("");
        System.out.println(num2);
        Integer num3 = IceUtil.parseInt("123");
        System.out.println(num3);
        Integer num4 = IceUtil.parseInt("-156");
        System.out.println(num4);
        Integer num5 = IceUtil.parseInt("789abd");
        System.out.println(num5);
        Integer num6 = IceUtil.parseInt("-789xyz");
        System.out.println(num6);
    }

    /**
     * Test method for {@link com.icexxx.util.IceUtil#join(java.util.List)}.
     */
    // @Test
    public void testJoin() {
        // Map<String, String> join1 = IceUtil.join(null);
        // System.out.println(join1);
        // List<Map<String,String>>list2=new ArrayList<Map<String,String>>();
        // Map<String, String> join2 = IceUtil.join(list2);
        // System.out.println(join2);
        // System.out.println("------------");
        // List<Map<String,String>>list3=new ArrayList<Map<String,String>>();
        // Map<String, String> map3=new HashMap<String,String>();
        // list3.add(map3);
        // Map<String, String> join3 = IceUtil.join(list3);
        // System.out.println(join3);
        // System.out.println("------------");
        // List<Map<String,String>>list4=new ArrayList<Map<String,String>>();
        // Map<String, String> map4=new HashMap<String,String>();
        // list4.add(map4);
        // list4.add(null);
        // Map<String, String> join4 = IceUtil.join(list4);
        // System.out.println(join4);
        // System.out.println("------------");
        // List<Map<String,String>>list5=new ArrayList<Map<String,String>>();
        // Map<String, String> map5=new HashMap<String,String>();
        // map5.put("abc", null);
        // list5.add(map5);
        // list5.add(null);
        // Map<String, String> join5 = IceUtil.join(list5);
        // System.out.println(join5);
        System.out.println("------------");
        List<Map<String, String>> list6 = new ArrayList<Map<String, String>>();
        Map<String, String> map6 = new HashMap<String, String>();
        map6.put("abc", null);
        map6.put("def", "ghi");
        map6.put("yyy", "kkk");
        Map<String, String> map7 = new HashMap<String, String>();
        map7.put("abc", "ggg");
        map7.put("def", "dddd");
        map7.put("ccc", "xyz");
        Map<String, String> map8 = new HashMap<String, String>();
        map8.put("abc", "hello");
        map8.put("def", "mmmm");
        list6.add(map6);
        list6.add(map7);
        list6.add(map8);
        list6.add(null);
        Map<String, String> join6 = IceUtil.join(list6);
        System.out.println(join6);
        // Map<String,String>map1=new HashMap<String,String>();
        // list.add(map1);
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#contain(java.lang.String, int)}.
     */
    // @Test
    public void testContainStringInt() {
        // System.out.println(IceUtil.contain(null,6));
        // System.out.println(IceUtil.contain("",6));
        // System.out.println(IceUtil.contain("abc",6));
        // System.out.println(IceUtil.contain("(abc",6));
        // System.out.println(IceUtil.contain("(abc]",6));
        // System.out.println(IceUtil.contain("(abc,def]",6));
        // System.out.println(IceUtil.contain("(456,def]",6));
        System.out.println(IceUtil.contain("(456,789]", 6));
        System.out.println(IceUtil.contain("(456,789]", 500));
        System.out.println(IceUtil.contain("(456,789]", 456));
        System.out.println(IceUtil.contain("(456,789]", 789));
    }

    /**
     * Test method for {@link com.icexxx.util.IceUtil#mkdir(java.lang.String)}.
     */
    // @Test
    public void testMkdir() {
        // IceUtil.mkdir("C:/Users/Administrator/Desktop/新建文件夹/aaa/bbb");
        // IceUtil.mkdir("C:/Users/Administrator/Desktop/新建文件夹/aaa/bbb/ccc/ddd/ffff/fff");
        // IceUtil.mkdir("C:/Users/Administrator/Desktop/新建文件夹/aaa/vvv/xxx/jjj.txt");
        // IceUtil.mkdir("C:/Users/Administrator/Desktop/新建文件夹/aaa/vvv/z/g.h");
        // IceUtil.mkdir("C:/Users/Administrator/Desktop/新建文件夹/aaa/vvv/rr/");
        IceUtil.mkdir("C:/Users/Administrator/Desktop/新建文件夹/aaa/vvv/yy/.p");
        // mkdir("C:/Users/Administrator/Desktop/新建文件夹/aaa");
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#change(java.lang.String, java.lang.String)}
     * .
     */
    // @Test
    public void testChange() {
        String str = "abc";
        IceUtil.change(str, "def");
        System.out.println(str);
    }

    /**
     * Test method for {@link com.icexxx.util.IceUtil#monthName(int)}.
     */
    // @Test
    public void testMonthName() {
        System.out.println(IceUtil.monthName(0));
        System.out.println(IceUtil.monthName(1));
        System.out.println(IceUtil.monthName(2));
        System.out.println(IceUtil.monthName(3));
        System.out.println(IceUtil.monthName(4));
        System.out.println(IceUtil.monthName(5));
        System.out.println(IceUtil.monthName(6));
        System.out.println(IceUtil.monthName(7));
        System.out.println(IceUtil.monthName(8));
        System.out.println(IceUtil.monthName(9));
        System.out.println(IceUtil.monthName(10));
        System.out.println(IceUtil.monthName(11));
        // System.out.println(IceUtil.monthName(12));
        // System.out.println(IceUtil.monthName(13));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#wrapChar(java.lang.String)}.
     */
    // @Test
    public void testWrapChar() {
        System.out.println(IceUtil.wrapChar(null));
        System.out.println(IceUtil.wrapChar(""));
        System.out.println(IceUtil.wrapChar(" "));
        System.out.println(IceUtil.wrapChar("123,456,789"));
        System.out.println(IceUtil.wrapChar("123,abc,789"));
        System.out.println(IceUtil.wrapChar("   123  ,  abc  ,           789    "));
    }

    /**
     * Test method for
     * {@link com.icexxx.util.IceUtil#template(java.lang.String, java.util.Map)}
     * .
     */
    // @Test
    public void testTemplate() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Hello");
        map.put("word", "World");
        map.put("user", "book");
        System.out.println(IceUtil.template(null, null));
        System.out.println(IceUtil.template(null, map));
        System.out.println(IceUtil.template("", null));
        System.out.println(IceUtil.template("", map));
        System.out.println(IceUtil.template("abc${name}defg${word}hijklmnopqrst${tool}uvwxyz", map));
        System.out.println(IceUtil.template("${name}defg${word}hijklmnopqrst${tool}", map));
        System.out.println(IceUtil.template("${name}defg${word}hijklmnopqrst${name}", map));
    }
}
