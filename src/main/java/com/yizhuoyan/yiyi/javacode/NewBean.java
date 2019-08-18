/**
 * 
 */
package com.yizhuoyan.yiyi.javacode;

import java.lang.reflect.Method;
import java.util.Map.Entry;

import com.yizhuoyan.yiyi.core.BeanInfo;
import com.yizhuoyan.yiyi.core.BeanUtil;

/**
 * @author 张三
 *
 */
public class NewBean {
	
	public static void run(Class type) {
		run(type, BeanUtil.lowerFirstChar(type.getSimpleName()));
	}
	
	public static void run(Class type,String name) {
		BeanInfo bi=new BeanInfo(type);
		String className=type.getSimpleName();
		System.out.println(String.format("%1$s %2$s = new %1$s();", className,name));
		
		for (Entry<String, Method> entry :bi.setterMap.entrySet()) {
			oneRow(name,entry.getKey(),entry.getValue());
		}
		System.out.println(String.format("return %s;",name));
	}
	
	
	private static void oneRow(String beanName,String fieldName,Method method) {
		StringBuilder result=new StringBuilder();
		result.append(beanName).append(".").append(method.getName());
		result.append("(");
		result.append(fieldName);
		result.append(");");
		
		System.out.println(result);
	}
	
}
