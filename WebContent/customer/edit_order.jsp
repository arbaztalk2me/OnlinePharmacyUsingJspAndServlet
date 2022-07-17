<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.virtusa.model.*"  %>
<%@page import="com.virtusa.controller.*" %>
<%@page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../component/link.jsp" %>
<meta charset="ISO-8859-1">
<title>Edit Your Orders</title>
</head>
<body>
<c:if test="${empty cusObj}">
	<c:redirect url="customer_login.jsp"></c:redirect>
</c:if>
<%@include file="navbar.jsp" %>
<h2 class="text-center my-2">Edit Your Orders</h2>
<div class="d-flex justify-content-center">
	<div class="card" style="width:30rem;">
		<div class="card-body">
			<%
				HttpSession sess=request.getSession();
				
				int oid=Integer.parseInt(request.getParameter("oid"));
				DistributorController dcon=new DistributorController();
				 List<Distributor> dlist=dcon.getAllRecord();
				 OrderController oc=new OrderController();
				Order od=oc.getById(oid);
				MedicineController mcon=new MedicineController();
				Medicine med=mcon.getMedicineById(od.getM_id());
				med.setAvailability_in_strips(med.getAvailability_in_strips()+od.getQty());
				mcon.updateRecord(med);
			%>
			<form action="../EditOrder">
				<input class="form-control my-2"  type="text" value="<%=med.getPrice() %>" readonly  name="price_per_piece" placeholder="price_per_piece"/>
				<input class="form-control my-2"  type="text" value="<%=od.getCust_id() %>" readonly  name="cusid" placeholder="Customer id"/>
				<select class="form-control" name="disid">
				<%
					for(Distributor d:dlist){%>
						<option value="<%=d.getDis_id()%>"><%=d.getDis_name() %></option>
					<%}
				%>
				</select>
				<input type="hidden" value="<%=od.getOrder_id() %>" name="oid"/>
				<input name="tqty" type="hidden" value="<%=od.getQty() %>" />
				<input class="form-control my-2" type="text" value="<%=od.getM_id() %>" name="mid" readonly  placeholder="Medicine id"/>
				<input class="form-control my-2" type="text" value="<%=od.getCustomer_name() %>" readonly  name="cusName" placeholder="Your name"/>
				<input class="form-control my-2" type="text" value="<%=od.getAddress() %>" readonly name="cusaddress"  placeholder="Address"/>
				<input class="form-control my-2" type="text" value="<%=od.getQty() %>" name="Enter_Qty_To_Buy"  placeholder="Enter_Qty_To_Buy"/>
				<button class="btn btn-success" type="submit">Customise Order Now</button>
			</form>
		</div>
	</div>
	</div>
</body>
</html>