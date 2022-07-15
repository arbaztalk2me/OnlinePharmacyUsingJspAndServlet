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
<%@include file="../component/link.jsp" %>
<title>View Customer</title>
</head>
<body>
<c:if test="${empty adminObj}">
		<c:redirect url="admin_login.jsp"></c:redirect>
	</c:if>
<%@include file="navbar.jsp" %>
<div class="row g-0 mt-4">
		<div class="col-md-4">
			<h3 class="text-center">Add Customer <i class="fa-solid fa-person-circle-plus"></i></h3>
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
					<form action="../AddCustomer" method="post">
						<input placeholder="Enter customer name" class="form-control my-3" type="text" name="CusName" />
						<input placeholder="Enter password" class="form-control my-3" type="password" name="cusPassword" />
						<input placeholder="Enter address" class="form-control my-3" type="text" name="cusAddress" />
						<input placeholder="Enter Mobile No." class="form-control my-3" type="text" name="cusPhone" />
						<button class="btn btn-success my-3">Add It</button>
					</form>
				</div>
			</div>
			
		</div>
		
		<div class="col-md-8">
			<h3 class="text-center">List Of Customers <i class="fa-solid fa-people-group"></i></h3>
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
			      <th scope="col">Customer name</th>
			      <th scope="col">Address</th>
			      <th scope="col">Phone No.</th>
			      <th>Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  <%
				CustomerController cuscon=new CustomerController();
			  	List<Customer>list=cuscon.getAllRecords();
			  	for(Customer md:list){%>
			  	<tr>
			      <th scope="row"><%=md.getCustId() %></th>
			      <td><%=md.getCustname() %></td>
			      <td><%=md.getAddress() %></td>
			      <td><%=md.getPh_no() %></td>
			      <td><a href="edit_customer.jsp?id=<%=md.getCustId() %>" class="btn btn-warning">Edit</a> | <a href="../DeleteCustomer?id=<%=md.getCustId()%>" class="btn btn-danger">Delete</a></td>
			    </tr>
			  	<%}
				%>
			    
			    
			  </tbody>
			</table>
		</div>
	</div>
</body>
</html>