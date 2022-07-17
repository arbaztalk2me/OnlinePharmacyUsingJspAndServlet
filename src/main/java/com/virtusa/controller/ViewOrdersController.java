package com.virtusa.controller;

import java.util.List;

import com.virtusa.dao.ViewOrdersService;
import com.virtusa.model.ViewOrders;

public class ViewOrdersController {
	private ViewOrdersService service;

	public ViewOrdersController() {
		service=new ViewOrdersService();
	}
	
	public List<ViewOrders> getOrders(int id){
		List<ViewOrders> list=service.getOrders(id);
		return list;
	}
	
}
