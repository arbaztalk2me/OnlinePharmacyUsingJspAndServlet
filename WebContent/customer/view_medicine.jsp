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
<title>View Medicines</title>
<%@include file="../component/link.jsp" %>
</head>
<body>
<c:if test="${empty cusObj}">
	<c:redirect url="customer_login.jsp"></c:redirect>
</c:if>
<%@include file="navbar.jsp" %>
	<div class="container mt-5">
	<div class="card">
		<div class="card-body">
			<table class="table text-center">
			  <thead>
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">Medicine name</th>
			      <th scope="col">Price</th>
			      <th scope="col">Quantity</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  <%
				MedicineController medcon=new MedicineController();
			  	List<Medicine>list=medcon.getAllRecords();
			  	for(Medicine md:list){%>
			  	<tr>
			      <th scope="row"><%=md.getId() %></th>
			      <td><%=md.getMedicineName() %></td>
			      <td><%=md.getPrice()%></td>
			      <td><%=md.getAvailability_in_strips()%></td>
			      <td><a class="text-decoration-none btn btn-success" href="buy_medicine.jsp?id=<%=md.getId()%>">Order Now</a></td>
			      
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