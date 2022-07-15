package com.virtusa.controller;

import java.util.List;

import com.virtusa.dao.AdminService;
import com.virtusa.model.Admin;

public class AdminController {
	AdminService adminService;

	public AdminController() {
		this.adminService = new AdminService();
	}
	
	public int insertData(Admin ad) {
		int result=adminService.insertData(ad);
		return result;
	}

	
	public int updatePass(int id,String newPass) {
		int result=adminService.updatePass(id,newPass);
		return result;
	}

	
	public List<Admin> getallAdmin() {
		List<Admin> list=adminService.getallAdmin();
		return list;
	}

	
	public Admin getAdminById(int id) {
		Admin ad=adminService.getAdminById(id);
		return ad;
	}

	
	public int deleteAdmin(int id) {
		int result=adminService.deleteAdmin(id);
		return result;
	}
	
	public Admin loginAdmin(String username,String password) {
		Admin ad=adminService.adminLogin(username,password);
		return ad;
	}
	
	public int signupAdmin(String username, String password) {
		int result=adminService.signupAdmin(username, password);
		return result;
	}
	
}
