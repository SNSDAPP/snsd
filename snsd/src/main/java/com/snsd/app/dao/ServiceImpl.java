package com.snsd.app.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.snsd.app.bean.Zone;
import com.snsd.app.utils.DbConnection;
import com.snsd.app.utils.Resource;
import com.snsd.app.utils.SQLUtil;

import sun.misc.BASE64Decoder;

public class ServiceImpl {
	public boolean isUserAuthenticated(String authString) {
		//System.out.println("authString" + authString);
		if (null != authString && authString != "") {
			String decodedAuth = "";
			// Header is in the format "Basic 5tyc0uiDat4"
			// We need to extract data before decoding it back to original
			// string
			String[] authParts = authString.split("\\s+");
			String authInfo = authParts[1];
			// Decode the data back to original string
			byte[] bytes = null;
			try {
				bytes = new BASE64Decoder().decodeBuffer(authInfo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			decodedAuth = new String(bytes);
			//System.out.println("decoded string:" + decodedAuth);

			/**
			 * here you include your logic to validate user authentication. it
			 * can be using ldap, or token exchange mechanism or your custom
			 * authentication mechanism.
			 */
			// your validation code goes here....

			String auth = Resource.getMessage("auth");
			byte[] authByte = null;
			String decodedAuthProp = "";
			try {
				authByte = new BASE64Decoder().decodeBuffer(auth);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			decodedAuthProp = new String(authByte);
			//System.out.println("decodedAuthProp::"+decodedAuthProp);
			if(decodedAuthProp.equals(decodedAuth)){
				return true;
			}else{
				return false;
			}
			
			  //YWRtaW46c25zZGFwcDJrMTg=
			
		} else {
			return false;
		}
	}
	
	public List<Zone> getZoneList(){
		
		List<Zone> zoneList = new ArrayList<Zone>();
		Zone zone = null;
		
		
		
		String sql = "SELECT id,zone_number,zone_name FROM snsdappdb.snsd_zone order by zone_name";
		Connection conn = null;
		ResultSet rs = null;
		Boolean flag = false;
		// IOSLogger.debug(" Inside Method getAllUsers ");


		try {
			conn = DbConnection.getMySqlConnection();
		
			rs = SQLUtil.executeQuery(sql, null, conn);

			while (rs.next()) {
				flag = true;
				zone = new Zone();
				zone.setStatus("Success");
				zone.setMessage("Success");
				zone.setId(rs.getInt(1));
				zone.setZone_number(rs.getString(2));
				zone.setZone_name(rs.getString(3));
				zoneList.add(zone);
			}

			if (!flag) {
				zone = new Zone();
				zone.setStatus("Failure");
				zone.setMessage("No Record Found!!");
				
				zoneList.add(zone);
			}
		} catch (SQLException e) {
			// IOSLogger.error(" Inside Method getAllUsers Exception : " + e.toString());
			zone = new Zone();
			zone.setStatus("Failure");
			zone.setMessage("SQL Exception!!");
			
			zoneList.add(zone);
			e.printStackTrace();
		} finally {
			try {
				DbConnection.closeDBResources(rs, null, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		 return zoneList;
	}
}
