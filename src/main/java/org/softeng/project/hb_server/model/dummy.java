package org.softeng.project.hb_server.model;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.softeng.project.hb_server.adapters.UUIDAdapter;

@XmlRootElement
public class dummy {
	
	@XmlJavaTypeAdapter(UUIDAdapter.class)
	private UUID ID;
	
	dummy() {
		
	}
	
	dummy(UUID ID) {
		this.ID = ID;
	}
	
	public UUID getID() {
		return this.ID;
	}
	public void setID(UUID ID) {
		this.ID = ID;
	}
}


