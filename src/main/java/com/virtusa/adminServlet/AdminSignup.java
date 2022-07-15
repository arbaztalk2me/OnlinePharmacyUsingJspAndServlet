package com.virtusa.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.controller.AdminController;


@WebServlet("/AdminSignup")
public class AdminSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminSignup() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("admin_username");
		String pass=request.getParameter("admin_password");
		
		AdminController adc=new AdminController();
		int res=adc.signupAdmin(uname, pass);
		HttpSession session=request.getSession();
		if(res>0) {
			session.setAttribute("sucMsg", "Register Successfully");
			response.sendRedirect("admin/admin_login.jsp");
		}else {
			session.setAttribute("errorMsg", "Something wrong on server");
			response.sendRedirect("admin/admin_signup.jsp");
		}
	}

}
