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
public class FloatGenerator extends ValueGenerater{

	@Override
	public boolean isCanDo(Class type) {
		 
		return type == int.class 
				|| type == short.class || type == long.class || type == Integer.class
				|| type == Long.class
				|| type==float.class
				|| type==double.class
				|| type==Float.class
				|| type==Double.class;
	}

	@Override
	public String generate(String tip) {
		switch (tip) {
		case "money":
			float v=RandomUtil.randomAB(100, 1000);
			return dot2(v);
		}
		return dot2(RandomUtil.randomAB(1, 10000));
	}
	
	private String dot2(double f) {
		return String.valueOf(((int)(f*100))/100.0f);
	}

}
