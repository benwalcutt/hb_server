package org.softeng.project.hb_server.services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.softeng.project.hb_server.data.DataService;
import org.softeng.project.hb_server.model.vendor;

public class VendorService {
	
	DataService dataService = new DataService("postgres");
	public final String TABLE_NAME = "vendors";
	ResultSet rs;
	vendor temp_vendor;
	List<vendor> vendorList;
	
	public VendorService() {
		this.rs = null;
		vendorList = new ArrayList<vendor>();
	}

	public List<vendor> getAllVendors() {
		this.rs = dataService.queryAll(TABLE_NAME);
		try {
			while (this.rs.next()) {
				this.vendorList.add(readFromRs(rs));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vendorList;
	}

	public List<vendor> getVendor(UUID vendorID) {
		this.rs = dataService.queryOne(TABLE_NAME, vendorID);
		try {
			while (this.rs.next()) {
				this.vendorList.add(readFromRs(rs));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vendorList;
	}

	public void createVendor(JAXBElement<vendor> apivendor) {
		temp_vendor = apivendor.getValue();
		temp_vendor.setID(UUID.randomUUID());
		temp_vendor.setLast_del_date(new Date());
		
		dataService.insertOneVendor(TABLE_NAME, temp_vendor);
		return;
	}
	
	public void updateVendorName(UUID vendorID, String newName) {
		dataService.updateVendorName(vendorID, newName);
		return;
	}
	
	public void updateVendorEmail(UUID vendorID, String newEmail) {
		dataService.updateVendorEmail(vendorID, newEmail);
		return;
	}
	
	public void updateVendorPhone(UUID vendorID, String newPhone) {
		dataService.updateVendorPhone(vendorID, newPhone);
		return;
	}
	
	public void removeVendor(UUID vendorID) {
		dataService.removeOne(TABLE_NAME, vendorID);
	}
	
	private vendor readFromRs(ResultSet rs) {
		try {
			temp_vendor = new vendor();
			temp_vendor.setID(UUID.fromString(this.rs.getString("ID")));
			temp_vendor.setName(this.rs.getString("name"));
			temp_vendor.setPhone(this.rs.getString("phone"));
			temp_vendor.setEmail(this.rs.getString("email"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return temp_vendor;
	}
}
