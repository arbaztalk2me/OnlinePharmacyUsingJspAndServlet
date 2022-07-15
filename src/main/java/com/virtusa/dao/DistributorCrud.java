package com.virtusa.dao;

import java.util.List;

import com.virtusa.model.Distributor;

public interface DistributorCrud {
	int insertRecord(Distributor dis);
	int updateRecord(Distributor dis);
	int deleteRecord(int dis_id);
	List<Distributor> getAllRecord();
	Distributor getDistributorById(int dis_id);
	Distributor loginDistributor(String name,String password);
	
}
