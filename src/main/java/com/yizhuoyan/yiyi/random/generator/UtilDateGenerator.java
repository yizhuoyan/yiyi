/**
 * 
 */
package com.yizhuoyan.yiyi.random.generator;

import java.time.LocalDate;
import java.util.Date;

import com.yizhuoyan.yiyi.random.ValueGenerater;

/**
 * @author 张三
 *
 */
public class UtilDateGenerator extends ValueGenerater{

	
	@Override
	public boolean isCanDo(Class type) {
		return type ==Date.class; 
	}
	@Override
	public String generate(String tip) {
		return "new java.util.Date()";
	}
	
	

}
