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
<title>Update Medicine</title>
<%@include file="../component/link.jsp" %>
</head>
<body>
<c:if test="${empty adminObj}">
		<c:redirect url="admin_login.jsp"></c:redirect>
	</c:if>
<%@include file="navbar.jsp" %>
	<h3 class="text-center mt-3">Update Meicine<i class="fa-solid fa-syringe"></i></h3>
		<div class="d-flex justify-content-center">
			<div class="card" style="width:30rem;">
				
				<div class="card-body">
					<%
						int id=Integer.parseInt(request.getParameter("id"));
						MedicineController mcon=new MedicineController();
						Medicine md=mcon.getMedicineById(id);
					%>
					<form action="../UpdateMedicine">
						<input type="hidden" value="<%=md.getId() %>" name="mid" />
						<input placeholder="Enter medicine name" value="<%=md.getMedicineName() %>" class="form-control my-3" type="text" name="medName" />
						<input placeholder="Enter medicine price" value="<%=md.getPrice() %>" class="form-control my-3" type="text" name="medPrice" />
						<input placeholder="Enter Quantity" value="<%=md.getAvailability_in_strips() %>" class="form-control my-3" type="text" name="medQty" />
						<button type="submit" class="btn btn-success my-3">Update</button>
					</form>
				</div>
			</div>
				</div>
</body>
</html>