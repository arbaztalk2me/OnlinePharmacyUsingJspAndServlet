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
<title>Your Orders</title>
</head>
<body>
<body>
<c:if test="${empty cusObj}">
	<c:redirect url="customer_login.jsp"></c:redirect>
</c:if>
<%@include file="navbar.jsp" %>
	<h2 class="text-center my-2">My Orders</h2>
	<c:if test="${not empty sucMsg}">
		<p class="text-center text-dark">${sucMsg}</p>
					<c:remove var="sucMsg" scope="session" />
	</c:if>
	<c:if test="${not empty errorMsg}">
		<p class="text-center text-dark">${errorMsg}</p>
		<c:remove var="errorMsg" scope="session" />
	</c:if>
	<div class="container">
	<div class="card">
		<div class="card-body">
			<table class="table">
  <thead>
    <tr>
      <th scope="col">Order Id</th>
      <th scope="col">Medicine Name</th>
      <th scope="col">Customer Name</th>
      <th scope="col">Address</th>
      <th scope="col">Qty</th>
      <th scope="col">Amount</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  	<%
  	HttpSession sess=request.getSession();
  	Customer customer=(Customer)sess.getAttribute("cusObj");
	ViewOrdersController vo=new ViewOrdersController();
	List<ViewOrders>li=vo.getOrders(customer.getCustId());
	for(ViewOrders ord:li){%>
		<tr>
      <th scope="row"><%=ord.getOrder_id() %></th>
      <%
      	MedicineController mcon=new MedicineController();
      	Medicine md=mcon.getMedicineById(ord.getMid());
      %>
      <td>
      <%=md.getMedicineName() %>
      </td>
      <td><%=ord.getCusname() %></td>
      <td><%=ord.getCusname() %></td>
      <th><%=ord.getQty() %></th>
      <td><%=ord.getPrice() %></td>
      <td><%=ord.getStatus() %></td>
      <td>
      	<a class="btn btn-warning" href="edit_order.jsp?oid=<%=ord.getOrder_id() %>">Edit Order</a>|<a class="btn btn-danger" href="../CancelOrder?id=<%=ord.getOrder_id() %>">Cancel Order</a>
      </td>
    </tr>
	<%}
	%>
    
    
  </tbody>
</table>
		</div>
	
	</div>
	</div>
</body>
</html>