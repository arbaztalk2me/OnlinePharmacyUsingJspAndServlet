<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome|User</title>
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
<%@include file="navbar.jsp" %>
<h2 class="text-center text-dark">Welcome Customer Panel</h2>
				<c:if test="${not empty sucMsg }">
					<p class="text-center text-dark">${sucMsg}</p>
					<c:remove var="sucMsg" scope="session" />
				</c:if>
		
				<c:if test="${not empty errorMsg }">
					<p class="text-center text-dark">${errorMsg}</p>
					<c:remove var="errorMsg" scope="session" />
				</c:if>
<div class="container">
	<div class="row g-0">
		<div class="col-md-6 cl">
			<div class="img-parent">
			<img src="https://www.salesforce.com/blog/wp-content/uploads/sites/2/2019/07/customer-experience-header.jpg?w=888" />
			</div>
			
		</div>
		<div class="col-md-6 d-flex justify-content-center flex-column align-items-center">
			<h3 class="text-center mb-3">Quick Links</h3>
			<h4><a  class="text-decoration-none" href="view_medicine.jsp">View Medicines</a></h4>
			<h4><a  class="text-decoration-none" href="view_orders.jsp">View Orders</a></h4>
			
		</div>
	</div>
</div>
</body>
</html>