/**
 * 
 */
package com.yizhuoyan.yiyi.random;

import java.util.Random;

/**
 * @author 张三
 *
 */
public class RandomUtil {
	private static final Random RANDOM=new Random();
	
	public static int randomAB(int a,int b) {
		return (int)randomAB(a*1.0, b*1.0);
	}
	public static float randomAB(double a,double b) {
		double v=RANDOM.nextDouble()*Math.abs(a-b)+Math.min(a, b);
		return (float)v;
	}
	
}
