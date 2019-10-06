package zztest;

import java.awt.image.BufferedImage;
import java.io.File;

import org.junit.Test;

import com.icexxx.util.IcePicUtil;

public class IcePicUtilTest {
    // @Test
    public void test1() {
        File file = new File("C:/Users/Administrator/Desktop/test.png");
        BufferedImage image = IcePicUtil.toImage(file);
        System.out.println(image);
    }

    // @Test
    public void test2() {
        String fileName = "C:/Users/Administrator/Desktop/test.png";
        BufferedImage image = IcePicUtil.toImage(fileName);
        System.out.println(image);
    }
}
