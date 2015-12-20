/**
 * 
 */
package com.hcr.bdr.crm.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author seraph
 *
 */
public class DataBaseManager {
	
	private static DataSource dataSource;

	private static String jdbcDriver;
	private static String jdbcUrl;
	private static String jdbcUser;
	private static String jdbcPass;

	private static String filePath = "jdbc.properties";
	private static Properties properties;
	
	static {
		initParams();
		dataSource = setupDataSource();
	}


	public static void initParams() {

		properties = new Properties();
		try {
			ClassLoader classLoader = DataBaseManager.class.getClassLoader();
			properties.load(classLoader.getResourceAsStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		jdbcDriver = properties.getProperty("jdbc.driver");
		jdbcUrl = properties.getProperty("jdbc.url");
		jdbcUser = properties.getProperty("jdbc.user");
		jdbcPass = properties.getProperty("jdbc.pass");
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	private static DataSource setupDataSource() {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass(jdbcDriver);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		cpds.setJdbcUrl(jdbcUrl);
		cpds.setUser(jdbcUser);
		cpds.setPassword(jdbcPass);
		cpds.setMinPoolSize(10);
		cpds.setAcquireIncrement(10);
		cpds.setMaxPoolSize(20);
		return cpds;
	}

}
