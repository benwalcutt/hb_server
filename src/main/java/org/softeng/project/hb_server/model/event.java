package org.softeng.project.hb_server.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.softeng.project.hb_server.adapters.UUIDAdapter;

@XmlRootElement
public class event {
	@XmlJavaTypeAdapter(UUIDAdapter.class)
	private UUID ID;
	private Timestamp date_created;
	@XmlJavaTypeAdapter(UUIDAdapter.class)
	private UUID client_ID;
	private String address;
	private String city;
	private String state;
	private String zip;
	private Timestamp event_date;
	
	public event() {
		
	}
	
	public event(UUID iD, Timestamp date_created, UUID client_ID, String address,
			String city, String state, String zip, Timestamp event_date) {
		ID = iD;
		this.date_created = date_created;
		this.client_ID = client_ID;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.event_date = event_date;
	}	
	
	public UUID getID() {
		return ID;
	}
	public void setID(UUID iD) {
		ID = iD;
	}
	public Timestamp getDate_created() {
		return date_created;
	}
	public void setDate_created(Timestamp date_created) {
		this.date_created = date_created;
	}
	public UUID getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(UUID client_ID) {
		this.client_ID = client_ID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Timestamp getEvent_date() {
		return event_date;
	}
	public void setEvent_date(Timestamp event_date) {
		this.event_date = event_date;
	}
}
