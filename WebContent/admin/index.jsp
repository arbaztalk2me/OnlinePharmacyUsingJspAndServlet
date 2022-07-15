<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome|Admin</title>
<%@include file="../component/link.jsp" %>
<style>
	.cl{
		height:80vh;
	}
	.img-parent{
		width:100%;
		height:100%;
	}
	.img-parent img{
		width:100%;
		height:100%;
	}
</style>
</head>
<body>
	<c:if test="${empty adminObj}">
		<c:redirect url="admin_login.jsp"></c:redirect>
	</c:if>
<%@include file="navbar.jsp" %>
<h3 class="text-center mt-5">weclome To Admin Panel</h3>
<div class="container">
	<div class="row g-0">
		<div class="col-md-6 cl">
			<div class="img-parent">
			<img src="https://img.freepik.com/free-vector/admin-concept-illustration_114360-2139.jpg?w=2000" />
			</div>
			
		</div>
		<div class="col-md-6 d-flex justify-content-center flex-column align-items-center">
			<h3 class="text-center mb-3">Quick Links</h3>
			<h4><a  class="text-decoration-none" href="view_customer.jsp">View Customers</a></h4>
			<h4><a  class="text-decoration-none" href="view_medicine.jsp">View Available Medicines</a></h4>
			<h4><a class="text-decoration-none" href="view_distributor.jsp">View Distributors</a></h4>
		</div>
	</div>
</div>
</body>
</html>