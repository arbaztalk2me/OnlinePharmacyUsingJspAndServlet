package com.virtusa.dao;

import java.util.List;

import com.virtusa.model.Admin;

public interface AdminCrud {
	int insertData(Admin ad);
	int deleteAdmin(int id);
	int updatePass(int id,String newPass);
	List<Admin> getallAdmin();
	Admin getAdminById(int id);
	Admin adminLogin(String username,String password);
	int signupAdmin(String username,String password);
}
