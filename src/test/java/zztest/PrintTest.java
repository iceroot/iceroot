package zztest;

import java.util.Date;

import org.junit.Test;

import com.icexxx.util.IceTestUtil;
import com.icexxx.util.IceUtil;

public class PrintTest {
	//@Test
	public void printDateTest() {
		IceTestUtil.print(new Date());
	}

	//@Test
	public void printExceptionTest() {
		try {
			int a = 0 / 0;
		} catch (Exception e) {
			IceTestUtil.print(e);
			e.printStackTrace();
		}
	}

	//@Test
	public void intBoolean() {
		Boolean flag = null;
		IceTestUtil.print(flag);
	}
	@Test
	public void dateTest() {
		Date parseDate = IceUtil.parseDate("2015-01-23 23:59:59");
		System.out.println(parseDate);
		IceTestUtil.print(parseDate);
	}
}
