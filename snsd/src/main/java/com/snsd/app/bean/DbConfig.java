package com.snsd.app.bean;

public class DbConfig {

	private static String	mysqlSchemaName;
	private static String	mysqlUserName;
	private static String	mysqlPassword;
	private static String	mysqlHost;
	private static String	mysqlPort;
	private static String	mysqlDriver;
	private static String	mysqlConnection;

	
	private static String	emailHost;
	private static String	emailPort;
	private static String	emailProtocol;
	private static String	emailAuth;
	private static boolean	emailTls;
	private static String	emailFrom;
	private static String	emailPassword;
	private static String	emailFromName;
	public static String getEmailHost() {

		return emailHost;
	}

	public static void setEmailHost(String emailHost) {

		DbConfig.emailHost = emailHost;
	}

	public static String getEmailPort() {

		return emailPort;
	}

	public static void setEmailPort(String emailPort) {

		DbConfig.emailPort = emailPort;
	}

	public static String getEmailProtocol() {

		return emailProtocol;
	}

	public static void setEmailProtocol(String emailProtocol) {

		DbConfig.emailProtocol = emailProtocol;
	}

	public static String getEmailAuth() {

		return emailAuth;
	}

	public static void setEmailAuth(String emailAuth) {

		DbConfig.emailAuth = emailAuth;
	}

	public static boolean isEmailTls() {

		return emailTls;
	}

	public static void setEmailTls(boolean emailTls) {

		DbConfig.emailTls = emailTls;
	}

	public static String getEmailFrom() {

		return emailFrom;
	}

	public static void setEmailFrom(String emailFrom) {

		DbConfig.emailFrom = emailFrom;
	}

	public static String getEmailPassword() {

		return emailPassword;
	}

	public static void setEmailPassword(String emailPassword) {

		DbConfig.emailPassword = emailPassword;
	}

	public static String getEmailFromName() {

		return emailFromName;
	}

	public static void setEmailFromName(String emailFromName) {

		DbConfig.emailFromName = emailFromName;
	}


	public static String getMysqlSchemaName() {

		return mysqlSchemaName;
	}

	public static void setMysqlSchemaName(String mysqlSchemaName) {

		DbConfig.mysqlSchemaName = mysqlSchemaName;
	}

	public static String getMysqlUserName() {

		return mysqlUserName;
	}

	public static void setMysqlUserName(String mysqlUserName) {

		DbConfig.mysqlUserName = mysqlUserName;
	}

	public static String getMysqlPassword() {

		return mysqlPassword;
	}

	public static void setMysqlPassword(String mysqlPassword) {

		DbConfig.mysqlPassword = mysqlPassword;
	}

	public static String getMysqlHost() {

		return mysqlHost;
	}

	public static void setMysqlHost(String mysqlHost) {

		DbConfig.mysqlHost = mysqlHost;
	}

	public static String getMysqlPort() {

		return mysqlPort;
	}

	public static void setMysqlPort(String mysqlPort) {

		DbConfig.mysqlPort = mysqlPort;
	}

	public static String getMysqlDriver() {

		return mysqlDriver;
	}

	public static void setMysqlDriver(String mysqlDriver) {

		DbConfig.mysqlDriver = mysqlDriver;
	}

	public static String getMysqlConnection() {

		mysqlConnection = "jdbc:mysql://" + mysqlHost + "/" + mysqlSchemaName;
		return mysqlConnection;
	}

	public static void setMysqlConnection(String mysqlConnection) {

		DbConfig.mysqlConnection = mysqlConnection;
	}


}
