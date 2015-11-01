package org.softeng.project.hb_server.resources;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.softeng.project.hb_server.model.event;
import org.softeng.project.hb_server.services.EventService;

@Path("/api0/events")
public class events {
	
	EventService eventService = new EventService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<event> getAllevents() {
		return eventService.getAllEvents();	
	}
	
	@GET
	@Path("/{eventid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<event> getProduct(@PathParam("eventid") UUID eventID) {
		return eventService.getEvent(eventID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<event> createEvent(JAXBElement<event> apievent) {
		return eventService.createEvent(apievent);
	}
}