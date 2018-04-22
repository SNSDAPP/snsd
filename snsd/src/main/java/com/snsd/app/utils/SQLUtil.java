package com.snsd.app.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// import com.jade.util.BaithakLogger;

/**
 * @author Adesh.Patel This class talks to DB. Provides operations to create, insert or update,
 *         delete, query, call procedure or function
 */
public class SQLUtil {

	// public static Logger logger = Logger.getLogger(SQLUtil.class);

	public SQLUtil() {

	}

	/**
	 * This method executes update query on DB connection
	 * 
	 * @param query
	 *            - query to be executed, can be parameterized
	 * @param parameters
	 *            - parameters map of index and parameter value to set
	 * @param con
	 *            - DB connection, query to be executed upon
	 * @return Number indicating number of records updated
	 * @throws SQLException
	 *             - If any DB activity fails
	 */
	public static int executeUpdateQuery(String query, HashMap parameters, Connection con) throws SQLException {

		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(query);
			if (parameters != null) {
				Set keySet = parameters.keySet();
				Iterator keyIterator = keySet.iterator();
				while (keyIterator.hasNext()) {
					Object keyObject = keyIterator.next();
					Object objectVal = parameters.get(keyObject);
					int parameterIndex = Integer.parseInt(keyObject.toString());
					statement.setObject(parameterIndex, objectVal);
				}

			}
			int modifiedRecords = statement.executeUpdate();

			return modifiedRecords;
		} catch (SQLException e) {
			// BaithakLogger.error("executeUpdate : " + e);
			throw e;
		} finally {
			// DbConnection.closeDBResources(null, new PreparedStatement[]{statement});
		}

	}

	public static int executeInsertQuery(String query, HashMap parameters, Connection con) throws SQLException {

		int recordId = 0;
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			System.out.println("11");
			if (parameters != null) {
				Set keySet = parameters.keySet();
				Iterator keyIterator = keySet.iterator();
				while (keyIterator.hasNext()) {
					Object keyObject = keyIterator.next();
					Object objectVal = parameters.get(keyObject);
					int parameterIndex = Integer.parseInt(keyObject.toString());
					statement.setObject(parameterIndex, objectVal);
				}

			}
			int modifiedRecords = statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				recordId = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// BaithakLogger.error("executeInsert : " + e);
			throw e;
		} catch (Exception ee) {
			ee.printStackTrace();
			// BaithakLogger.error("executeInsert : " + ee);
			try {
				throw ee;
			} catch (Exception e) {
				// BaithakLogger.error("executeInsert : " + ee);
				e.printStackTrace();
			}
		} finally {

			// DbConnection.closeDBResources(null, new
			// PreparedStatement[]{statement});
		}
		return recordId;

	}

	/**
	 * This method gets next value from given sequence
	 * 
	 * @param sequenceName
	 *            whose next value to take
	 * @param con
	 *            - DB connection, sequence value to be taken from
	 * @return NEXT Value from given sequence
	 * @throws SQLException
	 *             - If any DB activity fails
	 */
	public static String getSquenceValue(String sequenceName, Connection con) throws SQLException {

		Statement statement = null;
		String sequenceValue = "";
		ResultSet rs = null;
		try {
			statement = con.createStatement();
			String query = " SELECT " + sequenceName + ".nextval FROM DUAL";
			rs = statement.executeQuery(query);
			if (rs.next()) {
				sequenceValue = rs.getString(1);
			}
		} catch (Exception e) {
			// BaithakLogger.error("getSequence : " + e);
			e.printStackTrace();

		} finally {
			DbConnection.closeDBResources(new ResultSet[] { rs }, new Statement[] { statement });
		}

		return sequenceValue;
	}

	/**
	 * This method executes query to retrieve data from DB
	 * 
	 * @param queryString
	 *            to be executed, can be parameterized
	 * @param parameters
	 *            - to be used if query is parameterized (using ?)
	 * @param con
	 *            - DB connection, query to be executed upon
	 * @return Result of query execution
	 * @throws SQLException
	 *             - If any DB activity fails
	 */
	public static ResultSet executeQuery(String queryString, Map parameters, Connection con) throws SQLException {

		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = con.prepareStatement(queryString);
			if (parameters != null) {
				Set keySet = parameters.keySet();
				Iterator keyIterator = keySet.iterator();

				while (keyIterator.hasNext()) {
					Object keyObject = keyIterator.next();
					String parameterIndexStr;
					// from few places, key is passed as integer value and from some places passed
					// as number in string format
					if (keyObject instanceof Integer) {
						parameterIndexStr = ((Integer) keyObject).toString();
					} else {
						parameterIndexStr = (String) keyObject;
					}
					Object parameterValue = parameters.get(keyObject);
					int parameterIndex = Integer.parseInt(parameterIndexStr);
					statement.setObject(parameterIndex, parameterValue);

				}
			}
			rs = statement.executeQuery();
		} catch (SQLException e) {
			// BaithakLogger.error("executeQuery : " + e);

			throw e;
		} finally {
			// DbConnection.closeDBResources(null, new PreparedStatement[]{statement});
		}
		return rs;
	}

	/**
	 * @param objects
	 * @return
	 */
	public static String[] convertToString(Object[] objects) {

		if (objects == null || objects.length == 0) {
			return null;
		}
		String[] str = new String[objects.length];
		for (int i = 0; i < objects.length; i++) {
			str[i] = objects[i].toString();
		}
		return str;
	}

}
