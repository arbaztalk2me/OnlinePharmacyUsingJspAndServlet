package com.virtusa.controller;

import java.util.List;

import com.virtusa.dao.CustomerCrud;
import com.virtusa.dao.CustomerService;
import com.virtusa.model.Customer;

public class CustomerController{
	private CustomerService service;
	
	public CustomerController() {
		service=new CustomerService();
	}

	
	public int insertRecord(Customer customer) {
		int result=service.insertRecord(customer);
		return result;
	}


	public int updateRecord(Customer customer) {
		
		int result=service.updateRecord(customer);
		return result;
	}

	
	public int deleteRecord(int id) {
		
		int result=service.deleteRecord(id);
		return result;
	}

	
	public List<Customer> getAllRecords() {
		
		List <Customer> list=service.getAllRecords();
		return list;
	}

	
	public Customer getStudentByRollno(int id) {
		
		Customer customer=service.getCustomerById(id);
		return customer;
	}
	
	public Customer loginCustomer(String username,String password) {
		Customer customer=service.loginCustomer(username, password);
		return customer;
	}
	
	
}
