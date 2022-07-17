package com.virtusa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.model.ViewOrders;

public class ViewOrdersService {
	public List<ViewOrders> getOrders() {
		Connection con=MysqlConnection.getConnection();
		List<ViewOrders> list=new ArrayList<>();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select orders.order_id,medicine.name,orders.customer_name,orders.address,orders.qty,orders.price,orders.status\r\n"
					+ "from medicine join orders on medicine.medicine_id=orders.m_id");
			while(rs.next()) {
				list.add(new ViewOrders(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6),rs.getString(7)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
