<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Signup</title>
<%@include file="../component/link.jsp" %>
</head>
<body>
	<%@include file="../component/navbar.jsp" %>
	<div class="d-flex justify-content-center align-items-center" style="height:90vh;">
		<div class="card" style="width: 30rem;">
			<div class="card-header text-center">
			SignUp Now
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
				<form action="../AdminSignup" method="post">
					<input type="text" placeholder="Enter username" name="admin_username" required class="form-control mb-2" />
					<input type="password" placeholder="Enter password" name="admin_password" required class="form-control mb-2" />
					<button class="btn btn-success mb-2" type="submit">Signup</button>
					<p>Already Have Account? <a href="admin_login.jsp" class="">Login</a></p>
				</form>
			</div>
		</div>
	</div>


</body>
</html>