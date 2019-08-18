/**
 * 
 */
package com.yizhuoyan.yiyi.random.generator;

import java.time.LocalDate;
import java.time.LocalTime;

import com.yizhuoyan.yiyi.random.ValueGenerater;

/**
 * @author 张三
 *
 */
public class LocalTimeGenerator extends ValueGenerater{

	
	@Override
	public boolean isCanDo(Class type) {
		return type ==LocalTime.class; 
	}
	@Override
	public String generate(String tip) {
		return "LocalTime.now()";
	}
	
	

}
