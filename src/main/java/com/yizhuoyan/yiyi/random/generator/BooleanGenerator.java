/**
 * 
 */
package com.yizhuoyan.yiyi.random.generator;

import com.yizhuoyan.yiyi.random.ValueGenerater;

/**
 * @author 张三
 *
 */
public class BooleanGenerator extends ValueGenerater{

	@Override
	public boolean isCanDo(Class type) {
		return type==boolean.class
				||type==Boolean.class;
	}

	@Override
	public String generate(String tip) {
		return String.valueOf(Math.random()>0.5);
	}

}
