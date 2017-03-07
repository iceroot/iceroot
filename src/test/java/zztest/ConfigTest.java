package zztest;

import com.icexxx.util.IceConfigUtil;

public class ConfigTest {//指定
    /**
     *  不带斜线打成jar后先从里面找，找不到里面的再去外面找。都没有找到则报错
     * @param args
     */
	public static void main(String[] args) {
		System.out.println(IceConfigUtil.getString("abc.properties", "name"));
		System.out.println(IceConfigUtil.getString("abc", "age"));
		System.out.println(IceConfigUtil.getString("abc", "addr"));
		System.out.println(IceConfigUtil.getString("abc", "logo"));
		System.out.println(IceConfigUtil.getString("abc", "ip"));
		System.out.println(IceConfigUtil.getString("abc", "menu"));
		System.out.println("----------");
		System.out.println(IceConfigUtil.getString("abc.properties", "name"));
		System.out.println(IceConfigUtil.getString("abc", "age"));
		System.out.println(IceConfigUtil.getString("abc", "addr"));
		System.out.println(IceConfigUtil.getBoolean("abc", "logo"));
		System.out.println(IceConfigUtil.getBoolean("abc", "logo","hide"));
		System.out.println(IceConfigUtil.getString("abc", "ip"));
		System.out.println(IceConfigUtil.getBoolean("abc", "menu"));
		System.out.println(IceConfigUtil.getBoolean("abc", "menu","false"));
		System.out.println("----------");
		System.out.println(IceConfigUtil.getString("abc.properties", "name"));
		System.out.println(IceConfigUtil.getString("abc", "age"));
		System.out.println(IceConfigUtil.getString("abc", "addr"));
		System.out.println(IceConfigUtil.getBoolean("abc", "logox"));
		System.out.println(IceConfigUtil.getBoolean("abc", "logox","hide"));
		System.out.println(IceConfigUtil.getList("abc", "ip"));
		System.out.println(IceConfigUtil.getBoolean("abc", "menux"));
		System.out.println(IceConfigUtil.getBoolean("abc", "menux","false"));
		System.out.println("----------");
		System.out.println(IceConfigUtil.getInt("abc.properties", "age"));
		System.out.println(IceConfigUtil.getInt("abc", "age"));
		System.out.println(IceConfigUtil.getInt("abc", "age",17));
		System.out.println(IceConfigUtil.getInt("abc", "agex"));
		System.out.println(IceConfigUtil.getInt("abc", "agex",17));

	}

}

