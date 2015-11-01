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

import org.softeng.project.hb_server.model.dummy;
import org.softeng.project.hb_server.services.DummyService;

@Path("/api0/dummys")
public class dummies {
	
	DummyService dummyService = new DummyService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<dummy> getAllDummys() {
		return dummyService.getAllDummys();	
	}
	
	@GET
	@Path("/{dummyid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<dummy> getDummy(@PathParam("dummyid") UUID dummyID) {
		return dummyService.getDummy(dummyID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<dummy> createDummy(JAXBElement<dummy> apidummy) {
		System.out.println("from the post method");
		System.out.println(apidummy.getValue().getID());
		return dummyService.createDummy(apidummy);
	}

}
