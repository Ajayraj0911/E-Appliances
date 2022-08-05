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
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form action="ProductController" method="post">
					<div>
						<h1>Insert Product</h1>
					</div>
					<div class="form-group">
						Product Name : -<input type="text" name="productname"
							value="${productNameValue }" class="form-control" placeholder="Enter Product Name"/>${productNameError}
					</div>
					<div class="form-group">
						Price : -<input type="text" name="price" value="${priceValue }"
							class="form-control" placeholder="Enter Price"/>${priceError }
					</div>
					<div class="form-group">
						Quantity : -<input type="text" name="quantity"
							value="${quantityValue }" class="form-control" placeholder="Enter Quantity"/>${quantityError}
					</div>
					<div class="form-group">
						ImgUrl : -<input type="text" name="imgurl" class="form-control" placeholder="Enter Image Url"/>${imgurlError}
					</div>
					<div class="form-group">
						Description : - <textarea rows="4" cols="40" name="desc" class="form-control" placeholder="Enter Description"></textarea>${descError}
					</div> 
					 
					<div>
						<input type="submit" value="Insert" class="btn btn-primary" /> <input
							type="reset" value="Reset" class="btn btn-danger" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>