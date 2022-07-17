<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Signup</title>
<%@include file="../component/link.jsp" %>
</head>
<body>
<%@include file="../component/navbar.jsp" %>
	<div class="d-flex justify-content-center align-items-center" style="height:90vh;">
		<div class="card" style="width: 30rem;">
			<div class="card-header text-center">
			Sign Up
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
				<form action="../Customer_Signup" method="post">
					<input type="text" placeholder="Enter your username" name="customer_username" class="form-control mb-2" />
					<input type="text" placeholder="Enter your address" name="customer_address" class="form-control mb-2" />
					<input type="text" placeholder="Enter your phone number" name="customer_phone" class="form-control mb-2" />
					<input type="password" placeholder="Enter your password" name="customer_password" class="form-control mb-2" />
					<button class="btn btn-success mb-2" type="submit">SignUp</button>
					<p>Already Have Account? <a href="customer_login.jsp" class="">Login</a></p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>