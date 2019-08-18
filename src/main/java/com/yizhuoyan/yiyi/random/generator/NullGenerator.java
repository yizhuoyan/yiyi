/**
 * 
 */
package com.yizhuoyan.yiyi.random.generator;

import com.yizhuoyan.yiyi.random.ValueGenerater;

/**
 * @author 张三
 *
 */
public class NullGenerator extends ValueGenerater{

	@Override
	public boolean isCanDo(Class type) {
		return true;
	}

	@Override
	public String generate(String tip) {
		return "null";
	}

}
