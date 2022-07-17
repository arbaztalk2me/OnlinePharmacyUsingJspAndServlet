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
<meta charset="ISO-8859-1">
<%@include file="../component/link.jsp" %>
<title>Buy Medicine</title>
</head>
<body>
<c:if test="${empty cusObj}">
	<c:redirect url="customer_login.jsp"></c:redirect>
</c:if>
<%@include file="navbar.jsp" %>
	<h3 class="text-center my-3">Buy Medicine</h3>
	<div class="d-flex justify-content-center">
	<div class="card" style="width:30rem;">
		<div class="card-body">
			<%
				HttpSession sess=request.getSession();
				Customer cuss=(Customer)sess.getAttribute("cusObj");
				int id=Integer.parseInt(request.getParameter("id"));
				MedicineController mcon=new MedicineController();
				Medicine md=mcon.getMedicineById(id);
				DistributorController dcon=new DistributorController();
				 List<Distributor> dlist=dcon.getAllRecord();
				
			%>
			<form action="../BuyMedicine">
				<input class="form-control my-2"  type="text" value="<%=md.getPrice() %>" readonly  name="price_per_piece" placeholder="price_per_piece"/>
				<input class="form-control my-2"  type="text" value="<%=cus.getCustId() %>" readonly  name="cusid" placeholder="Customer id"/>
				<select class="form-control" name="disid">
				<%
					for(Distributor d:dlist){%>
						<option value="<%=d.getDis_id()%>"><%=d.getDis_name() %></option>
					<%}
				%>
				</select>
				<input class="form-control my-2" type="text" value="<%=md.getId() %>" name="mid" readonly  placeholder="Medicine id"/>
				<input class="form-control my-2" type="text" value="<%=cus.getCustname() %>" readonly  name="cusName" placeholder="Your name"/>
				<input class="form-control my-2" type="text" value="<%=cus.getAddress() %>" readonly name="cusaddress"  placeholder="Address"/>
				<input class="form-control my-2" type="text" value="" name="Enter_Qty_To_Buy"  placeholder="Enter_Qty_To_Buy"/>
				<button class="btn btn-success" type="submit">Buy Now</button>
			</form>
		</div>
	</div>
	</div>
</body>
</html>