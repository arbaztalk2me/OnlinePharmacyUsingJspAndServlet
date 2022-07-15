<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/link.jsp" %>
<style>
	.img-container{
		height:400px;
		width:400px;
	}
	.img-container img{
		width:100%;
		height:100%;
	}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp" %>
	<div class="container my-3">
		<h3 class="text-center mt-3">Welcome TO Online Pharmacy Store <i class="fa-solid fa-capsules"></i></h3>
		<div class="d-flex justify-content-center">
			<img src="component/13072020155435OnlinePharmacy.jpg" />
		</div>
		<h4 class="text-center mt-3">24 Hour Available</h4>
		<div class="d-flex justify-content-center">
			<div class="img-container">
				<img src="component/istockphoto-878129954-612x612.jpg" />
			</div>
		</div>
	</div>
</body>
</html>