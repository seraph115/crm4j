/**
 * 
 */
package com.hcr.bdr.crm.util;

/**
 * @author seraph
 *
 */
public class FieldUnit {

	private String fieldName;
	
	private String columnName;

	private String fieldType;
	
	public FieldUnit() {
	}

	public FieldUnit(String fieldName, String columnName, String fieldType) {
		super();
		this.fieldName = fieldName;
		this.columnName = columnName;
		this.fieldType = fieldType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	@Override
	public String toString() {
		return "FieldUnit [fieldName=" + fieldName + ", columnName=" + columnName + ", fieldType=" + fieldType + "]";
	}

}
