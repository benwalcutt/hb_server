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

import org.softeng.project.hb_server.model.transaction;
import org.softeng.project.hb_server.services.TransactionService;

@Path("/api0/transactions")
public class transactions {
	
	TransactionService transactionService = new TransactionService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<transaction> getAlltransactions() {
		return transactionService.getAllTransactions();	
	}
	
	@GET
	@Path("/{transactionid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<transaction> getProduct(@PathParam("transactionid") UUID transactionID) {
		return transactionService.getTransaction(transactionID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createtransaction(JAXBElement<transaction> apitransaction) {
		transactionService.createTransaction(apitransaction);
		return;
	}
}