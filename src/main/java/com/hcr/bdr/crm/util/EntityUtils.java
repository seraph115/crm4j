/**
 * 
 */
package com.hcr.bdr.crm.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author seraph
 *
 */
public class EntityUtils {

	private static final Logger log = Logger.getLogger(EntityUtils.class);

	public static <T> List<FieldUnit> getClassFields(Class<T> clazz) {
		
		Field[] fields = clazz.getDeclaredFields();
		List<Field> filedList =  Arrays.asList(fields);
		
		List<FieldUnit> result = new LinkedList<FieldUnit>();
		for(Field field : filedList) {
			result.add(new FieldUnit(field.getName(), ClassUtils.getColumnNameFromField(field.getName()), field.getGenericType().getTypeName()));
		}
		return result;
	}
	
	public static void setValueByFieldName(Object injectedObject, String fieldName, Object value) {
		
		// Guard clause to protected the method
		if(value == null) {
			return;
		}
		
		log.debug(value.getClass().getName());
		
		StringBuffer sb = new StringBuffer();
		sb.append("set");
		// First character of String to upper case
		sb.append(StringUtils.capitalize(fieldName));
		String methodName = sb.toString();
			
		String valueClassName = value.getClass().getName();
		Method method = null;
		try {
			if("java.lang.Integer".equals(valueClassName)) {
				method = injectedObject.getClass().getDeclaredMethod(methodName, int.class);
			} else if("java.lang.Double".equals(valueClassName)) {
				method = injectedObject.getClass().getDeclaredMethod(methodName, double.class);
			} else if("java.sql.Date".equals(valueClassName)) {
				method = injectedObject.getClass().getDeclaredMethod(methodName, Date.class);
			} else {
				method = injectedObject.getClass().getDeclaredMethod(methodName, value.getClass());
			}
			method.invoke(injectedObject, value);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
