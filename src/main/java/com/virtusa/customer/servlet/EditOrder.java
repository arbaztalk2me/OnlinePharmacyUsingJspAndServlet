package com.virtusa.customer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.compiler.JspRuntimeContext;

import com.virtusa.controller.MedicineController;
import com.virtusa.controller.OrderController;
import com.virtusa.model.Medicine;
import com.virtusa.model.Order;

@WebServlet("/EditOrder")
public class EditOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditOrder() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int oid=Integer.parseInt(request.getParameter("oid"));
		double price=Double.parseDouble(request.getParameter("price_per_piece"));
		int cusid=Integer.parseInt(request.getParameter("cusid"));
		int disid=Integer.parseInt(request.getParameter("disid"));
		int mid=Integer.parseInt(request.getParameter("mid"));
		String cusname=request.getParameter("cusName");
		String add=request.getParameter("cusaddress");
		int qty=Integer.parseInt(request.getParameter("Enter_Qty_To_Buy"));
		MedicineController mcon=new MedicineController();
		
		Medicine medi=mcon.getMedicineById(mid);
		OrderController oc=new OrderController();
		double amount=qty*price;
		Order od=new Order(oid,amount,cusid,mid,disid,qty,cusname,add,"Not Deliverd");
		int res=oc.updateOrder(od);
		HttpSession session=request.getSession();
		if(res>0) {
			medi.setAvailability_in_strips(medi.getAvailability_in_strips()-qty);
			mcon.updateRecord(medi);
			session.setAttribute("sucMsg", "Update order");
			response.sendRedirect("customer/view_orders.jsp");
		}else {
			medi.setAvailability_in_strips(medi.getAvailability_in_strips()-Integer.parseInt(request.getParameter("tqty")));
			mcon.updateRecord(medi);
			session.setAttribute("errorMsg", "Something went wrong");
			response.sendRedirect("customer/view_orders.jsp");
		}
	}

}
