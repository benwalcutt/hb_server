package org.softeng.project.hb_server.services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.softeng.project.hb_server.data.DataService;
import org.softeng.project.hb_server.model.product;


public class ProductService {
	DataService dataService = new DataService("postgres");
	public final String TABLE_NAME = "products";
	ResultSet rs;
	product tempProduct;
	List<product> productList;
	
	public ProductService() {
		this.rs = null;
		productList = new ArrayList<product>();
	}
	
	public List<product> getAllProducts() {
		this.rs = dataService.queryAll(TABLE_NAME);
		try {
			while (this.rs.next()) {
				this.productList.add(readFromRS(rs));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return productList;
	}

	public List<product> getProduct(UUID productID) {
		this.rs = dataService.queryOne(TABLE_NAME, productID);
		try {
			while (this.rs.next()) {
				this.productList.add(readFromRS(rs));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return productList;
	}

	public List<product> createProduct(JAXBElement<product> apiproduct) {
		tempProduct = apiproduct.getValue();
		tempProduct.setID(UUID.randomUUID());
		dataService.insertOneProduct(TABLE_NAME, tempProduct);
		this.productList.add(tempProduct);
		return this.productList;
	}
	
	public void updateProductCount(UUID productID, int newcount) {
		dataService.updateProductCount(TABLE_NAME, productID, newcount);
		return;
	}
	
	private product readFromRS(ResultSet rs) {
		try {
			tempProduct = new product();
			tempProduct.setID(UUID.fromString(this.rs.getString("ID")));
			tempProduct.setName(this.rs.getString("name"));
			tempProduct.setUnit(this.rs.getString("unit"));
			tempProduct.setCount(this.rs.getInt("count"));
			tempProduct.setCost(this.rs.getDouble("cost"));
			tempProduct.setReorder(this.rs.getInt("reorder"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return tempProduct;
	}
}
