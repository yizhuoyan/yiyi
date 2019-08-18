/**
 * 
 */
package com.yizhuoyan.yiyi.random.generator;

import java.util.UUID;

import com.yizhuoyan.yiyi.random.RandomUtil;
import com.yizhuoyan.yiyi.random.ValueGenerater;

/**
 * @author 张三
 *
 */
public class StringGenerator extends ValueGenerater{

	@Override
	public boolean isCanDo(Class type) {
		 
		return type == String.class 
				|| type==char[].class;
	}

	@Override
	public String generate(String tip) {
		switch (tip) {
		case "id":
			return wrap(UUID.randomUUID().toString()
					.replace("-", ""));
		case "code":
			return wrap(String.valueOf(RandomUtil.randomAB(1000, 10000)));
		default:
			
			break;
		}
		return wrap(tip+RandomUtil.randomAB(100, 1000));
	}
	
	
	
	private String wrap(String v) {
		return "\""+v+"\"";
	}
	

}
