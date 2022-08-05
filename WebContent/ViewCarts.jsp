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
		ArrayList<CartProductBean> carts = (ArrayList<CartProductBean>) request.getAttribute("carts");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h2 align="center">Items in Cart</h2>

				<table class="display table table-hover" id="carts">
					<thead class="thead-light">
						<tr>
							<th>ProductId</th>
							<th>ProductName</th>
							<th>Price</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>
						<%
							int total = 0;
							for (CartProductBean cart : carts) {
								total = total + cart.getPrice();
						%>
						<tr>
							<td><%=cart.getProductId()%></td>
							<td><%=cart.getProductname()%></td>
							<td><%=cart.getPrice()%></td>
							<td><a
								href="DeleteCartController?cartId=<%=cart.getCartId()%>" class="btn btn-outline-success btn-sm">Delete</a>
							</td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
				<h2>
					Total =
					<%=total%></h2>
				
				<a href="CheckoutController" class="btn btn-success">Checkout - Place Order</a>

			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

</body>
</html>