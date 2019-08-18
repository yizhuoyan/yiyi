/**
 * 
 */
package com.yizhuoyan.yiyi.sqlcode;

import java.lang.reflect.Method;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.yizhuoyan.yiyi.core.BeanInfo;
import com.yizhuoyan.yiyi.core.BeanUtil;

/**
 * @author 张三
 *
 */
public class SQL {

	private static final Map<Class<?>, String> TYPE_MAPPING = new HashMap<>();
	static {
		TYPE_MAPPING.put(String.class, "varchar(32)");
		TYPE_MAPPING.put(int.class, "int");
		TYPE_MAPPING.put(Integer.class, "int");
		TYPE_MAPPING.put(long.class, "int");
		TYPE_MAPPING.put(Long.class, "int");
		TYPE_MAPPING.put(float.class, "decimal(4,2)");
		TYPE_MAPPING.put(double.class, "decimal(4,2)");
		TYPE_MAPPING.put(Date.class, "datetime");
		TYPE_MAPPING.put(Instant.class, "datetime");
		TYPE_MAPPING.put(LocalDateTime.class, "datetime");
		TYPE_MAPPING.put(LocalDate.class, "date");
		TYPE_MAPPING.put(LocalTime.class, "time");
		TYPE_MAPPING.put(boolean.class, "tinyint");
		TYPE_MAPPING.put(Boolean.class, "tinyint");
	}

	public static void createTable(Class type) {
		BeanInfo bi = new BeanInfo(type);
		StringBuilder sql = new StringBuilder();
		sql.append("create table ").append(BeanUtil.toUnderline(type.getSimpleName())).append("(\n");

		Map<String, Method> getterMap = bi.getterMap;

		for (Map.Entry<String, Method> entry : getterMap.entrySet()) {
			String name = BeanUtil.toUnderline(entry.getKey());

			Method method = entry.getValue();
			Class<?> fieldType = method.getReturnType();
			String columnType = TYPE_MAPPING.get(fieldType);
			if (columnType == null) {
				columnType = "char(32)";
				name = name + "_id";
			}
			sql.append(name).append(" ").append(columnType).append(",\n");
		}
		sql.delete(sql.length() - 2, sql.length() - 1);
		sql.append(")");

		System.out.println(sql);
	}

	public static void insert(Class type){
		BeanInfo bi = new BeanInfo(type);
		StringBuilder sql = new StringBuilder();
		sql.append("insert into ").append(
				BeanUtil.toUnderline(type.getSimpleName())
				.toLowerCase()).append("(");
		Map<String, Method> getterMap = bi.getterMap;

		for (Map.Entry<String, Method> entry : getterMap.entrySet()) {
			String name = entry.getKey();
			sql.append(BeanUtil.toUnderline(name)).append(",");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")\nvalues(");
		for (int i = getterMap.size(); i-- > 1;) {
			sql.append("?,");
		}
		sql.append("?)");
		System.out.println(sql);
	}

	public static void insertForMybatis(Class type){
		BeanInfo bi = new BeanInfo(type);
		StringBuilder sql = new StringBuilder();
		sql.append("insert into ").append(BeanUtil.toUnderline(type.getSimpleName())).append("(");
		Map<String, Method> getterMap = bi.getterMap;
		if (getterMap.size() == 0)
			return;
		for (Map.Entry<String, Method> entry : getterMap.entrySet()) {
			String name = entry.getKey();
			sql.append(BeanUtil.toUnderline(name)).append(",");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")\nvalues(");
		for (Map.Entry<String, Method> entry : getterMap.entrySet()) {
			String name = entry.getKey();
			sql.append("#{").append(name).append("}");
			sql.append(",");
		}
		sql.setCharAt(sql.length() - 1, '}');
		System.out.println(sql);
	}

}
