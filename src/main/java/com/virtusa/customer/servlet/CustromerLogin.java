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


@WebServlet("/CustromerLogin")
public class CustromerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CustromerLogin() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerController con=new CustomerController();
		String uname=request.getParameter("customer_username");
		String pass=request.getParameter("customer_password");
		Customer cus=con.loginCustomer(uname, pass);
		HttpSession session=request.getSession();
		
		if(cus!=null) {
			session.setAttribute("cusObj", cus);
			response.sendRedirect("customer/index.jsp");
		}else {
			session.setAttribute("errorMsg", "wrong username and password");
			response.sendRedirect("customer/customer_login.jsp");
		}
	}

}
