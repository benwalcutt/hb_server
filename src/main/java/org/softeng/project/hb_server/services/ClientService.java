package org.softeng.project.hb_server.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.softeng.project.hb_server.data.DataService;
import org.softeng.project.hb_server.model.client;

public class ClientService {
	DataService dataService = new DataService("postgres");
	ResultSet rs;
	client temp_client;
	List<client> clientList;

	public final String TABLE_NAME = "clients";
	
	public ClientService() {
		this.rs = null;
		clientList = new ArrayList();
	}

	@SuppressWarnings("null")
	public List<client> getAllClients() {
		this.rs = dataService.queryAll(TABLE_NAME);
		try {
			while (this.rs.next()) {
				this.clientList.add(readFromRs(rs));
			}	
		} catch (Exception e) {
			System.out.println(e);
		}
		return clientList;
	}

	public List<client> getClient(UUID clientID) {
		this.rs = dataService.queryOne(TABLE_NAME, clientID);
		try {
			while (this.rs.next()) {
				this.clientList.add(readFromRs(rs));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return clientList;
	}

	public List<client> createClient(JAXBElement<client> apiclient) {
		temp_client = apiclient.getValue();
		temp_client.setID(UUID.randomUUID());
		
		dataService.insertOneClient(TABLE_NAME, temp_client);
		this.clientList.add(temp_client);
		return this.clientList;
	}
	
	private client readFromRs(ResultSet rs) {
		try {
			temp_client = new client();
			temp_client.setID(UUID.fromString(this.rs.getString("ID")));
			temp_client.setName(this.rs.getString("name"));
			temp_client.setAddress(this.rs.getString("address"));
			temp_client.setCity(this.rs.getString("city"));
			temp_client.setState(this.rs.getString("state"));
			temp_client.setZip(this.rs.getString("zip"));
			temp_client.setPhone(this.rs.getString("phone"));
			temp_client.setEmail(this.rs.getString("email"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return temp_client;
	}
}
