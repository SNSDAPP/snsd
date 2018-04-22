package com.snsd.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.snsd.app.bean.Zone;
import com.snsd.app.dao.ServiceImpl;

@Path("operations")
public class Service implements Operations{
	static Logger SNSDLogger = Logger.getLogger(Operations.class.getName());
	private ServiceImpl service = new ServiceImpl();

	@Path("/sayHello")
	@GET
	@Produces("application/json")
	@Override
	public String sayHello(@HeaderParam("authorization") String authString) {
		SNSDLogger.debug("Inside Method:SayHello");

		JSONObject json = new JSONObject();

		if (!service.isUserAuthenticated(authString)) {
			json.put("status", "Failure");
			json.put("message", "Not authenticated User");
			return json.toString();
		} else {
			try {
				json.put("status", "Success");
				json.put("message", "Valid Method ");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				json.put("status", "Failure");
				json.put("message", "Inside Exception");
				e.printStackTrace();
			}
			return json.toString();
		}
	}

	
	@Path("/getZoneList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Zone> getZoneList(@HeaderParam("authorization") String authString) {

		SNSDLogger.debug("Inside Method:SayHello");

		List<Zone> zoneList = new ArrayList<Zone>();
		Zone zone = null;
		
		if (!service.isUserAuthenticated(authString)) {
			zone = new Zone();
			zone.setStatus("Failure");
			zone.setMessage("Not Authenticated");
			zoneList.add(zone);
			
		} else {
			
			return service.getZoneList();
			
		}
		
		return zoneList;
	}	

	
	

}
