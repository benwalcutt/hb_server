package org.softeng.project.hb_server.resources;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.softeng.project.hb_server.model.product;
import org.softeng.project.hb_server.services.ProductService;

@Path("/api0/products")
public class products {
	
	ProductService productService = new ProductService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<product> getAllProducts() {
		System.out.println("Received a request...");
		return productService.getAllProducts();	
	}
	
	@GET
	@Path("/{productid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<product> getProduct(@PathParam("productid") UUID productID) {
		return productService.getProduct(productID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<product> createProduct(JAXBElement<product> apiproduct) {
		return productService.createProduct(apiproduct);
	}
	
	@PUT
	@Path("/{productid}/count/{newcount}")
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProduct(@PathParam("productid") UUID productID, @PathParam("newcount") int newcount) {
		productService.updateProductCount(productID, newcount);
		return "Success";
	}

}
