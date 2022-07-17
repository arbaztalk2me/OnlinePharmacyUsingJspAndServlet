package com.virtusa.model;

public class ViewOrders {
	
	int order_id;
	String medname;
	String cusname;
	String addr;
	int qty;
	double price;
	String status;
	
	
	
	public ViewOrders(int order_id, String medname, String cusname, String addr, int qty, double price, String status) {
		
		this.order_id = order_id;
		this.medname = medname;
		this.cusname = cusname;
		this.addr = addr;
		this.qty = qty;
		this.price = price;
		this.status = status;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getMedname() {
		return medname;
	}
	public void setMedname(String medname) {
		this.medname = medname;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
