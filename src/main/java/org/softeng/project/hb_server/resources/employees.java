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

import org.softeng.project.hb_server.model.employee;
import org.softeng.project.hb_server.services.EmployeeService;

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
	public void createEmployee(JAXBElement<employee> apiemployee) {
		employeeService.createEmployee(apiemployee);
		return;
	}
	
	@PUT
	@Path("/{employeeid}/f_name/{newFirst}")
	public void updateEmployeeFirst(@PathParam("employeeid") UUID employeeID, @PathParam("newFirst") String newFirst) {
		employeeService.updateEmployeeFirst(employeeID, newFirst);
	}
	
	@PUT
	@Path("/{employeeid}/l_name/{newLast}")
	public void updateEmployeeLast(@PathParam("employeeid") UUID employeeID, @PathParam("newFirst") String newLast) {
		employeeService.updateEmployeeFirst(employeeID, newLast);
	}
	
	@PUT
	@Path("/{employeeid}/position/{newPosition}")
	public void updateEmployeePosition(@PathParam("employeeid") UUID employeeID, @PathParam("newPosition") Integer newPosition) {
		employeeService.updateEmployeePosition(employeeID, newPosition);
	}
	
	@DELETE
	@Path("/{employeeid}")
	public void removeEmployee(@PathParam("employeeid") UUID employeeID) {
		employeeService.removeEmployee(employeeID);
	}
}