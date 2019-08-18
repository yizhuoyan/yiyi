/**
 * 
 */
package com.yizhuoyan.yiyi.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author 张三
 *
 */
@SuppressWarnings("rawtypes")
public class BeanInfo {

	final private Class type;
	final public Map<String, Field> fieldMap = new TreeMap<String, Field>();
	final public Map<String, Method> setterMap = new TreeMap<String, Method>();
	final public Map<String, Method> getterMap = new TreeMap<String, Method>();

	/**
	 * 
	 * @param type the type of bean
	 */
	public BeanInfo(Class type) {
		this.type = type;
		this.init();
	}

	private void init() {
		this.getAllFields();
		this.getAllGetter();
		this.getAllSetter();
	}

	private void getAllSetter() {
		Method[] methods = type.getMethods();
		if(methods.length>0) {
			for (Method method : methods) {
				if(BeanUtil.isSetter(method)) {
					this.setterMap.put(
							BeanUtil.getSetterName(method),method);
				}
			}
		}
	}
	private void getAllGetter() {
		Method[] methods = type.getMethods();
		if(methods.length>0) {
			for (Method method : methods) {
				if(BeanUtil.isGetter(method)) {
					this.getterMap.put(
							BeanUtil.getGetterName(method),method);
				}
			}
		}
	}
	
	

	private void getAllFields() {
		Class superClass = type;
		while (superClass != null && superClass != Object.class) {
			getOneClassFields(superClass, this.fieldMap);
			superClass = superClass.getSuperclass();
		}
	}

	private static void getOneClassFields(Class type, Map<String, Field> result) {
		Field[] declaredFields = type.getDeclaredFields();
		if (declaredFields.length > 0) {
			for (Field field : declaredFields) {
				result.put(field.getName(), field);
			}
		}
	}

}
