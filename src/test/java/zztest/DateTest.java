package zztest;

import static com.icexxx.util.IceTestUtil.*;

import java.util.Date;

import org.junit.Test;

import com.icexxx.util.IceUtil;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    @Test
    public void diffDays(){
    	Date date1=IceUtil.parseDate("2015-12-12 23:59:59");
    	Date date2=IceUtil.parseDate("2015-12-13 00:00:01");
    	print(IceUtil.dayLength(date1, date2));
    }
    @Test
    public void diffDays2(){
    	Date date1=IceUtil.parseDate("2015-12-12 23:59:59");
    	Date date2=IceUtil.parseDate("2015-12-13 00:00:00");
    	print(IceUtil.dayLength(date1, date2));
    }
    @Test
    public void diffDays3(){
    	Date date1=IceUtil.parseDate("2015-12-13 00:00:01");
    	Date date2=IceUtil.parseDate("2015-12-12 23:59:59");
    	print(IceUtil.dayLength(date1, date2));
    }
    @Test
    public void diffDays4(){
    	Date date1=IceUtil.parseDate("2015-12-12 00:00:00");
    	Date date2=IceUtil.parseDate("2015-12-13 23:59:59");
    	print(IceUtil.dayLength(date1, date2));
    }
    @Test
    public void diffDays5(){
    	Date date1=IceUtil.parseDate("2015-12-12 00:00:00");
    	Date date2=IceUtil.parseDate("2015-12-12 23:59:59");
    	print(IceUtil.dayLength(date1, date2));
    }
    @Test
    public void diffDays6(){
    	Date date1=IceUtil.parseDate("2015-12-13 23:59:59");
    	Date date2=IceUtil.parseDate("2015-12-12 00:00:00");
    	print(IceUtil.dayLength(date1, date2));
    }
}
