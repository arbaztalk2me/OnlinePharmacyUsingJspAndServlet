package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.model.Admin;

public class AdminService implements AdminCrud {

	@Override
	public int insertData(Admin ad) {
		int result=0;
		try {
			Connection conn=MysqlConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into admin(id,name,password)values(?,?,?)");
			ps.setInt(1, ad.getId());
			ps.setString(2, ad.getName());
			ps.setString(3, ad.getPassword());
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updatePass(int id,String newPass) {
		
		int result=0;
		try {
			Connection conn=MysqlConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("update admin set password=? where id=?");
			
			ps.setString(1, newPass);
			ps.setInt(2,id);
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Admin> getallAdmin() {
		List<Admin> list=new ArrayList<>();
		try {
			Connection conn=MysqlConnection.getConnection();
			String sql="select * from admin";
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				//Admin ad=new Admin(rs.getInt(1),rs.getString(2),rs.getString(3));
				//list.add(ad);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Admin getAdminById(int id) {
		Admin ad=null;
		
		try {
			
			Connection conn=MysqlConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from admin where id=?");
			
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ad=new Admin(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ad;
	}

	@Override
	public int deleteAdmin(int id) {
		
		int result=0;
		try {
			Connection conn=MysqlConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("delete from admin where id=?");
			ps.setInt(1,id);
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Admin adminLogin(String name, String password) {
		
		Admin ad=null;
		
		try {
			
			Connection conn=MysqlConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from admin where name=? and password=?");
			
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ad=new Admin(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ad;
	}

	@Override
	public int signupAdmin(String username, String password) {
		int result=0;
		try {
			Connection conn=MysqlConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into admin(name,password)values(?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
