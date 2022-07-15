package com.virtusa.dao;

import java.util.List;

import com.virtusa.model.Customer;

public interface CustomerCrud {
	int insertRecord(Customer customer);
	int updateRecord(Customer customer);
	int deleteRecord(int cust_id);
	List<Customer> getAllRecords();
	Customer getCustomerById(int cust_id);
	Customer loginCustomer(String username,String password);
}
