package com.virtusa.dao;

import com.virtusa.model.Order;

public interface OrderCrud {
	int insertOrder(Order order);
	int deleteOrder(int id);
	Order getOrderById(int id);
	int updateOrder(Order order);
}
