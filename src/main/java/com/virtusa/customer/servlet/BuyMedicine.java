package com.virtusa.customer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.controller.MedicineController;
import com.virtusa.controller.OrderController;
import com.virtusa.model.Medicine;
import com.virtusa.model.Order;


@WebServlet("/BuyMedicine")
public class BuyMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BuyMedicine() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double price=Double.parseDouble(request.getParameter("price_per_piece"));
		int cid=Integer.parseInt(request.getParameter("cusid"));
		int mid=Integer.parseInt(request.getParameter("mid"));
		int did=Integer.parseInt(request.getParameter("disid"));
		int Qty=Integer.parseInt(request.getParameter("Enter_Qty_To_Buy"));
		String cusName=request.getParameter("cusName");
		String addres=request.getParameter("cusaddress");
		
		OrderController oc=new OrderController();
		MedicineController med=new MedicineController();
		Medicine m=med.getMedicineById(mid);
		double ocprice=price*Qty;
		Order od=new Order(ocprice,cid,mid,did,Qty,cusName,addres);
		int res=oc.insertOrder(od);
		HttpSession session=request.getSession();
		
		if(res>0) {
			m.setAvailability_in_strips(m.getAvailability_in_strips()-Qty);
			med.updateRecord(m);
			session.setAttribute("sucMsg", "order successfully");
			response.sendRedirect("customer/index.jsp");
		}else {
			session.setAttribute("errorMsg", "Something went wrong");
			response.sendRedirect("customer/index.jsp");
		}
	}

}
