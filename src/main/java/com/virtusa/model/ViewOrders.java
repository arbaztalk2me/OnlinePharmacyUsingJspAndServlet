package com.virtusa.model;

public class ViewOrders {
	
	int order_id;
	double price;
	int cusid;
	int did;
	int mid;
	
	String cusname;
	String add;
	int qty;
	
	String status;
	public ViewOrders(int order_id, int cusid, int mid, int did, String cusname, String add, int qty, double price,
			String status) {
		super();
		this.order_id = order_id;
		this.cusid = cusid;
		this.mid = mid;
		this.did = did;
		this.cusname = cusname;
		this.add = add;
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
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
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
