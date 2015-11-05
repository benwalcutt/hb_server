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

import org.softeng.project.hb_server.model.vendor;
import org.softeng.project.hb_server.services.VendorService;

@Path("/api0/vendors")
public class vendors {
	
	VendorService vendorService = new VendorService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<vendor> getAllvendors() {
		return vendorService.getAllVendors();	
	}
	
	@GET
	@Path("/{vendorid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<vendor> getProduct(@PathParam("vendorid") UUID vendorID) {
		return vendorService.getVendor(vendorID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createvendor(JAXBElement<vendor> apivendor) {
		vendorService.createVendor(apivendor);
		return;
	}
	
	@PUT
	@Path("{vendorid}/name/{newname}")
	public void updateVendorName(@PathParam("vendorid") UUID vendorID, @PathParam("newname") String newName) {
		vendorService.updateVendorName(vendorID, newName);
		return;
	}
	
	@PUT
	@Path("{vendorid}/email/{newemail}")
	public void updateVendorEmail(@PathParam("vendorid") UUID vendorID, @PathParam("newemail") String newEmail) {
		vendorService.updateVendorEmail(vendorID, newEmail);
		return;
	}
	
	@PUT
	@Path("{vendorid}/phone/{newphone}")
	public void updateVendorPhone(@PathParam("vendorid") UUID vendorID, @PathParam("newphone") String newPhone) {
		vendorService.updateVendorPhone(vendorID, newPhone);
		return;
	}
	
	@DELETE
	@Path("/{vendorid}")
	public void removeVendor(@PathParam("vendorid") UUID vendorID) {
		vendorService.removeVendor(vendorID);
	}
}