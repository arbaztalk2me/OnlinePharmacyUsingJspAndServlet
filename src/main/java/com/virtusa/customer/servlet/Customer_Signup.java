package com.virtusa.customer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.controller.CustomerController;
import com.virtusa.model.Customer;


@WebServlet("/Customer_Signup")
public class Customer_Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Customer_Signup() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("customer_username");
		String pass=request.getParameter("customer_password");
		String mob=request.getParameter("customer_phone");
		String add=request.getParameter("customer_address");
		Customer cus=new Customer(name,add,mob,pass);
		CustomerController con=new CustomerController();
		int res=con.insertRecord(cus);
		HttpSession session=request.getSession();
		if(res>0) {
			session.setAttribute("sucMsg", "signup success!");
			response.sendRedirect("customer/customer_login.jsp");
		}else {
			session.setAttribute("errorMsg", "something went wrong on server!!");
			response.sendRedirect("customer/customer_signup.jsp");
		}
	}

}
