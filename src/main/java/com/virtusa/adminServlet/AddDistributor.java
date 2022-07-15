package com.virtusa.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.controller.DistributorController;
import com.virtusa.model.Distributor;


@WebServlet("/AddDistributor")
public class AddDistributor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddDistributor() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String disname=request.getParameter("DisName");
		String dispass=request.getParameter("DisPassword");
		DistributorController dcon=new DistributorController();
		Distributor dis=new Distributor(disname,dispass);
		int res=dcon.insertRecord(dis);
		HttpSession session=request.getSession();
		if(res>0) {
			session.setAttribute("sucMsg", "Added Successfully");
			response.sendRedirect("admin/view_distributor.jsp");
		}else {
			session.setAttribute("errorMsg", "Server Error!");
			response.sendRedirect("admin/view_distributor.jsp");
		}
	}

}
