package com.virtusa.controller;

import java.util.List;

import com.virtusa.dao.MedicineService;
import com.virtusa.model.Medicine;

public class MedicineController {
	
	MedicineService medicineservice;
	
	public MedicineController() {
		medicineservice=new MedicineService();
	}
	
	public int insertRecord(Medicine medicine) {
		int result=medicineservice.insertRecord(medicine);
		return result;
	}
	
	public int updateRecord(Medicine medicine) {
		int result=medicineservice.updateRecord(medicine);
		return result;
	}
	
	public int deleteRecord(int id) {
		int result=medicineservice.deleteRecord(id);
		return result;
	}
	
	public List<Medicine> getAllRecords(){
		List<Medicine> list=medicineservice.getAllRecords();
		return list;
	}
	
	public Medicine getMedicineById(int id) {
		Medicine medicine=medicineservice.getMedicineById(id);
		return medicine;
	}
	

}

