<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@page import="com.bean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Menu</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<% 
		HttpSession session1 = request.getSession();
		String  firstName = (String) session.getAttribute("firstName");
		
		%>
	<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">E-Appliances</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="CustomerHome.jsp">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="CustomerListProductController">Products</a></li>
				<li class="nav-item"><a class="nav-link"
					href="MyOrdersController">List Orders</a></li>
					<li class="nav-item"><a class="nav-link"
					href="customerabout.jsp">About Us</a></li>
				<li class="nav-item">
				<li class="nav-item"><a class="nav-link"
					href="customercontact.jsp">Contact Us</a></li>
				<li class="nav-item">
				<li class="nav-item"><a class="nav-link"
					href="LogoutController">Logout</a></li>

				<!-- <li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Dropdown </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item">
       <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li> -->
			</ul>
			<!-- <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">My Cart</button>
    </form> -->

			<h2 style="color: white;margin-right: 10px;" >Welcome</h2> <%-- <a href="#" class="hero_btn"><%=firstName %></a> --%> 
		
			<h3 style="color: white;margin-right:30px;text-transform: capitalize;"><%=firstName %></h3>
			<a
				href="ViewCartController"
				class="btn btn-outline-success my-2 my-sm-0">My Cart</a>

		</div>
	</nav>

</body>
</html>