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
		for(Field filed : filedList) {
			result.add(new FieldUnit(filed.getName(), getColumnNameFromField(filed.getName()), filed.getGenericType().getTypeName()));
		}
		return result;
	}
	
	public static String getColumnNameFromField(String filedName) {
		
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < filedName.length(); i++) {
			
			if( i > 0 && Character.isUpperCase(filedName.charAt(i))) {
				result.append("_");
				result.append(Character.toLowerCase(filedName.charAt(i)));
			} else {
				result.append(Character.toLowerCase(filedName.charAt(i)));
			}
		}
		return result.toString();
	}
	
	public static void setValueByFieldName(Object ojb, String fieldName, Object value) {
		
		if(value == null) {
			return;
		}
		
		log.debug(value.getClass().getName());
		
		StringBuffer sb = new StringBuffer();
		sb.append("set");
		sb.append(StringUtils.capitalize(fieldName));
		String methodName = sb.toString();
			
		String valueClassName = value.getClass().getName();
		Method method = null;
		try {
			if("java.lang.Integer".equals(valueClassName)) {
				method = ojb.getClass().getDeclaredMethod(methodName, int.class);
			} else if("java.lang.Double".equals(valueClassName)) {
				method = ojb.getClass().getDeclaredMethod(methodName, double.class);
			} else if("java.sql.Date".equals(valueClassName)) {
				method = ojb.getClass().getDeclaredMethod(methodName, Date.class);
			} else {
				method = ojb.getClass().getDeclaredMethod(methodName, value.getClass());
			}
			method.invoke(ojb, value);
			
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
