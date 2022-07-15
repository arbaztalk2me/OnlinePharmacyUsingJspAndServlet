package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.model.Medicine;

public class MedicineService implements MedicineCrud{
	

	@Override
	public int insertRecord(Medicine medicine) {
		int result=0;
		try {
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into medicine(name,price,quantity) values(?,?,?)");
			ps.setString(1,medicine.getMedicineName());
			ps.setDouble(2,medicine.getPrice());
			ps.setInt(3,medicine.getAvailability_in_strips());
			result=ps.executeUpdate();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int updateRecord(Medicine medicine) {
		int result=0;
		try {
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update medicine set name=?,price=?,quantity=? where medicine_id=?");
			ps.setInt(4,medicine.getId());
			ps.setString(1,medicine.getMedicineName());
			ps.setDouble(2,medicine.getPrice());
			ps.setInt(3,medicine.getAvailability_in_strips());
			result=ps.executeUpdate();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int deleteRecord(int id) {
		int result=0;
		try {
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from medicine where medicine_id=?");
			ps.setInt(1,id);
		
			result=ps.executeUpdate();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<Medicine> getAllRecords(){
		
		ArrayList<Medicine> list=new ArrayList<>();
		try {
			Connection con=MysqlConnection.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from medicine");
			while(rs.next()) {
				
				list.add(new Medicine(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
										
			}
			stmt.close();
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
			
		}
	@Override
	public Medicine getMedicineById(int id) {
		
		Medicine medicine=null;
		try{
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from medicine where medicine_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery(); 
			if(rs.next())
				medicine=new Medicine(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
			
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return medicine;
	}
	

}


