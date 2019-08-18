/**
 * 
 */
package com.yizhuoyan.yiyi.random.generator;

import com.yizhuoyan.yiyi.random.RandomUtil;
import com.yizhuoyan.yiyi.random.ValueGenerater;

/**
 * @author 张三
 *
 */
public class IntGenerator extends ValueGenerater {

	@Override
	public boolean isCanDo(Class type) {
		return type == int.class
				|| type == long.class 
				|| type == Integer.class
				|| type == Long.class
				|| type == byte.class
				|| type == short.class
				|| type == char.class
				|| type == Byte.class
				|| type == Short.class
				|| type == Character.class;
				
	}

	@Override
	public String generate(String tip) {
		switch (tip) {
		case "flag":
		case "state":
		case "status":
			return String.valueOf(RandomUtil.randomAB(0, 10));
		case "age":
			return String.valueOf(RandomUtil.randomAB(10, 100));
		case "no":
		case "num":
			return String.valueOf(RandomUtil.randomAB(10000, 100000));
		}
		return "0";
	}
	
	

}
