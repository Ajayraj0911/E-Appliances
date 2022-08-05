<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/buttons/2.2.3/css/buttons.dataTables.min.css">

</head>
<body>
	<jsp:include page="AdminMenu.jsp"></jsp:include>
	<%
	ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("products");
	%>
	<div class="row" style="margin: 10px;">
		${msg}
		${message }
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="c0l-md-6">
				<h2 align="center">List Products</h2>
				<table id="users" class="display nowrap">
					<thead class="thread-light">
						<tr>
							<th>ProductId</th>
							<th>ProductName</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (ProductBean product : products) {
						%>
						<tr>
							<td><%=product.getProductId() %></td>
							<td><%=product.getProductname() %></td>
							<td><%=product.getPrice() %></td>
							<td><%=product.getQuantity() %></td>
							<td>
								<a href="DeleteProductController?productid=<%=product.getProductId()%>" class="btn btn-primary btn-sm">Delete</a>
								<a href="UpdateProductFormController?productid=<%=product.getProductId()%>" class="btn btn-danger btn-sm">Update</a>
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
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/buttons/2.2.3/js/dataTables.buttons.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/buttons/2.2.3/js/buttons.html5.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/buttons/2.2.3/js/buttons.print.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#users').DataTable({
				dom : 'Bfrtip',
				buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]
			});
		});
	</script>

</body>
</html>