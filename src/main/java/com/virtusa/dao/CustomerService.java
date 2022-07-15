package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.model.Customer;

public class CustomerService implements CustomerCrud{

	@Override
	public int insertRecord(Customer customer) {
		int result=0;
		try{
			Connection con=MysqlConnection.getConnection();
			
			//To insert records 
			PreparedStatement ps=con.prepareStatement("insert into customer(name,password,address,phno) values(?,?,?,?)");
			
			ps.setString(1,customer.getCustname());
			ps.setString(2,customer.getPassword());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getPh_no());
			
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return result;
	}

	@Override
	public int updateRecord(Customer customer) {
		int result=0;
		try{
			Connection con=MysqlConnection.getConnection();
			
			
			//To insert records 
			PreparedStatement ps=con.prepareStatement("update customer set name=?,password=?,phno=?,address=? where id=?");
			ps.setInt(5,customer.getCustId());
			ps.setString(1,customer.getCustname());
			ps.setString(2,customer.getPassword());
			ps.setString(4, customer.getAddress());
			ps.setString(3, customer.getPh_no());
			
			result=ps.executeUpdate();
			con.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public int deleteRecord(int id) {
		int result=0;
		try{
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from customer where id=?");
			
			ps.setInt(1,id);
			
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public List<Customer> getAllRecords() {
		
		ArrayList<Customer> list=new ArrayList<>();
		try{
			Connection con=MysqlConnection.getConnection();
		//To get all Records
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from customer");
		//Add all Records in ArrayList		
						
		while(rs.next()) {
			
			list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(3),rs.getString(5)));
			
					
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
	public Customer getCustomerById(int Id) {
		
		Customer customer=null;
		try{
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from customer where id=?");
			ps.setInt(1, Id);
			ResultSet rs=ps.executeQuery(); 
			if(rs.next())
				customer=new Customer(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(3));
			
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return customer;
	}

	@Override
	public Customer loginCustomer(String username, String password) {
		Customer customer=null;
		try{
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from customer where name=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery(); 
			if(rs.next())
				customer=new Customer(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(3),rs.getString(5));
			
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return customer;
	}

}
