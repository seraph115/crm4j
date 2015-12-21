/**
 * 
 */
package com.hcr.bdr.crm.standalone;

import java.util.List;

import org.apache.log4j.Logger;

import com.hcr.bdr.crm.dao.GeneralDAO;
import com.hcr.bdr.crm.dao.HaiziwangSkuDAO;
import com.hcr.bdr.crm.dao.HaiziwangSkuDAOImpl;
import com.hcr.bdr.crm.model.HaiziwangSku;

/**
 * @author seraph
 *
 */
public class Runner {
	
	private static final Logger log = Logger.getLogger(Runner.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String sql = "SELECT gid, gname, amount, created_date FROM haiziwang_sku_top";
		GeneralDAO generalDAO = new GeneralDAO();
		List<HaiziwangSku> haiziwangSkuList = generalDAO.query(sql, HaiziwangSku.class);
		log.info(haiziwangSkuList);
		
		HaiziwangSkuDAO haiziwangSkuDAO = new HaiziwangSkuDAOImpl();
		List<HaiziwangSku> haiziwangSkus = haiziwangSkuDAO.queryByAll();
		log.info(haiziwangSkus);		
	}

}
