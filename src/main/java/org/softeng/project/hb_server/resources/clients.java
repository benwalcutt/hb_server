package org.softeng.project.hb_server.resources;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.softeng.project.hb_server.model.address;
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
	public client getClient(@PathParam("clientid") UUID clientID) {
		return clientService.getClient(clientID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createClient(JAXBElement<client> apiclient) {
		clientService.createClient(apiclient);
		return;
	}
	
	@PUT
	@Path("/{clientid}/address")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateClientAddress(@PathParam("clientid") UUID clientID, JAXBElement<address> apiaddress) {
		clientService.updateClientAddress(clientID, apiaddress.getValue());
		return;
	}
	
	@PUT
	@Path("/{clientid}/{field}/{newinfo}")
	public void updateClient(@PathParam("clientid") UUID clientID, @PathParam("field") String field, @PathParam("newinfo") String newInfo) {
		//clientService.updateClientName(clientID, newName);
		clientService.updateSingleField(clientID, field, newInfo);
		return;
	}
	
	@DELETE
	@Path("/{clientid}")
	public void removeClient(@PathParam("clientid") UUID clientID) {
		clientService.removeClient(clientID);
	}
	
}