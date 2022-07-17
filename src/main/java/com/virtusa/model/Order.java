package com.virtusa.model;

public class Order {
	private int order_id;
	private double price;
	private int cust_id;
	private int m_id;
	private int dist_id;
	private int qty;
	private String customer_name;
	private String address;
	private String status;
	
	
	public Order(int order_id, double price, int cust_id, int m_id, int dist_id, int qty, String customer_name,
			String address, String status) {
		super();
		this.order_id = order_id;
		this.price = price;
		this.cust_id = cust_id;
		this.m_id = m_id;
		this.dist_id = dist_id;
		this.qty = qty;
		this.customer_name = customer_name;
		this.address = address;
		this.status = status;
	}

	public Order(double price, int cust_id,int m_id, int dist_id, int qty, String customer_name, String address,String status) {
		
		this.price = price;
		this.cust_id = cust_id;
		this.dist_id = dist_id;
		this.qty = qty;
		this.customer_name = customer_name;
		this.address = address;
		this.m_id=m_id;
		this.status=status;
	}
	
public Order(double price, int cust_id,int m_id, int dist_id, int qty, String customer_name, String address) {
		
		this.price = price;
		this.cust_id = cust_id;
		this.dist_id = dist_id;
		this.qty = qty;
		this.customer_name = customer_name;
		this.address = address;
		this.m_id=m_id;
		
	}
	
	
	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getDist_id() {
		return dist_id;
	}
	public void setDist_id(int dist_id) {
		this.dist_id = dist_id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
