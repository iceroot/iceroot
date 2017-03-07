package zztest;

import static com.icexxx.util.IceTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.icexxx.util.IcePage;
import com.icexxx.util.IceUtil;
public class IceUtilTest {
   //@Test
   public void uuid(){
       print(IceUtil.uuid());
   }
   //@Test
   public void between(){
       print(IceUtil.between("abc(def(ghi)jklmn)opqrst", "(", ")"));
       print(IceUtil.between("abcdef(ghi)jklmn)opqrst", "(", ")"));
       print(IceUtil.between("abc(def(ghi)jklmnopqrst", "(", ")"));
       print(IceUtil.between("abcdefghi)jklmnopqrst", "(", ")"));
       print(IceUtil.between("abcdefghi(jklmnopqrst", "(", ")"));
   }
   //@Test
   public void round(){
       print(IceUtil.round(12.3558));
       print(IceUtil.round(12.3548));
       print(IceUtil.round(12.3000));
       print(IceUtil.round(12.00000));
       print(IceUtil.round(12.5));
       print(IceUtil.round(12.));
       print(IceUtil.round(12));
   }
   
   //@Test
   public void first(){
       String[] strs={"aaaa","bbb","cccc"};
       System.out.println(IceUtil.first(strs));
       strs=new String[]{};
       System.out.println(IceUtil.first(strs));
       strs=null;
       System.out.println(IceUtil.first(strs));
       System.out.println("___________");
       List<String>list=new ArrayList<String>();
       System.out.println(IceUtil.first(list));
       list.add("aaaa");
       list.add("bbb");
       list.add("ccc");
       list.add("ddd");
       System.out.println(IceUtil.first(list));
       list=null;
       System.out.println(IceUtil.first(list));
   }
   //@Test
   public void time2second(){
       System.out.println(IceUtil.time2second("2"));
       System.out.println(IceUtil.time2second("59"));
       System.out.println(IceUtil.time2second("2:15"));
       System.out.println(IceUtil.time2second("02:15"));
       System.out.println(IceUtil.time2second("20:15"));
       System.out.println(IceUtil.time2second("1:20:15"));
       System.out.println(IceUtil.time2second("01:20:15"));
   }
   //@Test
   public void second2time(){
       print(IceUtil.second2time(1));
       print(IceUtil.second2time(17));
       print(IceUtil.second2time(61));
       print(IceUtil.second2time(3600));
       print(IceUtil.second2time(3601));
       print(IceUtil.second2time(3671));
       print(IceUtil.second2time(4271));
       print(IceUtil.second2time(86399));
   }
   //@Test
   public void regex(){
       System.out.println("123".matches("\\d+"));
       System.out.println("123z".matches("\\d+"));
   }
   //@Test
   public void camelCase(){
       print(IceUtil.camelCase("abc"));
       print(IceUtil.camelCase("ABC"));
       print(IceUtil.camelCase("Abc"));
       print(IceUtil.camelCase("aBC"));
       print("================");
       print(IceUtil.camelCase("abc_def"));
       print(IceUtil.camelCase("ABC_DEF"));
       print(IceUtil.camelCase("Abc_DEF"));
       print(IceUtil.camelCase("aBC_def"));
       print("================");
       print(IceUtil.camelCase("abc_defg"));
       print(IceUtil.camelCase("ABC_Defg"));
       print(IceUtil.camelCase("Abc_DEFG"));
       print(IceUtil.camelCase("aBC_DEfg"));
       print("================");
       print(IceUtil.camelCase("_abc_defg"));
       print(IceUtil.camelCase("_ABC_Defg"));
       print(IceUtil.camelCase("_Abc_DEFG"));
       print(IceUtil.camelCase("_aBC_DEfg"));
       print("================");
   }
   //@Test
   public void underLine(){
       print(IceUtil.underLine("abc"));
       print(IceUtil.underLine("abcDef"));
       print(IceUtil.underLine("abcDefGhij"));
   }
   //@Test
   public void toInt(){
       print(IceUtil.toInt("123",1));
       print(IceUtil.toInt("345x",5));
       print(IceUtil.toInt("67",8));
   }
   //@Test
   public void convert2Int(){
       String[]strs={"123","456x","789"};
       print(IceUtil.convert2Int(strs));
       print(IceUtil.convert2Int(strs)[0]);
       print(IceUtil.convert2Int(strs)[1]);
       print(IceUtil.convert2Int(strs)[2]+1);
   }
   //@Test
   public void isLeapYear(){
        //print(IceUtil.isLeapYear(-1));
        //print(IceUtil.isLeapYear(0));
        print(IceUtil.isLeapYear(1));
        print(IceUtil.isLeapYear(1304));
        print(IceUtil.isLeapYear(1300));
        print(IceUtil.isLeapYear(1301));
        print(IceUtil.isLeapYear(1600));
        print(IceUtil.isLeapYear(1601));
        System.out.println();
        print(IceUtil.isLeapYear(1900));
        print(IceUtil.isLeapYear(2000));
        print(IceUtil.isLeapYear(2004));
        print(IceUtil.isLeapYear(3200));
   }
   //@Test
   public void monthDays(){
       print(IceUtil.monthDays(1990, 2));
       print(IceUtil.monthDays(1996, 2));
       print(IceUtil.monthDays(2000, 2));
       print(IceUtil.monthDays(2000, 1));
       print(IceUtil.monthDays(2005, 12));
       print("==================");
       print(IceUtil.monthDays(2005, 9));
       print(IceUtil.monthDays(2005, 4));
       print(IceUtil.monthDays(2005, 6));
       print(IceUtil.monthDays(2005, 11));
       print(IceUtil.monthDays(2005, 10));
       print(IceUtil.monthDays(2005, 5));
   }
   //@Test
   public void pathRemoveExt(){
       print(IceUtil.pathRemoveExt("abc/def"));
       print(IceUtil.pathRemoveExt("abc/defg.txt"));
       print(IceUtil.pathRemoveExt("abc/defg.txt.xml"));
       print(IceUtil.pathRemoveExt("defg.txt.xml"));
       print(IceUtil.pathRemoveExt("debug.xml"));
       print(IceUtil.pathRemoveExt("path/.xml"));
       print("=================");
       print(IceUtil.pathRemoveExt("abcde/fghijkl/mn/path/xyz.xml"));
       print(IceUtil.pathRemoveExt("abcde/fghijkl/mn/path/xyz"));
   }
   //@Test
   public void isDevMode(){
       print(IceUtil.hasEnv("dev_java_mode", "_programming_mode_"));
       print(IceUtil.isDevMode());
       //IceUtil.initEnv(null, "_programming_mode_");
   }
   //@Test
   public void mistWord(){
       print(IceUtil.mistWord("13938712345", 0, 3));
       print(IceUtil.mistWord("13938712345", 1, 3));
       print(IceUtil.mistWord("13938712345", 2, 3));
       print(IceUtil.mistWord("13938712345", 3, 3));
       print(IceUtil.mistWord("13938712345", 4, 3));
       print(IceUtil.mistWord("13938712345", 5, 3));
       System.out.println();
       print(IceUtil.mistWord("13938712345", 3, 5));
       print(IceUtil.mistWord("13938712345", 3, 6));
       print(IceUtil.mistWord("13938712345", 3, 7));
       print(IceUtil.mistWord("13938712345", 3, 9));
       print(IceUtil.mistWord("13938712345", 3, 10));
       print(IceUtil.mistWord("13938712345", 3, 11));
       print(IceUtil.mistWord("13938712345", 3, 20));
       print(IceUtil.mistWord(null, 3, 20));
       print(IceUtil.mistWord("", 3, 20));
       print(IceUtil.mistWord("abc", -1, 20));
//       System.out.println("----------");
       //System.out.println(IceUtil.mistWord("13938712345", 3, 11));
       //print(IceUtil.isDevMode());
       //System.setProperty("dev_java_mode", "_programming_mode_");
   }
   
   //@Test
   public void executeMethod(){
       Object[] paramValue=new Object[]{"13938712345", 3, 8};
    Class[] paramType={String.class,int.class,int.class};
    print(IceUtil.executeMethod(com.icexxx.util.IceUtil.class, "mistWord", paramValue, paramType)+"");
      // print(IceUtil.mistWord("13938712345", 1, 3));
    IcePage page=new IcePage();
//    page.setLast(last);
       Object[] paramValue2=new Object[]{8};
    Class[] paramType2={Integer.class};
    print(IceUtil.executeMethod(page, "setLast", paramValue2, paramType2)+"");
    System.out.println(page.getLast());
    print(IceUtil.executeMethod(page, "getLast")+"");
   }
   //@Test
   public void idCardlastValid(){
       print(IceUtil.idCardlastValid("5301021920050801x"));
       print(IceUtil.idCardValid("53010219200508011X"));
       print(IceUtil.idCardValid("53010219200508011x"));
       print(IceUtil.idCardValid("530102192005080115"));
   }
   //@Test
   public void splitTrim(){
       print(IceUtil.splitTrim("ABCD,EFGHI,JKLMN",","));
       print(IceUtil.splitTrim(",EFGHI,JKLMN,OPQ",","));
       print(IceUtil.splitTrim(",EFGHI,,OPQ",","));
       print(IceUtil.splitTrim("ABCDE^$FGHIJKLMNOPQR^$STUVW^$XYZ","^$"));
       print(IceUtil.splitTrim("ABCDE                    ^$   FGHIJKLMNOPQR    ^$STUVW^$XYZ            ","^$"));
       print(IceUtil.splitTrim("abc",""));
       print("---------------");
       print(IceUtil.splitTrim("abc",null));
       print(IceUtil.splitTrim("","zvxc"));
       print(IceUtil.splitTrim(null,"zvxc"));
       print("---------------");
       print(IceUtil.splitTrim("abc,def"));
   }
   //@Test
   public void getDriverName(){
       print(IceUtil.getDriverName("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8"));
          print(IceUtil.getDriverName("jdbc:oracle:thin:@192.168.3.98:1521:orcl"));
   }
   //@Test
   public void getDatabaseName(){
       print(IceUtil.getDatabaseName("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8"));
       print(IceUtil.getDatabaseName("jdbc:oracle:thin:@//192.168.3.98:1521:orcl?abc=def"));
       print(IceUtil.getDatabaseName("jdbc:mysql://localhost:3306/test"));
       print(IceUtil.getDatabaseName("jdbc:oracle:thin:@//192.168.3.98:1521:orcl"));
       print(IceUtil.getDatabaseName("jdbc:mysql://localhost:3306/"));
       print(IceUtil.getDatabaseName("jdbc:mysql://localhost:3306"));
       print(IceUtil.getDatabaseName("jdbc:oracle:thin:@//192.168.3.98:1521:"));
   }
   //@Test
   public void url2map(){
        print(IceUtil.url2map("abc?name=zs&age=15")+"");
        print(IceUtil.url2map("abc?name=&age=15")+"");
        print(IceUtil.url2map("name=zs&age=15")+"");
        print(IceUtil.url2map("name=&age=15")+"");
   }
   @Test
   public void cmd(){
//	   print(IceUtil.cmd("ipconfig"));
//	   print(IceUtil.cmd("ping 127.0.0.1"));
	   print(IceUtil.cmd("mkdir \"a?\""));
   }
}
