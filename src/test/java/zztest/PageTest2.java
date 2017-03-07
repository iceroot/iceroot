package zztest;

import java.util.Arrays;

import org.junit.Test;

import com.icexxx.util.IceTestUtil;
import com.icexxx.util.IceUtil;

public class PageTest2 {
     @Test
     public void page(){
    	 int displayCount=9;
    	 int currentPage=1;
    	 int pageCount=10;
//		print(IceUtil.rainbow(1, 10, displayCount),1,10);
//		print(IceUtil.rainbow(2, 10, displayCount),2,10);
//		print(IceUtil.rainbow(3, 10, displayCount),3,10);
//		print(IceUtil.rainbow(4, 10, displayCount),4,10);
		print(IceUtil.rainbow(5, 10, displayCount),5,10);
		print(IceUtil.rainbow(6, 10, displayCount),6,10);
		print(IceUtil.rainbow(7, 10, displayCount),7,10);
		print(IceUtil.rainbow(8, 10, displayCount),8,10);
		print(IceUtil.rainbow(9, 10, displayCount),9,10);
		print(IceUtil.rainbow(10, 10, displayCount),10,10);
		print(IceUtil.rainbow(11, 10, displayCount),11,10);
		print(IceUtil.rainbow(12, 10, displayCount),12,10);
		print(IceUtil.rainbow(13, 10, displayCount),13,10);
		print(IceUtil.rainbow(14, 10, displayCount),14,10);
		print(IceUtil.rainbow(15, 10, displayCount),15,10);
		IceTestUtil.print("==================");
		print(IceUtil.rainbow(1, 11, displayCount),1,11);
		print(IceUtil.rainbow(2, 11, displayCount),2,11);
		print(IceUtil.rainbow(3, 11, displayCount),3,11);
		print(IceUtil.rainbow(4, 11, displayCount),4,11);
		print(IceUtil.rainbow(5, 11, displayCount),5,11);
		print(IceUtil.rainbow(6, 11, displayCount),6,11);
		print(IceUtil.rainbow(7, 11, displayCount),7,11);
		print(IceUtil.rainbow(8, 11, displayCount),8,11);
		print(IceUtil.rainbow(9, 11, displayCount),9,11);
		print(IceUtil.rainbow(10, 11, displayCount),10,11);
		print(IceUtil.rainbow(11, 11, displayCount),11,11);
		print(IceUtil.rainbow(12, 11, displayCount),12,11);
		print(IceUtil.rainbow(13, 11, displayCount),13,11);
		print(IceUtil.rainbow(14, 11, displayCount),14,11);
		print(IceUtil.rainbow(15, 11, displayCount),15,11);
		IceTestUtil.print("==================");
		print(IceUtil.rainbow(1, 12, displayCount),1,12);
		print(IceUtil.rainbow(2, 12, displayCount),2,12);
		print(IceUtil.rainbow(3, 12, displayCount),3,12);
		print(IceUtil.rainbow(4, 12, displayCount),4,12);
		print(IceUtil.rainbow(5, 12, displayCount),5,12);
		print(IceUtil.rainbow(6, 12, displayCount),6,12);
		print(IceUtil.rainbow(7, 12, displayCount),7,12);
		print(IceUtil.rainbow(8, 12, displayCount),8,12);
		print(IceUtil.rainbow(9, 12, displayCount),9,12);
		print(IceUtil.rainbow(10, 12, displayCount),10,12);
		print(IceUtil.rainbow(11, 12, displayCount),11,12);
		print(IceUtil.rainbow(12, 12, displayCount),12,12);
		print(IceUtil.rainbow(13, 12, displayCount),13,12);
		print(IceUtil.rainbow(14, 12, displayCount),14,12);
		print(IceUtil.rainbow(15, 12, displayCount),15,12);
		IceTestUtil.print("==================");
		print(IceUtil.rainbow(1, 9, displayCount),1,9);
		print(IceUtil.rainbow(2, 9, displayCount),2,9);
		print(IceUtil.rainbow(3, 9, displayCount),3,9);
		print(IceUtil.rainbow(4, 9, displayCount),4,9);
		print(IceUtil.rainbow(5, 9, displayCount),5,9);
		print(IceUtil.rainbow(6, 9, displayCount),6,9);
		print(IceUtil.rainbow(7, 9, displayCount),7,9);
		print(IceUtil.rainbow(8, 9, displayCount),8,9);
		print(IceUtil.rainbow(9, 9, displayCount),9,9);
		print(IceUtil.rainbow(10, 9, displayCount),10,9);
		print(IceUtil.rainbow(11, 9, displayCount),11,9);
		print(IceUtil.rainbow(12, 9, displayCount),12,9);
		print(IceUtil.rainbow(13, 9, displayCount),13,9);
		print(IceUtil.rainbow(14, 9, displayCount),14,9);
		print(IceUtil.rainbow(15, 9, displayCount),15,9);
		IceTestUtil.print("==================");
		print(IceUtil.rainbow(1, 8, displayCount),1,8);
		print(IceUtil.rainbow(2, 8, displayCount),2,8);
		print(IceUtil.rainbow(3, 8, displayCount),3,8);
		print(IceUtil.rainbow(4, 8, displayCount),4,8);
		print(IceUtil.rainbow(5, 8, displayCount),5,8);
		print(IceUtil.rainbow(6, 8, displayCount),6,8);
		print(IceUtil.rainbow(7, 8, displayCount),7,8);
		print(IceUtil.rainbow(8, 8, displayCount),8,8);
		print(IceUtil.rainbow(9, 8, displayCount),9,8);
		print(IceUtil.rainbow(10, 8, displayCount),10,8);
		print(IceUtil.rainbow(11, 8, displayCount),11,8);
		print(IceUtil.rainbow(12, 8, displayCount),12,8);
		print(IceUtil.rainbow(13, 8, displayCount),13,8);
		print(IceUtil.rainbow(14, 8, displayCount),14,8);
		print(IceUtil.rainbow(15, 8, displayCount),15,8);
		IceTestUtil.print("==================");
     }

	private void print(int[] rainbow,int currentPage,int pageCount) {
		System.out.println(Arrays.toString(rainbow)+"\t"+" > 当前"+currentPage+">共"+pageCount);
	}
}
