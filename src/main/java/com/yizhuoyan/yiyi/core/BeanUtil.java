/**
 * 
 */
package com.yizhuoyan.yiyi.core;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @author 张三
 *
 */
public class BeanUtil {

	public static String toUnderline(String name) {
		StringBuilder result = new StringBuilder();
		char c;
		int begin = 0;
		System.out.println(name);
		int i = 0;
		for (; i < name.length(); i++) {
			c = name.charAt(i);
			if ('A' <= c && c <= 'Z') {
				String part = name.substring(begin, i).toLowerCase();
				if (part.length() > 0) {
					result.append(part);
					result.append("_");
				}
				begin = i;
			}
		}
		result.append(name.substring(begin, i).toLowerCase());
		return result.toString();
	}

	public static String getSetterName(Method setter) {
		String name = setter.getName();
		name = name.substring(3);
		return lowerFirstChar(name);
	}

	public static String getGetterName(Method setter) {
		String name = setter.getName();
		if (name.startsWith("is")) {
			name = name.substring(2);
		} else {
			name = name.substring(3);
		}
		return lowerFirstChar(name);
	}

	public static boolean isGetter(Method method) {
		return isIsGetter(method) || isGetGetter(method);
	}

	public static boolean isSetter(Method method) {
		String name = method.getName();
		int modifiers = method.getModifiers();
		return name.startsWith("set") && Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers)
				&& !Modifier.isAbstract(modifiers) && !Modifier.isNative(modifiers) && method.getParameterCount() == 1;

	}

	private static boolean isGetGetter(Method method) {
		String name = method.getName();
		int modifiers = method.getModifiers();
		return name.startsWith("get") && Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers)
				&& !Modifier.isAbstract(modifiers) && !Modifier.isNative(modifiers) && method.getParameterCount() == 0
				&& method.getReturnType() != Void.class;
	}

	private static boolean isIsGetter(Method method) {
		String name = method.getName();
		int modifiers = method.getModifiers();
		return name.startsWith("is") && Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers)
				&& !Modifier.isAbstract(modifiers) && !Modifier.isNative(modifiers) && method.getParameterCount() == 0
				&& method.getReturnType() == boolean.class;
	}

	static public String lowerFirstChar(String s) {
		if (s.length() == 0) {
			return s;
		}
		char[] cs = s.toCharArray();

		cs[0] = Character.toLowerCase(cs[0]);
		return new String(cs);
	}

	static public String upperFirstChar(String s) {
		if (s.length() == 0) {
			return s;
		}
		char[] cs = s.toCharArray();
		cs[0] = Character.toUpperCase(cs[0]);
		return new String(cs);
	}
}
