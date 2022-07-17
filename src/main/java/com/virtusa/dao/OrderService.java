package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.virtusa.model.Order;

public class OrderService implements OrderCrud {

	@Override
	public int insertOrder(Order order) {
		int result=0;
		try {
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into orders(price,cust_id,dist_id,m_id,customer_name,address,qty,status)values(?,?,?,?,?,?,?,?)");
			ps.setDouble(1, order.getPrice());
			ps.setInt(2, order.getCust_id());
			ps.setInt(3, order.getDist_id());
			ps.setInt(4, order.getM_id());
			ps.setString(5, order.getCustomer_name());
			ps.setString(6, order.getAddress());
			ps.setInt(7, order.getQty());
			ps.setString(8, "Not Delivered");
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return result;
	}

	@Override
	public int deleteOrder(int id) {
		int result=0;
		try {
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from orders where order_id=?");
			ps.setInt(1, id);
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Order getOrderById(int id) {
		Order order = null;
		try {
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from orders where order_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				order=new Order(rs.getInt(1),rs.getDouble(2),rs.getInt(3),rs.getInt(5),rs.getInt(4),rs.getInt(8),rs.getString(6),rs.getString(7),rs.getString(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public int updateOrder(Order order) {
		int result=0;
		try {
			Connection con=MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update orders set price=?,cust_id=?,dist_id=?,m_id=?,customer_name=?,address=?,qty=? where order_id=?");
			ps.setDouble(1, order.getPrice());
			ps.setInt(2, order.getCust_id());
			ps.setInt(3, order.getDist_id());
			ps.setInt(4, order.getM_id());
			ps.setString(5, order.getCustomer_name());
			ps.setString(6, order.getAddress());
			ps.setInt(7, order.getQty());
			ps.setInt(8, order.getOrder_id());
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	

}
