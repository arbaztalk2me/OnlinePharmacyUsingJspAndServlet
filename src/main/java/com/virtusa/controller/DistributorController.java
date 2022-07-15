package com.virtusa.controller;

import java.util.List;

import com.virtusa.dao.DistributorService;
import com.virtusa.model.Distributor;
import com.virtusa.model.ViewDistributorDetails;

public class DistributorController {
	DistributorService service;

	public DistributorController() {
		service=new DistributorService();
	}
	
	public int insertRecord(Distributor dis) {
		
		int result=0;
		result=service.insertRecord(dis);
		return result;
	}

	public int updateRecord(Distributor dis) {
		
		int result=0;
		result=service.updateRecord(dis);
		return result;
	}


	public int deleteRecord(int dis_id) {
		
		int result=0;
		result=service.deleteRecord(dis_id);
		return result;
	}

	
	public List<Distributor> getAllRecord() {
		
		List<Distributor> list=service.getAllRecord();
		return list;
	}


	public Distributor getDistributorById(int dis_id) {
		
		
		Distributor dis=service.getDistributorById(dis_id);
		return dis;
	}
	
	public Distributor loginDistributor(String name,String password) {
		Distributor dis=service.loginDistributor(name, password);
		return dis;
	}
	
	public List<ViewDistributorDetails> getListDetails(){
		
		List<ViewDistributorDetails> list=service.getListDetails();
		return list;
		
	}
	
	
}
