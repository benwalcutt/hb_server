package org.softeng.project.hb_server.services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.softeng.project.hb_server.data.DataService;
import org.softeng.project.hb_server.model.employee;


public class EmployeeService {
	DataService dataService = new DataService("postgres");
	ResultSet rs;
	employee temp_employee;
	List<employee> employeeList;
	public final String TABLE_NAME = "employees";
	
	public EmployeeService() {
		this.rs = null;
		employeeList = new ArrayList<employee>();
	}
	
	public List<employee> getAllEmployees() {
		this.rs = dataService.queryAll(TABLE_NAME);		
		try {
			while (this.rs.next()) {
				this.employeeList.add(readFromRs(rs));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return employeeList;
	}

	public List<employee> getEmployee(UUID employeeID) {
		this.rs = dataService.queryOne(TABLE_NAME, employeeID);
		
		try {
			while (this.rs.next()) {
				this.employeeList.add(readFromRs(rs));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return employeeList;
	}

	public List<employee> createEmployee(JAXBElement<employee> apiemployee) {
		temp_employee = apiemployee.getValue();
		temp_employee.setID(UUID.randomUUID());
		dataService.insertOneEmployee(TABLE_NAME, temp_employee);
		this.employeeList.add(temp_employee);
		return this.employeeList;
	}
	
	private employee readFromRs(ResultSet rs) {
		try {
			temp_employee = new employee();
			temp_employee.setID(UUID.fromString(this.rs.getString("ID")));
			temp_employee.setF_Name(this.rs.getString("f_name"));
			temp_employee.setL_Name(this.rs.getString("l_name"));
			temp_employee.setPosition(this.rs.getInt("position"));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return temp_employee;
	}
}
