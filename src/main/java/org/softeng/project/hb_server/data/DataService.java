package org.softeng.project.hb_server.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.softeng.project.hb_server.model.client;
import org.softeng.project.hb_server.model.dummy;
import org.softeng.project.hb_server.model.employee;
import org.softeng.project.hb_server.model.event;
import org.softeng.project.hb_server.model.product;
import org.softeng.project.hb_server.model.transaction;
import org.softeng.project.hb_server.model.vendor;

public class DataService {
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	Statement stmt;
	String query;
	java.util.Date today;
	
	private final String INSERT_PREAMBLE = "INSERT INTO ";
	private final String SELECT_PREAMBLE = "SELECT * FROM ";
	private final String UPDATE_PREAMBLE = "UPDATE ";
	private final String SET_PREAMBLE = " SET ";
	
	public DataService(String user) {
		this.rs = null;
		this.ps = null;
		this.stmt = null;
		this.query = "";
		this.today = new java.util.Date();
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", user, "default");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ResultSet queryAll(String table) {
		try {
			this.query = SELECT_PREAMBLE + table + ";";
			this.stmt = this.con.createStatement();
			this.rs = this.stmt.executeQuery(this.query);
		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	public ResultSet queryOne(String table, UUID productID) {
		try {
			this.query = SELECT_PREAMBLE + table + " WHERE \"ID\" = '" + productID + "';";
			this.stmt = this.con.createStatement();
			this.rs = this.stmt.executeQuery(this.query);
		} catch (Exception e) {
			System.out.println(e);
		}
		return this.rs;
	}

	public void insertOneProduct(String table, product tempProduct) {
		this.query = INSERT_PREAMBLE + table + " VALUES(?, ?, ?, ?, ?, ?)";
		try {
			this.ps = this.con.prepareStatement(this.query);
			this.ps.setObject(1, tempProduct.getID());
			this.ps.setString(2, tempProduct.getName());
			this.ps.setObject(3, tempProduct.getUnit());
			this.ps.setObject(4, tempProduct.getCount());
			this.ps.setObject(5, tempProduct.getCost());
			this.ps.setObject(6, tempProduct.getReorder());
			this.ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return;
	}

	public void insertOneEmployee(String table, employee temp_employee) {
		this.query = INSERT_PREAMBLE + table + " VALUES(?, ?, ?, ?)";
		try {
			this.ps = this.con.prepareStatement(this.query);
			this.ps.setObject(1, temp_employee.getID());
			this.ps.setString(2, temp_employee.getF_Name());
			this.ps.setString(3, temp_employee.getL_Name());
			this.ps.setInt(4, temp_employee.getPosition());
			this.ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return;
	}
	
	public void insertOneTransaction(String table, transaction temp_transaction) {
		this.query = INSERT_PREAMBLE + table + " VALUES(?, ?, ?, ?)";
		try {
			this.ps = this.con.prepareStatement(this.query);
			this.ps.setObject(1, temp_transaction.getID());
			this.ps.setObject(2, temp_transaction.getEmp());
			this.ps.setObject(3, temp_transaction.getProd());
			this.ps.setObject(4, new Date(today.getTime()));
			this.ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("bad things");
			System.out.println(e);
		}
		return;
	}

	public void insertOneClient(String table, client temp_client) {
		this.query = INSERT_PREAMBLE + table + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			this.ps = this.con.prepareStatement(this.query);
			this.ps.setObject(1, temp_client.getID());
			this.ps.setObject(2, temp_client.getName());
			this.ps.setObject(3, temp_client.getAddress());
			this.ps.setObject(4, temp_client.getCity());
			this.ps.setObject(5, temp_client.getState());
			this.ps.setObject(6, temp_client.getZip());
			this.ps.setObject(7, temp_client.getPhone());
			this.ps.setObject(8, temp_client.getEmail());
			this.ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("bad things");
			System.out.println(e);
		}
		return;
	}

	public void insertOneEvent(String table, event temp_event) {
		this.query = INSERT_PREAMBLE + table + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			this.ps = this.con.prepareStatement(this.query);
			this.ps.setObject(1, temp_event.getID());
			this.ps.setObject(2, new Date(today.getTime()));
			this.ps.setObject(3, temp_event.getClient_ID());
			this.ps.setObject(4, temp_event.getAddress());
			this.ps.setObject(5, temp_event.getCity());
			this.ps.setObject(6, temp_event.getState());
			this.ps.setObject(7, temp_event.getZip());
			this.ps.setObject(8, new Date(today.getTime()));
			this.ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return;
	}

	public void insertOneVendor(String table, vendor temp_vendor) {
		this.query = INSERT_PREAMBLE + table + " VALUES (?, ?, ?, ?, ?)";
		try {
			this.ps = this.con.prepareStatement(this.query);
			this.ps.setObject(1, temp_vendor.getID());
			this.ps.setObject(2, temp_vendor.getName());
			this.ps.setObject(3, temp_vendor.getPhone());
			this.ps.setObject(4, temp_vendor.getEmail());
			this.ps.setObject(5, new Date(today.getTime()));
			
			this.ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return;
	}

	public void insertOneDummy(String table, dummy tempDummy) {
		this.query = INSERT_PREAMBLE + table + " VALUES (?)";
		System.out.println("from insert dummy: ");
		System.out.println(tempDummy.getID());
		try {
			this.ps = this.con.prepareStatement(this.query);
			this.ps.setObject(1, tempDummy.getID());
			this.ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return;
	}

	public void updateProductCount(String table, UUID productID, Integer newcount) {
		this.query = "UPDATE " + table + " SET count=" + newcount.toString() + " WHERE \"ID\"=\'" + productID.toString() + "\';";
		try {
			this.stmt = this.con.createStatement();
			this.stmt.execute(this.query);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
