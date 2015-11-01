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

import org.softeng.project.hb_server.model.client;
import org.softeng.project.hb_server.services.ClientService;

@Path("/api0/clients")
public class clients {
	
	ClientService clientService = new ClientService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<client> getAllclients() {
		return clientService.getAllClients();	
	}
	
	@GET
	@Path("/{clientid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<client> getProduct(@PathParam("clientid") UUID clientID) {
		return clientService.getClient(clientID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<client> createclient(JAXBElement<client> apiclient) {
		return clientService.createClient(apiclient);
	}
}