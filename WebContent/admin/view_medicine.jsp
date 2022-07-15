<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@page import="com.virtusa.model.*" %>
<%@page import="com.virtusa.controller.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Medicine</title>
<%@include file="../component/link.jsp" %>
</head>
<body>
	<c:if test="${empty adminObj}">
		<c:redirect url="admin_login.jsp"></c:redirect>
	</c:if>
<%@include file="navbar.jsp" %>
	<div class="row g-0 mt-4">
		<div class="col-md-4">
			<h3 class="text-center">Add Meicine<i class="fa-solid fa-syringe"></i></h3>
			<div class="card">
				<div class="card-header">
					<c:if test="${not empty sucMsg }">
					<p class="text-center text-dark">${sucMsg}</p>
					<c:remove var="sucMsg" scope="session" />
				</c:if>
		
				<c:if test="${not empty errorMsg }">
					<p class="text-center text-dark">${errorMsg}</p>
					<c:remove var="errorMsg" scope="session" />
				</c:if>
				</div>
				<div class="card-body">
					<form action="../AddMedicine">
						<input placeholder="Enter medicine name" class="form-control my-3" type="text" name="medName" />
						<input placeholder="Enter medicine price" class="form-control my-3" type="text" name="medPrice" />
						<input placeholder="Enter Quantity" class="form-control my-3" type="text" name="medQty" />
						<button type="submit" class="btn btn-success my-3">Add It</button>
					</form>
				</div>
			</div>
			
		</div>
		
		<div class="col-md-8">
			<h3 class="text-center">Medicine Availability <i class="fa-solid fa-capsules"></i></h3>
			<h4 class="text-center text-danger">
				<c:if test="${not empty sucMsg1 }">
					<p class="text-center text-dark">${sucMsg1}</p>
					<c:remove var="sucMsg1" scope="session" />
				</c:if>
		
				<c:if test="${not empty errorMsg1 }">
					<p class="text-center text-dark">${errorMsg1}</p>
					<c:remove var="errorMsg1" scope="session" />
				</c:if>
			</h4>
			<table class="table text-center">
			  <thead>
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">Medicine name</th>
			      <th scope="col">Price</th>
			      <th scope="col">Quantity</th>
			      <th>Action</th>
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
			      <td><a href="edit_medicine.jsp?id=<%=md.getId() %>" class="btn btn-warning" >Edit</a> | <a href="../DeleteMedicine?id=<%=md.getId()%>" class="btn btn-danger">Delete</a></td>
			    </tr>
			  	<%}
				%>
			    
			    
			  </tbody>
			</table>
		</div>
	</div>
	
		

</body>
</html>