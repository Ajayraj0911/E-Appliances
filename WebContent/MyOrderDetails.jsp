<%@page import="com.bean.OrderDetailProductBean"%>
<%@page import="com.bean.OrderBean"%>
<%@page import="com.bean.CartProductBean"%>
<%@page import="com.bean.CartBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Carts</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="CustomerMenu.jsp"></jsp:include>

	<%
		ArrayList<OrderDetailProductBean> details = (ArrayList<OrderDetailProductBean>) request.getAttribute("details");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h2 align="center">Order Details</h2>

				<table class="display table table-hover" id="carts">
					<thead class="thead-light">
						<tr>
							<th>Product Name</th>
							<th>Price</th>
							<th>Image</th>
						</tr>
					</thead>

					<tbody>
						<%
							for (OrderDetailProductBean order : details) {
						%>
						<tr>
							<td><%=order.getProductname()%></td>
							<td><%=order.getPrice()%></td>		
							<td><img height="100px" width="100px" src="<%=order.getImgUrl()%>"></td>					
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
				

			</div>
		</div>
	</div>

</body>
</html>