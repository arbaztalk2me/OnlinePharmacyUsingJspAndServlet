package com.virtusa.controller;

import com.virtusa.dao.OrderService;
import com.virtusa.model.Order;

public class OrderController {
	private OrderService orderService;

	public OrderController() {
		orderService=new OrderService();
	}
	
	public int insertOrder(Order order) {
		int result=orderService.insertOrder(order);
		return result;
	}
	
	public int deleteOrder(int id) {
		int result=orderService.deleteOrder(id);
		return result;
	}
	
	public Order getById(int id) {
		Order od=orderService.getOrderById(id);
		return od;
	}
	public int updateOrder(Order od) {
		return orderService.updateOrder(od);
	}
}
