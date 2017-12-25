package com.icexxx.util;

/**
 * 模板工具类
 * 
 * @author IceWater
 * @version 2.0
 */
public class IceGenUtil {
    public static String forij() {
        String newLine = "\n";
        StringBuilder sb = new StringBuilder();
        sb.append("for (int i = 0; i < array.length; i++) {");
        sb.append(newLine);
        sb.append("    for (int j = 0; j < array[i].length; j++) {");
        sb.append(newLine);
        sb.append("        ");
        sb.append(newLine);
        sb.append("    }");
        sb.append(newLine);
        sb.append("}");
        sb.append(newLine);
        String str = sb.toString();
        System.out.println(str);
        return str;
    }
}
