/**
 * 
 */
package com.hcr.bdr.crm.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

}
