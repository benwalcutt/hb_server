package org.softeng.project.hb_server.services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.softeng.project.hb_server.data.DataService;
import org.softeng.project.hb_server.model.address;
import org.softeng.project.hb_server.model.event;


public class EventService {
	DataService dataService = new DataService("postgres");
	ResultSet rs;
	event temp_event;
	List<event> eventList;
	public final String TABLE_NAME = "events";
	
	public EventService() {
		this.rs = null;
		eventList = new ArrayList<event>();
	}
	
	public List<event> getAllEvents() {
		this.rs = dataService.queryAll(TABLE_NAME);		
		try {
			while (this.rs.next()) {
				this.eventList.add(readFromRs(rs));
			}	
		} catch (Exception e) {
			System.out.println(e);
		}
		return eventList;
	}

	public event getEvent(UUID eventID) {
		this.rs = dataService.queryOne(TABLE_NAME, eventID);
		return readFromRs(rs);
	}

	public void createEvent(JAXBElement<event> apievent) {
		apievent.getValue().setID(UUID.randomUUID());
		dataService.insertOneEvent(TABLE_NAME, apievent.getValue());
		return;
	}
	
	public void updateEventAddress(UUID eventID, address apiaddress) {
		dataService.updateTableAddressFields(TABLE_NAME, apiaddress, eventID);
	}
	
	public void updateEventClient(UUID eventID, UUID newClientID) {
		dataService.updateEventClient(eventID, newClientID);
	}
	
	public void removeEvent(UUID eventID) {
		dataService.removeOne(TABLE_NAME, eventID);
	}
	
	private event readFromRs(ResultSet rs) {
		try {
			temp_event = new event();
			temp_event.setID(UUID.fromString(this.rs.getString("ID")));
			temp_event.setClient_ID(UUID.fromString(this.rs.getString("client_id")));
			temp_event.setAddress(this.rs.getString("address"));
			temp_event.setCity(this.rs.getString("city"));
			temp_event.setState(this.rs.getString("state"));
			temp_event.setZip(this.rs.getString("zip"));			
		} catch (Exception e) {
			System.out.println(e);
		}
		return temp_event;
	}
}
