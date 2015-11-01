package org.softeng.project.hb_server.adapters;

import java.util.UUID;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UUIDAdapter extends XmlAdapter<String, UUID>{
	@Override
	public String marshal(UUID ID) throws Exception {
		return ID.toString();
	}
	
	@Override
	public UUID unmarshal(String val) throws Exception {
		return UUID.fromString(val);
	}
}
