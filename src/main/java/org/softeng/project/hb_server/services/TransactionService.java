package org.softeng.project.hb_server.services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.softeng.project.hb_server.data.DataService;
import org.softeng.project.hb_server.model.transaction;

public class TransactionService {
	DataService dataService = new DataService("postgres");
	ResultSet rs;
	transaction temp_transaction;
	List<transaction> transactionList;
	public final String TABLE_NAME = "transactions";
	
	public TransactionService() {
		this.rs = null;
		transactionList = new ArrayList<transaction>();
	}

	public List<transaction> getAllTransactions() {
		this.rs = dataService.queryAll(TABLE_NAME);
		try {
			while (this.rs.next()) {
				this.transactionList.add(readFromRs(rs));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return transactionList;
	}

	public transaction getTransaction(UUID transactionID) {
		this.rs = dataService.queryOne(TABLE_NAME, transactionID);		
		return readFromRs(rs);
	}

	public void createTransaction(JAXBElement<transaction> apitransaction) {
		apitransaction.getValue().setID(UUID.randomUUID());
		dataService.insertOneTransaction(TABLE_NAME, apitransaction.getValue());
		return;
	}
	
	private transaction readFromRs(ResultSet rs) {
		try {
			temp_transaction = new transaction();
			temp_transaction.setID(UUID.fromString(this.rs.getString("ID")));
			temp_transaction.setEmp(UUID.fromString(this.rs.getString("emp_ID")));
			temp_transaction.setProd(UUID.fromString(this.rs.getString("product_ID")));
			temp_transaction.setDate_time(this.rs.getDate(4));
		} catch (Exception e) {
			System.out.println(e);
		}
		return temp_transaction;
	}
}
