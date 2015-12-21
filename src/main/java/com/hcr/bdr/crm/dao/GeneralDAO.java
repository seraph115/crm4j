/**
 * 
 */
package com.hcr.bdr.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hcr.bdr.crm.util.DbUtils;
import com.hcr.bdr.crm.util.EntityUtils;
import com.hcr.bdr.crm.util.FieldUnit;

/**
 * @author seraph
 *
 */
public class GeneralDAO {
	
	private static final Logger log = Logger.getLogger(GeneralDAO.class);
	
	public <T> List<T> query(String sql, Class<T> clazz) {
		
		List<T> result = new LinkedList<T>();
		
		Connection conn = null;
		try {
			conn = DataBaseManager.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<FieldUnit> fieldUnitList = DbUtils.getFieldsFromResultSet(rs);
			
			while(rs.next()) {
				T injectedObject = clazz.newInstance();				
				for(FieldUnit fieldUnit : fieldUnitList) {					
					Object o = rs.getObject(fieldUnit.getColumnName());
					EntityUtils.setValueByFieldName(injectedObject, fieldUnit.getFieldName(), o);
					log.info(fieldUnit.getFieldName() + ": " + o);
				}
				result.add(injectedObject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		return result;
	}
}
