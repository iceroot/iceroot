package com.icexxx.util;

/**
 * id生成器工具类,处理多线程问题
 * 
 * @author IceWater
 * @date 2017-02-24
 * @version 1.0
 */
public class IceIdGenerator {
	private static long index = 0L;

	/**
	 * 初始化id生成器的起始id
	 * 
	 * @param start 起始id
	 */
	public static synchronized void init(long start) {
		index = start - 1;
	}

	/**
	 * 获取id生成器的下一个id
	 * 
	 * @return id生成器产生的下一个id
	 */
	public static synchronized long next() {
		index++;
		return index;
	}
}
