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


@WebServlet("/CancelOrder")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CancelOrder() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int order_id=Integer.parseInt(request.getParameter("id"));
		
		OrderController oc=new OrderController();
		MedicineController med=new MedicineController();
		OrderController orde=new OrderController();
		
		Order od=orde.getById(order_id);
		int mid=od.getM_id();
		int qty=od.getQty();
		int res=oc.deleteOrder(order_id);
		Medicine medi=med.getMedicineById(mid);
		HttpSession session=request.getSession();
		if(res>0) {
			
			medi.setAvailability_in_strips(medi.getAvailability_in_strips()+qty);
			med.updateRecord(medi);
			session.setAttribute("sucMsg", "Order Cancelled");
			response.sendRedirect("customer/view_orders.jsp");
		}else {
			session.setAttribute("errorMsg", "Soemthing went Wrong");
			response.sendRedirect("customer/view_orders.jsp");
		}
		
	}

}
