/**
 * 
 */
package com.yizhuoyan.yiyi.javacode;

import java.lang.reflect.Method;

import com.yizhuoyan.yiyi.core.BeanInfo;
import com.yizhuoyan.yiyi.core.BeanUtil;

/**
 * @author 张三
 *
 */
public class OfVo {
	
	public static void run() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		String className=null;
		if(stackTrace.length>0) {
			className=stackTrace[stackTrace.length-1].getClassName();
		}
		
		if(className==null) {
			System.out.println("请传入类名");
			return;
		}
		try {
			run(Class.forName(className));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static void run(Class type) {
		BeanInfo bi=new BeanInfo(type);
		String className=type.getSimpleName();
		System.out.println(String.format("public static %s of(Object e){",className));
		System.out.println("    if(e==null)return null;");
		System.out.println(String.format("    %1$s vo = new %1$s();", className));
		bi.setterMap.forEach(OfVo::oneRow);
		System.out.println("    return vo;");
		System.out.println("}");
	}
	
	private static void oneRow(String name,Method method) {
		StringBuilder result=new StringBuilder();
		result.append("    vo.").append(method.getName());
		result.append("(e.");
		if(method.getParameterTypes()[0]==boolean.class) {
			result.append("is");
		}else {
			result.append("get");
		}
		result.append(BeanUtil.upperFirstChar(name));
		result.append("()");
		result.append(");");
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		run();
	}
}
