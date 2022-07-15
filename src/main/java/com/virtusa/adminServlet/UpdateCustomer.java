package com.virtusa.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.controller.CustomerController;
import com.virtusa.model.Customer;


@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateCustomer() {
        super();

    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("mid"));
		String name=request.getParameter("cusname");
		String add=request.getParameter("cusAdr");
		String pass=request.getParameter("cusMon");
		String ph=request.getParameter("cusPass");
		Customer cus=new Customer(id,name,add,ph,pass);
		CustomerController con=new CustomerController();
		int res=con.updateRecord(cus);
		if(res>0) {
			response.sendRedirect("admin/view_customer.jsp");
		}else {
			response.sendRedirect("admin/view_customer.jsp");
		}
	}

}
