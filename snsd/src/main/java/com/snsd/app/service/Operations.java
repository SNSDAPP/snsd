package com.snsd.app.service;

import java.util.List;

import javax.ws.rs.HeaderParam;

import com.snsd.app.bean.Zone;

public interface Operations {

	public String sayHello(String authString);
	public List<Zone> getZoneList(String authString);
}
