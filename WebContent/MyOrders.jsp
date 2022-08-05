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
		ArrayList<OrderBean> orders = (ArrayList<OrderBean>) request.getAttribute("orders");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h2 align="center">Your Orders</h2>

				<table class="display table table-hover" id="carts">
					<thead class="thead-light">
						<tr>
							<th>OrderId</th>
							<th>Amount</th>
							<th>PaymentMode</th>
							<th>PaymentStatus</th>
							<th>OrderStatus</th>
							<th>Action1</th>
							<th>Action2</th>
						</tr>
					</thead>

					<tbody>
						<%
							for (OrderBean order : orders) {
						%>
						<tr>
							<td><%=order.getOrderId()%></td>
							<td><%=order.getAmount()%></td>
							<td><%=order.getPaymentmode()%></td>
							<td><%=order.getPaymentstatus() %></td>
							<td><%=order.getOrderstatus() %></td>							
							<td><a
								href="MyOrderDetailController?orderId=<%=order.getOrderId()%>" class="btn btn-outline-success btn-sm">View Details</a>
							</td>
							<td>
								<a
								href="CancelOrderController?orderId=<%=order.getOrderId()%>" class="btn btn-outline-danger btn-sm">Cancel Order</a>
							</td>
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