package com.virtusa.model;

public class Customer {
	private int custId;
	private String custname,address,ph_no,password;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getPh_no() {
		return ph_no;
	}
	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custname=" + custname + ", address=" + address + ", ph_no=" + ph_no
				+ ", password=" + password + "]";
	}
	public Customer(int custId, String custname, String address,String ph_no,String password) {
		
		this.custId = custId;
		this.ph_no = ph_no;
		this.custname = custname;
		this.address = address;
		this.password=password;
	}
public Customer( String custname, String address,String ph_no,String password) {
		
		
		this.ph_no = ph_no;
		this.custname = custname;
		this.address = address;
		this.password=password;
	}
}
