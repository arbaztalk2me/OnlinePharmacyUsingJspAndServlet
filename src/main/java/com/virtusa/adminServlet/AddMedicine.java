package com.virtusa.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.controller.MedicineController;
import com.virtusa.model.Medicine;


@WebServlet("/AddMedicine")
public class AddMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddMedicine() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mname=request.getParameter("medName");
		double mprice=Double.parseDouble(request.getParameter("medPrice"));
		int qty=Integer.parseInt(request.getParameter("medQty"));
		Medicine med=new Medicine(mname,mprice,qty);
		MedicineController mcon=new MedicineController();
		int res=mcon.insertRecord(med);
		HttpSession session=request.getSession();
		if(res>0) {
			session.setAttribute("sucMsg", "Added Successfully");
			response.sendRedirect("admin/view_medicine.jsp");
		}else {
			session.setAttribute("errorMsg", "Server Error");
			response.sendRedirect("admin/view_medicine.jsp");
		}
	}

}
