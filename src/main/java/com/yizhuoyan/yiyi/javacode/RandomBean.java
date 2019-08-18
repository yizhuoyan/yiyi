/**
 * 
 */
package com.yizhuoyan.yiyi.javacode;

import java.lang.reflect.Method;

import com.yizhuoyan.yiyi.core.BeanInfo;
import com.yizhuoyan.yiyi.random.ValueGenerater;

/**
 * @author 张三
 *
 */
public class RandomBean {
	
	
	public static void run(Class type) {
		BeanInfo bi=new BeanInfo(type);
		String className=type.getSimpleName();
		System.out.println(String.format("public static %1$s new%1$s(){",className));
		System.out.println(String.format("    %1$s o = new %1$s();", className));
		bi.setterMap.forEach(RandomBean::oneRow);
		System.out.println("    return o;");
		System.out.println("}");
	}
	
	private static void oneRow(String name,Method method) {
		StringBuilder result=new StringBuilder();
		result.append("    o.").append(method.getName());
		result.append("(");
		Class valueType=method.getParameterTypes()[0];
		Object value=ValueGenerater.of(valueType)
				.generate(name);
		result.append(value);
		result.append(");");
		
		System.out.println(result);
	}
	
}
