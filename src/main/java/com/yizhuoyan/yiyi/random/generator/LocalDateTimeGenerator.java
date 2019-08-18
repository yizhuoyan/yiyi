/**
 * 
 */
package com.yizhuoyan.yiyi.random.generator;

import java.time.LocalDateTime;

import com.yizhuoyan.yiyi.random.ValueGenerater;

/**
 * @author 张三
 *
 */
public class LocalDateTimeGenerator extends ValueGenerater{

	
	@Override
	public boolean isCanDo(Class type) {
		return type ==LocalDateTime.class; 
	}
	@Override
	public String generate(String tip) {
		return "LocalDateTime.now()";
	}
	
	

}
