/**
 * 
 */
package com.hcr.bdr.crm.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author vicky
 *
 */
public class DbUtils {
	
	private static final Logger log = Logger.getLogger(DbUtils.class);

	public static <T> List<FieldUnit> getFieldsFromResultSet(ResultSet rs) {
		
		List<FieldUnit> result = new LinkedList<FieldUnit>();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount() + 1;
			for (int i = 1; i < columnCount; i++) {
				String columnName = rsmd.getColumnName(i);
				FieldUnit fieldUnit = new FieldUnit();
				fieldUnit.setColumnName(columnName);
				fieldUnit.setFieldName(ClassUtils.getFieldNameFromColumn(columnName));
				result.add(fieldUnit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
