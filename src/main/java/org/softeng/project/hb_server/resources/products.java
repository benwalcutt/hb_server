package org.softeng.project.hb_server.resources;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.softeng.project.hb_server.model.product;
import org.softeng.project.hb_server.services.ProductService;

@Path("/api0/products")
public class products {
	
	ProductService productService = new ProductService();
	
	@GET
	@Path("/demo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDemo() {
		
		Response response = Response.status(200)
				.entity("{\"Name\":\"Ben\"}")
				.header("Access-Control-Allow-Origin", "*")
				.header("Content-Type", "application/json")
				.build();
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<product> getAllProducts() {
		System.out.println("Received a request...");
		return productService.getAllProducts();	
	}
	
	@GET
	@Path("/{productid}")
	@Produces(MediaType.APPLICATION_JSON)
	public product getProduct(@PathParam("productid") UUID productID) {
		return productService.getProduct(productID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createProduct(JAXBElement<product> apiproduct) {
		productService.createProduct(apiproduct);
		return "Success.";
	}
	
	@PUT
	@Path("/{productid}/{field}/{newinfo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProduct(@PathParam("productid") UUID productID, @PathParam("field") String field, @PathParam("newinfo") String newInfo) {
		if (productService.updateSingleField(productID, field, newInfo) == true) {
			return "Success";
		}
		else {
			throw new BadRequestException();
		}
	}

	@DELETE
	@Path("/{productid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String removeProduct(@PathParam("productid") UUID productID) {
		productService.removeProduct(productID);
		return "Success.";
	}

}
