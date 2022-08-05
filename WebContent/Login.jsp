<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<style type="text/css">
.error {
	color: red;
}

</style>
</head>
<body>
<jsp:include page="MainMenu.jsp"></jsp:include>
	<%
	String emailError = (String) request.getAttribute("emailError");
	String passwordError = (String)request.getAttribute("passwordError");
	%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div>
					<h1>Login Page</h1>
				</div>
			
				<form action="LoginController" method="post">

					<div class="form-group">
						Email :<input type="text" name="email" class="form-control" value="${emailValue }" placeholder="Enter Email"/> <span class="error"><%=emailError == null ? "" : emailError%></span>

					</div>

					<div class="form-group">
						Password : <input type="password" name="password"
							class="form-control" placeholder="Enter Password"/><span class="error"><%=passwordError == null ? "" : passwordError%></span>
					</div>
					<input type="submit" value="Login" class="btn btn-primary" />

				</form>
				<div>
					<a href="Signup.jsp">New User?</a>
				</div>
				<div>
					<a href="ForgetPassword.jsp">ForgotPassword??</a>
				</div>
				${msg}
				<span class="text-danger">${errormsg}</span>
			</div>
		</div>

	</div>
</body>
</html>