package com.virtusa.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.controller.MedicineController;
import com.virtusa.model.Medicine;


@WebServlet("/UpdateMedicine")
public class UpdateMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateMedicine() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  id=Integer.parseInt(request.getParameter("mid"));
		String mname=request.getParameter("medName");
		double mprice=Double.parseDouble(request.getParameter("medPrice"));
		int mQty=Integer.parseInt(request.getParameter("medQty"));
		Medicine md=new Medicine(id,mname,mprice,mQty);
		MedicineController mcon=new MedicineController();
		int res=mcon.updateRecord(md);
		if(res>0) {
			response.sendRedirect("admin/view_medicine.jsp");
		}else {
			response.sendRedirect("admin/view_medicine.jsp");
		}
	}

}
