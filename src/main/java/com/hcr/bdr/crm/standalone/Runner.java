/**
 * 
 */
package com.hcr.bdr.crm.standalone;

import java.util.List;

import org.apache.log4j.Logger;

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
		
		HaiziwangSkuDAO haiziwangSkuDAO = new HaiziwangSkuDAOImpl();
		List<HaiziwangSku> haiziwangSkuList = haiziwangSkuDAO.queryByAll();
		log.info(haiziwangSkuList);
	}

}
