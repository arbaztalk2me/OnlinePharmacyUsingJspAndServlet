package com.virtusa.customer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Customer_Logout")
public class Customer_Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Customer_Logout() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.removeAttribute("cusObj");
		session.setAttribute("sucMsg", "User Logout Successfully");
		response.sendRedirect("customer/customer_login.jsp");
	}

}
