package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.model.ViewOrders;

public class ViewOrdersService {
	public List<ViewOrders> getOrders(int cusid) {
		Connection con=MysqlConnection.getConnection();
		List<ViewOrders> list=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from orders where cust_id=?");
			ps.setInt(1, cusid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new ViewOrders(rs.getInt(1),rs.getInt(3),rs.getInt(5),rs.getInt(4),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getDouble(2),rs.getString(9)));
			}
		System.out.println(list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
