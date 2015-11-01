package org.softeng.project.hb_server.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.softeng.project.hb_server.data.DataService;
import org.softeng.project.hb_server.model.dummy;


public class DummyService {
	DataService dataService = new DataService("postgres");
	public final String TABLE_NAME = "dummy";
	ResultSet rs;
	dummy tempDummy;
	List<dummy> dummyList;
	
	public DummyService() {
		this.rs = null;
		dummyList = new ArrayList();
	}
	
	@SuppressWarnings("null")
	public List<dummy> getAllDummys() {
		this.rs = dataService.queryAll(TABLE_NAME);
		try {
			while (this.rs.next()) {
				this.dummyList.add(readFromRS(rs));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return dummyList;
	}

	public List<dummy> getDummy(UUID dummyID) {
		this.rs = dataService.queryOne(TABLE_NAME, dummyID);
		try {
			while (this.rs.next()) {
				this.dummyList.add(readFromRS(rs));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return dummyList;
	}

	public List<dummy> createDummy(JAXBElement<dummy> apidummy) {
		//tempDummy.setID(UUID.randomUUID());
		dataService.insertOneDummy(TABLE_NAME, apidummy.getValue());
		this.dummyList.add(apidummy.getValue());
		return this.dummyList;
	}
	
	private dummy readFromRS(ResultSet rs) {
		try {
			this.tempDummy.setID(UUID.fromString(this.rs.getString("ID")));
		} catch (Exception e) {
			System.out.println(e);
		}
		return tempDummy;
	}
}
