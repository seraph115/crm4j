/**
 * 
 */
package com.hcr.bdr.crm.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.hcr.bdr.crm.model.HaiziwangSku;

/**
 * @author seraph
 *
 */
public class HaiziwangSkuDAOImpl extends GeneralDAO implements HaiziwangSkuDAO {
	
	private static final Logger log = Logger.getLogger(HaiziwangSkuDAO.class);

	@Override
	public List<HaiziwangSku> queryByAll() {
		
		String sql = "SELECT * FROM haiziwang_sku_top";
		List<HaiziwangSku> haiziwangSkuList = this.query(sql, HaiziwangSku.class);

		return haiziwangSkuList;
	}

}
