package org.softeng.project.hb_server.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.softeng.project.hb_server.adapters.UUIDAdapter;

@XmlRootElement
public class transaction {
	@XmlJavaTypeAdapter(UUIDAdapter.class)
	private UUID ID;
	@XmlJavaTypeAdapter(UUIDAdapter.class)
	private UUID emp;
	@XmlJavaTypeAdapter(UUIDAdapter.class)
	private UUID prod;
	private Timestamp date_time;
	
	public transaction() {
		
	}
	
	public transaction(UUID ID, UUID emp, UUID prod, Timestamp date_time) {
		this.ID = ID;
		this.emp = emp;
		this.prod = prod;
		this.date_time = date_time;
	}
	
	public UUID getID() {
		return this.ID;
	}
	public void setID(UUID iD) {
		this.ID = iD;
	}
	public UUID getEmp() {
		return this.emp;
	}
	public void setEmp(UUID emp) {
		this.emp = emp;
	}
	public UUID getProd() {
		return this.prod;
	}
	public void setProd(UUID prod) {
		this.prod = prod;
	}
	public Timestamp getDate_time() {
		return this.date_time;
	}
	public void setDate_time(Timestamp date_time) {
		this.date_time = date_time;
	}
	

}
