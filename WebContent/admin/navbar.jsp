<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.virtusa.model.Admin" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/link.jsp" %>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-warning border border-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">Online Pharmacy</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-auto">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="view_customer.jsp">Customer</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="view_medicine.jsp">Medicine</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="view_distributor.jsp">Distributor</a>
        </li>
        <li class="nav-item">
        	<%
        		HttpSession ses=request.getSession();
        		Admin ad=(Admin)ses.getAttribute("adminObj");
        		String adminName=ad.getName();
        		ses.setAttribute("adName", adminName);
        	%>
          <a class="nav-link active" aria-current="page" href="#">${adName} <i class="fa-solid fa-user"></i></a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../AdminLogout">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>