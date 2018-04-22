package com.snsd.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.snsd.app.bean.DbConfig;


public class DbConnection {

	static {

		/*
		 * try { InitialContext initialContext = new InitialContext();
		 * 
		 * datasource = (DataSource) initialContext.lookup( "java:/comp/env/jdbc/ams" ); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
	}

	/*
	 * public static Connection getConnection() { Connection conn = null;
	 * 
	 * try { try { //Class.forName("com.mysql.jdbc.Driver");
	 * Class.forName("oracle.jdbc.driver.OracleDriver"); } catch (ClassNotFoundException e) { //
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * conn = DriverManager.getConnection( DbConfig.getOracleConnection(),
	 * DbConfig.getOracleUserName(), DbConfig.getOraclePassword()); //CONFIGDATA.DB_CONNECTION,
	 * CONFIGDATA.LOGIN, CONFIGDATA.SCHEMA_PASS);
	 * System.out.println(" Db Config "+DbConfig.getOracleConnection()+
	 * "  "+DbConfig.getOracleUserName()+"   "+DbConfig.getOraclePassword());
	 * 
	 * } catch (SQLException ex) { ex.printStackTrace(); //BaithakLogger.error("getConnection : " +
	 * ex); }
	 * 
	 * return conn; }
	 */
	public static Connection getMySqlConnection() throws SQLException {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// System.out.println("setting mysql con : " + DbConfig.getMysqlConnection() + ", " +
		// DbConfig.getMysqlUserName() + ", " + DbConfig.getMysqlPassword());
		conn = DriverManager.getConnection(DbConfig.getMysqlConnection(), DbConfig.getMysqlUserName(), DbConfig.getMysqlPassword());
		// CONFIGDATA.DB_CONNECTION, CONFIGDATA.LOGIN, CONFIGDATA.SCHEMA_PASS);

		/*
		 * } catch (SQLException ex) { // ex.printStackTrace(); //
		 * BaithakLogger.error("getConnection : " + ex); }
		 */
		return conn;
	}

	/**
	 * This method closes all resultSets specified by resultSets, all statements specified by
	 * statements and connection Precondition - resultSets are obtained through statements and
	 * statements are obtained through connection and all are not closed earlier
	 * 
	 * @param resultSets
	 *            - Array of java.sql.ResultSet obtained through statements, can be null
	 * @param statements
	 *            - Array of java.util.Statement obtained through connection, can be null
	 * @param connection
	 *            - DBConnection from which statements and resultSets are obtained, can be null
	 * @throws SQLException
	 *             - If any of the DB related activity fails
	 */
	public static void closeDBResources(ResultSet[] resultSets, Statement[] statements, Connection connection) throws SQLException {

		if (resultSets != null && resultSets.length > 0) {
			for (int i = 0; i < resultSets.length; i++) {
				if (resultSets[i] != null) {
					// if(resultSets[i].isClosed()==false) - Failing @ isClosed, so commented
					{
						resultSets[i].close();
					}
				}
			}
		}
		if (statements != null && statements.length > 0) {
			for (int i = 0; i < statements.length; i++) {
				if (statements[i] != null) {
					statements[i].close();

				}
			}
		}
		if (connection != null) {
			// if(connection.isClosed()==false)
			{
				connection.close();
			}
		}
	}

	/**
	 * This method closes all resultSets specified by resultSets, all statements specified by
	 * statements Precondition - resultSets are obtained through statements and all are not closed
	 * earlier
	 * 
	 * @param resultSets
	 *            - Array of java.sql.ResultSet obtained through statements, can be null
	 * @param statements
	 *            - Array of java.util.Statement, can be null
	 * @throws SQLException
	 *             - If any of the DB related activity fails
	 */
	public static void closeDBResources(ResultSet[] resultSets, Statement[] statements) throws SQLException {

		closeDBResources(resultSets, statements, null);
	}

	public static void closeDBResources(ResultSet resultSet, Statement statement, Connection con) throws SQLException {

		ResultSet rs[] = new ResultSet[1];
		rs[0] = resultSet;

		Statement stmt[] = new Statement[1];
		stmt[0] = statement;

		closeDBResources(rs, stmt, con);
	}

	public static void closeDBResources(Connection connection) throws SQLException {

		if (connection != null) {
			// if(connection.isClosed()==false)
			{
				connection.close();
			}
		}
	}

}
