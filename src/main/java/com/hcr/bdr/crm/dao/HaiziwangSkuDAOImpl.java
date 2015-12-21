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

import com.hcr.bdr.crm.model.HaiziwangSku;
import com.hcr.bdr.crm.util.EntityUtils;
import com.hcr.bdr.crm.util.FieldUnit;

/**
 * @author seraph
 *
 */
public class HaiziwangSkuDAOImpl extends GeneralDAO implements HaiziwangSkuDAO {
	
	private static final Logger log = Logger.getLogger(HaiziwangSkuDAO.class);

	@Override
	public List<HaiziwangSku> queryByAll() {
		
		List<HaiziwangSku> result = new LinkedList<HaiziwangSku>();
		
		String sql = "SELECT * FROM haiziwang_sku_top";
		
		List<FieldUnit> fieldUnitList = EntityUtils.getClassFields(HaiziwangSku.class);
		
		Connection conn = null;
		try {
			conn = DataBaseManager.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				HaiziwangSku haiziwangSku = new HaiziwangSku();
				for(FieldUnit fieldUnit : fieldUnitList) {
					Object o = rs.getObject(fieldUnit.getColumnName());
					EntityUtils.setValueByFieldName(haiziwangSku, fieldUnit.getFieldName(), o);
					log.info(fieldUnit.getFieldName() + ": " + o);
				}
				result.add(haiziwangSku);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

}
