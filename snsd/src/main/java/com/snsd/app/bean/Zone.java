package com.snsd.app.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Zone")
public class Zone {

	private int id;
	private String zone_number;
	private String zone_name;
	private String status;
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZone_number() {
		return zone_number;
	}

	public void setZone_number(String zone_number) {
		this.zone_number = zone_number;
	}

	public String getZone_name() {
		return zone_name;
	}

	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
