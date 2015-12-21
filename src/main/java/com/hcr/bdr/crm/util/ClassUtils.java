/**
 * 
 */
package com.hcr.bdr.crm.util;

/**
 * @author vicky
 *
 */
public class ClassUtils {

	public static String getColumnNameFromField(String filedName) {

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < filedName.length(); i++) {

			if (i > 0 && Character.isUpperCase(filedName.charAt(i))) {
				result.append("_");
				result.append(Character.toLowerCase(filedName.charAt(i)));
			} else {
				result.append(Character.toLowerCase(filedName.charAt(i)));
			}
		}
		return result.toString();
	}

	public static String getFieldNameFromColumn(String columnName) {

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < columnName.length(); i++) {
			char c = columnName.charAt(i);
			if ("_".equals(String.valueOf(c))) {
				result.append(Character.toUpperCase(columnName.charAt(++i)));
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}
	

}
