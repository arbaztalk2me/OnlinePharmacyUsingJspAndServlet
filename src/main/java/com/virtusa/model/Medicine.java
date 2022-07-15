package com.virtusa.model;

public class Medicine {
	private int id;
	private String medicinename;
	private double price;
	private int availability_in_strips;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getMedicineName() {
		return medicinename;
	}
	public void setMedicineName(String medicinename) {
		this.medicinename=medicinename;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public int getAvailability_in_strips() {
		return availability_in_strips;
	}
	public void setAvailability_in_strips(int availability_in_strips) {
		this.availability_in_strips=availability_in_strips;
	}
	public Medicine(int id,String medicinename,double price,int availability_in_strips) {
		super();
		this.id=id;
		this.medicinename=medicinename;
		this.price=price;
		this.availability_in_strips= availability_in_strips;
	}
	public Medicine(String medicinename,double price,int availability_in_strips) {
		
		this.medicinename=medicinename;
		this.price=price;
		this.availability_in_strips= availability_in_strips;
	}
	

}

