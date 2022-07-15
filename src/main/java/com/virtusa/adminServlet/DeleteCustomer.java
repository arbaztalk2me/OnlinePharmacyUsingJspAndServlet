package com.virtusa.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.controller.CustomerController;


@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		CustomerController con=new CustomerController();
		int res=con.deleteRecord(id);
		HttpSession session=request.getSession();
		if(res>0) {
			session.setAttribute("sucMsg1", "Deleted Successfully");
			response.sendRedirect("admin/view_customer.jsp");
		}else {
			session.setAttribute("errorMsg1", "Server Error");
			response.sendRedirect("admin/view_customer.jsp");
		}
	}

}
