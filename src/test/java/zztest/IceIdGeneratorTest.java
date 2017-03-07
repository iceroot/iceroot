package zztest;

import java.util.HashSet;
import java.util.Set;

import com.icexxx.util.IceIdGenerator;

public class IceIdGeneratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IceIdGenerator.init(5);
		int length=100;
		Thread[]th=new Thread[length];
		final Set<Integer>set=new HashSet<Integer>();
		for (int i = 0; i < length; i++) {
			th[i]=new Thread(){
				@Override
				public void run() {
					int num=(int)IceIdGenerator.next();
                     set.add(num);
                     System.out.println(num);
				}
				
			};
			th[i].start();
		}
		
        System.out.println("set.size()="+set.size());
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("set.size()="+set.size());
	}

}
