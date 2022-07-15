package com.virtusa.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.controller.CustomerController;
import com.virtusa.model.Customer;


@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddCustomer() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("CusName");
		String pass=request.getParameter("cusPassword");
		String address=request.getParameter("cusAddress");
		String phone=request.getParameter("cusPhone");
		Customer cus=new Customer(name,address,phone,pass);
		CustomerController con=new CustomerController();
		int res=con.insertRecord(cus);
		HttpSession session=request.getSession();
		if(res>0) {
			session.setAttribute("sucMsg", "Added Successfully");
			response.sendRedirect("admin/view_customer.jsp");
		}else {
			session.setAttribute("errorMsg", "Server Error!");
			response.sendRedirect("admin/view_customer.jsp");
		}
	}

}
