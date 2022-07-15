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

<title>Update Customer</title>
</head>
<body>
<c:if test="${empty adminObj}">
		<c:redirect url="admin_login.jsp"></c:redirect>
	</c:if>
<%@include file="navbar.jsp" %>
<h3 class="text-center mt-3">Update Customer<i class="fa-solid fa-syringe"></i></h3>
		<div class="d-flex justify-content-center">
			<div class="card" style="width:30rem;">
				
				<div class="card-body">
					<%
						int id=Integer.parseInt(request.getParameter("id"));
						CustomerController con=new CustomerController();
						Customer md=con.getStudentByRollno(id);
					%>
					<form action="../UpdateCustomer" method="post">
						<input type="hidden" value="<%=md.getCustId() %>" name="mid" />
						<input placeholder="Enter customer name" value="<%=md.getCustname() %>" class="form-control my-3" type="text" name="cusname" />
						<input placeholder="Enter Address price" value="<%=md.getAddress() %>" class="form-control my-3" type="text" name="cusAdr" />
						<input placeholder="Enter Mobile No." value="<%=md.getPh_no() %>" class="form-control my-3" type="text" name="cusMon" />
						<input placeholder="Enter password" value="<%=md.getPassword() %>" class="form-control my-3" type="password" name="cusPass" />
						<button type="submit" class="btn btn-success my-3">Update</button>
					</form>
				</div>
			</div>
				</div>
</body>
</html>