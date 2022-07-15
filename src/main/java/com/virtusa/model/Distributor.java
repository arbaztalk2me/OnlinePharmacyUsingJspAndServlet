package com.virtusa.model;

public class Distributor {
	private int dis_id;
	private String dis_name;
	private String password;
	
	public Distributor(int dis_id, String dis_name, String password) {
		
		this.dis_id = dis_id;
		this.dis_name = dis_name;
		this.password = password;
	}
public Distributor( String dis_name, String password) {
		
		
		this.dis_name = dis_name;
		this.password = password;
	}
	public int getDis_id() {
		return dis_id;
	}
	public void setDis_id(int dis_id) {
		this.dis_id = dis_id;
	}
	public String getDis_name() {
		return dis_name;
	}
	public void setDis_name(String dis_name) {
		this.dis_name = dis_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
