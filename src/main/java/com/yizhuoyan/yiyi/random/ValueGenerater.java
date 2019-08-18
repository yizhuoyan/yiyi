/**
 * 
 */
package com.yizhuoyan.yiyi.random;

import java.util.ArrayList;
import java.util.List;

import com.yizhuoyan.yiyi.random.generator.BooleanGenerator;
import com.yizhuoyan.yiyi.random.generator.FloatGenerator;
import com.yizhuoyan.yiyi.random.generator.IntGenerator;
import com.yizhuoyan.yiyi.random.generator.LocalDateGenerator;
import com.yizhuoyan.yiyi.random.generator.LocalDateTimeGenerator;
import com.yizhuoyan.yiyi.random.generator.LocalTimeGenerator;
import com.yizhuoyan.yiyi.random.generator.NullGenerator;
import com.yizhuoyan.yiyi.random.generator.StringGenerator;
import com.yizhuoyan.yiyi.random.generator.UtilDateGenerator;

/**
 * @author 张三
 *
 */
public abstract class  ValueGenerater {
	public abstract boolean isCanDo(Class type);
	public abstract String generate(String tip);
	private static final ValueGenerater NULL_GENERATOR=new NullGenerator();
	private static final List<ValueGenerater> GENERATORS=new ArrayList<ValueGenerater>();
	
	
	public ValueGenerater(){
		
	}
	
	static private void register(ValueGenerater generator) {
		GENERATORS.add(generator);
	}
	
	static {
		register(new IntGenerator());
		register(new StringGenerator());
		register(new BooleanGenerator());
		register(new FloatGenerator());
		register(new LocalDateGenerator());
		register(new LocalDateTimeGenerator());
		register(new UtilDateGenerator());
		register(new LocalTimeGenerator());
		register(new NullGenerator());
	}
	
	
	
	public static ValueGenerater of(Class type) {
		for (ValueGenerater g : GENERATORS) {
			if(g.isCanDo(type)) {
				return g;
			}
		}
		return  NULL_GENERATOR;
	}
	
	
	
	
	
	
}
