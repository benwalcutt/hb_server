package org.softeng.project.hb_server.model;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.softeng.project.hb_server.adapters.UUIDAdapter;

@XmlRootElement
public class employee {
	@XmlJavaTypeAdapter(UUIDAdapter.class)
	private UUID ID;
	private String f_name;
	private String l_name;
	private int position;
	
	public employee() {
		
	}
	
	public employee(UUID ID, String f_name, String l_name, int pos) {
		this.ID = ID;
		this.f_name = f_name;
		this.l_name = l_name;
		this.position = pos;
	}
	
	public UUID getID() {
		return ID;
	}
	public void setID(UUID iD) {
		ID = iD;
	}
	public String getF_Name() {
		return f_name;
	}
	public void setF_Name(String name) {
		this.f_name = name;
	}
	public String getL_Name() {
		return l_name;
	}
	public void setL_Name(String name) {
		this.l_name = name;
	}
	public void setPosition(int pos) {
		this.position = pos;
	}
	public int getPosition() {
		return this.position;
	}
	
}
