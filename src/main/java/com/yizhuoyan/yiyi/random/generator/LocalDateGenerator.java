/**
 * 
 */
package com.yizhuoyan.yiyi.random.generator;

import java.time.LocalDate;

import com.yizhuoyan.yiyi.random.ValueGenerater;

/**
 * @author 张三
 *
 */
public class LocalDateGenerator extends ValueGenerater{

	
	@Override
	public boolean isCanDo(Class type) {
		return type ==LocalDate.class; 
	}
	@Override
	public String generate(String tip) {
		return "LocalDate.now()";
	}
	
	

}
