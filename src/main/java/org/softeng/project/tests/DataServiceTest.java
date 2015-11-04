package org.softeng.project.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.softeng.project.hb_server.model.product;
import org.softeng.project.hb_server.services.ProductService;

public class DataServiceTest {
	
	int count = 0;
	ProductService testedService = new ProductService();
	List<product> dummyList = new ArrayList<product>();

	@Test
	public void test() {
		assertNotEquals("Count should not be 0.", 0, this.execute());
	}

	private Object execute() {
		dummyList = testedService.getAllProducts();
		return dummyList.size();
	}

}
