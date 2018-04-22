/*
 * InitListener.java 2014
 * 
 * Copyright � 2013, Jade Global, Inc. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Jade Global, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with Jade Global,
 * Inc.
 */
package com.snsd.app.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.snsd.app.bean.DbConfig;

public class InitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent e) {

		DbConfig.setMysqlHost(Resource.getMessage("mysql_db_host"));
		DbConfig.setMysqlUserName(Resource.getMessage("mysql_db_username"));
		DbConfig.setMysqlPassword(Resource.getMessage("mysql_db_password"));
		DbConfig.setMysqlSchemaName(Resource.getMessage("mysql_db_schema"));

	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {

		//System.out.println("contextDestroyed(ServletContextEvent e)");
	}

}