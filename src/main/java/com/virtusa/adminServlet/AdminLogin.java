package com.virtusa.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.controller.AdminController;
import com.virtusa.model.Admin;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminLogin() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("admin_username");
		String pass=request.getParameter("admin_password");
		
		AdminController adc=new AdminController();
		Admin ad=adc.loginAdmin(uname, pass);
		HttpSession session=request.getSession();
		if(ad!=null) {
			session.setAttribute("adminObj", ad);
			response.sendRedirect("admin/index.jsp");
		}else {
			session.setAttribute("errorMsg", "Invalid email and password");
			response.sendRedirect("admin/admin_login.jsp");
		}
	}

}
