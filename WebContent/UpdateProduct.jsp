<%@page import="com.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="AdminMenu.jsp"></jsp:include>

<%
	/* String emailError = (String) request.getAttribute("emailError");
	String passwordError = (String) request.getAttribute("passwordError"); */
	ProductBean product = (ProductBean)request.getAttribute("product");
	%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form action="UpdateProductController" method="post">
				<input type="hidden" value="${product.productId}" name="productId"/>
				<div>
					<h1>Update Product</h1>
				</div>
					<div class="form-group">
						Product Name : -<input type="text" name="productname" value="${product.productname }"
							class="form-control" />
					</div>
					<div class="form-group">
						Price : -<input type="text" name="price" value="${product.price }" class="form-control"/>
					</div>
					<div class="form-group">
						Quantity : -<input type="text" name="quantity" value="${product.quantity }" class="form-control"/>
					</div>
					<div class="form-group">
						ImgUrl : -<input type="text" name="imgurl" class="form-control" value="${product.imgUrl }"/>
					</div>
					<div class="form-group">
						<%-- Description : - <textarea rows="4" cols="40" name="desc" class="form-control" value="${product.desc }"></textarea>${descError} --%>
						Description : - <input type="text" style="width: 420px; height: 100px;" name="desc" class="form-control" value="${product.desc }" />
					</div> 
					<div>
						<input type="submit" value="Update Product" class="btn btn-primary"/>
						<input type="reset" value="Reset" class="btn btn-danger"/>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>