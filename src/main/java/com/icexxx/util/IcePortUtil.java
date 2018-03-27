package com.icexxx.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 端口工具类
 * 
 * @author IceWater
 * @version 2.1
 */
public class IcePortUtil {
    /**
     * 结束端口对应的进程
     * 
     * @param port 端口
     * @since 2.1
     */
    public static void close(int port) {
        Runtime runtime = Runtime.getRuntime();
        try {
            // 查找进程号
            Process process = runtime.exec("cmd /c netstat -ano | findstr \"" + port + "\"");
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            InputStream inputStream = process.getInputStream();
            List<String> readText = read(inputStream, "UTF-8", port);
            if (readText.size() == 0) {
                // System.out.println("找不到该端口的进程");
                try {
                    Thread.sleep(6000);
                    System.exit(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                for (String string : readText) {
                    // System.out.println(string);
                }
                // System.out.println("找到" + readText.size() + "个进程，正在准备清理");
                killWithPid(readText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一次性杀除所有的端口
     * 
     * @param pids 进程id
     */
    public static void killWithPid(List<String> pids) {
        for (String pid : pids) {
            try {
                Process process = Runtime.getRuntime().exec("taskkill /F /pid " + pid + "");
                InputStream inputStream = process.getInputStream();
                String txt = readTxt(inputStream, "GBK");
                // System.out.println(txt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> read(InputStream in, String charset, int portOld) {
        List<String> analysisContent = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, charset));
            String line;
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                String port = analysisPort(line, portOld);
                if (port != null && !analysisContent.contains(port)) {
                    analysisContent.add(port);
                }
            }
            // System.out.println("pid => " + analysisContent);
            reader.close();
            return analysisContent;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String analysisPort(String line, int portOld) {
        if (line == null) {
            return null;
        }
        line = line.trim();
        String[] arrays = line.split("\\s+");
        String portPart = arrays[1];
        String pid = arrays[4];
        String[] ary = portPart.split(":");
        if (ary[1].equals(portOld + "")) {
            return pid;
        } else {
            return null;
        }
    }

    public static String readTxt(InputStream in, String charset) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, charset));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
