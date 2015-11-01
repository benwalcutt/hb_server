package org.softeng.project.hb_server.model;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.softeng.project.hb_server.adapters.UUIDAdapter;

@XmlRootElement
public class product {
	@XmlJavaTypeAdapter(UUIDAdapter.class)
	private UUID ID;
	private String name;
	private String unit;
	private Integer count;
	private Double cost;
	private Integer reorder;
	
	public product() {
		
	}
	
	public product(UUID iD, String name, String unit, Integer count,
			Double cost, Integer reorder) {
		ID = iD;
		this.name = name;
		this.unit = unit;
		this.count = count;
		this.cost = cost;
		this.reorder = reorder;
	}
	
	public UUID getID() {
		return ID;
	}
	public void setID(UUID iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getReorder() {
		return reorder;
	}

	public void setReorder(Integer reorder) {
		this.reorder = reorder;
	}
	
}
