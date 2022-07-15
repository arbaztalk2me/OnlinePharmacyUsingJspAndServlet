package com.virtusa.dao;

import java.util.List;

import com.virtusa.model.Medicine;

public interface MedicineCrud {
	
	int insertRecord(Medicine medicine);
	int updateRecord(Medicine medicine);
	int deleteRecord(int id);
	List<Medicine> getAllRecords();
	Medicine getMedicineById(int id);

}
