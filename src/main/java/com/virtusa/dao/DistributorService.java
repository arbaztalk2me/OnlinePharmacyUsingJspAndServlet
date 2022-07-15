package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;


import com.virtusa.model.Distributor;
import com.virtusa.model.ViewDistributorDetails;

public class DistributorService implements DistributorCrud {

	@Override
	public int insertRecord(Distributor dis) {
		int result=0;
		try {
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into distributor(name,password) values(?,?)");
			
			ps.setString(1,dis.getDis_name());
			ps.setString(2,dis.getPassword());
			result=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updateRecord(Distributor dis) {
		
		int result=0;
		try {
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update distributor set name=?,password=? where id=?");
			ps.setString(1,dis.getDis_name());
			ps.setString(2,dis.getPassword());
			ps.setInt(3,dis.getDis_id());
			result=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteRecord(int dis_id) {
		
		int result=0;
		try {
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from distributor where id=?");
			ps.setInt(1,dis_id);
			result=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Distributor> getAllRecord() {
		List<Distributor> list=new ArrayList<>();
		try {
			Connection conn=MysqlConnection.getConnection();
			String sql="select * from distributor";
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				list.add(new Distributor(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Distributor getDistributorById(int dis_id) {
		Distributor dis=null;
		try {
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from distributor where id=?");
			ps.setInt(1,dis_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				dis=new Distributor(rs.getInt(1),rs.getString(2),rs.getString(3));
			
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		return dis;
	}

	@Override
	public Distributor loginDistributor(String name, String password) {
		
		Distributor dis=null;
		try {
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from distributor where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				dis=new Distributor(rs.getInt(1),rs.getString(2),rs.getString(3));
			
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		return dis;
	}
	
	public List<ViewDistributorDetails> getListDetails(){
		List<ViewDistributorDetails>list =list=new ArrayList<>();
		try {
			Connection con=MysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT orders.order_id,distributor.name,orders.qty,orders.customer_name,orders.address,orders.price\r\n"
					+ "FROM distributor\r\n"
					+ "JOIN orders\r\n"
					+ "ON distributor.id = orders.dist_id;");
			while(rs.next()) {
				list.add(new ViewDistributorDetails(rs.getInt(1),rs.getDouble(6),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(2)));
			}
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return list;
	}

}
