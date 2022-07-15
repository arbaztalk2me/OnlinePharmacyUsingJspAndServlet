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
<title>Update Distributor</title>
</head>
<body>
	<c:if test="${empty adminObj}">
		<c:redirect url="admin_login.jsp"></c:redirect>
	</c:if>
<%@include file="navbar.jsp" %>
<h3 class="text-center mt-3">Update Distributor<i class="fa-solid fa-syringe"></i></h3>
		<div class="d-flex justify-content-center">
			<div class="card" style="width:30rem;">
				
				<div class="card-body">
					<%
						int id=Integer.parseInt(request.getParameter("id"));
						DistributorController mcon=new DistributorController();
						Distributor dis=mcon.getDistributorById(id);
					%>
					<form action="../UpdateDistributor" method="post">
						<input type="hidden" value="<%=dis.getDis_id() %>" name="did" />
						<input placeholder="Enter Distributor name" value="<%=dis.getDis_name() %>" class="form-control my-3" type="text" name="dname" />
						<input placeholder="Enter password" value="<%=dis.getPassword() %>" class="form-control my-3" type="password" name="dpass" />
						
						<button type="submit" class="btn btn-success my-3">Update</button>
					</form>
				</div>
			</div>
				</div>

</body>
</html>