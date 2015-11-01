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

import org.softeng.project.hb_server.model.employee;
import org.softeng.project.hb_server.model.product;
import org.softeng.project.hb_server.services.EmployeeService;
import org.softeng.project.hb_server.services.ProductService;

@Path("/api0/employees")
public class employees {
	
	EmployeeService employeeService = new EmployeeService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<employee> getAllEmployees() {
		return employeeService.getAllEmployees();	
	}
	
	@GET
	@Path("/{employeeid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<employee> getProduct(@PathParam("employeeid") UUID employeeID) {
		return employeeService.getEmployee(employeeID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<employee> createEmployee(JAXBElement<employee> apiemployee) {
		return employeeService.createEmployee(apiemployee);
	}
}