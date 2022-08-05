<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
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
<jsp:include page="AdminMenu.jsp"></jsp:include>
	<%
	/* String emailError = (String) request.getAttribute("emailError");
	String passwordError = (String) request.getAttribute("passwordError"); */
	UserBean user = (UserBean)request.getAttribute("user");
	String genderValue = user.getGender();
	%>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h1>UPDATE USER</h1>

				<form method="post" action="UpdateUserController">
					<input type="hidden" value="${user.userId}" name="userId"/>
					<div class="form-group">
						FirstName : <input type="text" name="firstName"
							value="${user.firstName}" class="form-control" />
						${firstNameError}
					</div>

					<div class="form-group">
						LastName : <input type="text" name="lastName"
							value="${user.lastName}" class="form-control" /> ${lastNameError}
					</div>

					<div class="form-group">
						Email : <input type="text" name="email" value="${user.email}" disabled="disabled"
							class="form-control" /> <span class="error"><%-- <%=emailError == null ? "" : emailError%> --%></span>
					</div>

					<div class="form-group">
						Password : <input type="password" name="password"
							class="form-control" value="${user.password}" /><span
							class="error"><%-- <%=passwordError == null ? "" : passwordError%> --%></span>
					</div>
					<div class="form-group">
						Gender : Male <input type="radio" name="gender" value="male"
							<%=genderValue != null && genderValue.equals("male") ? "checked" : ""%> />

						Female:<input type="radio" name="gender" value="female"
							<%=genderValue != null && genderValue.equals("female") ? "checked" : ""%> />

						<%-- <span class="error"><%=genderError == null ? "" : genderError%></span> --%>
					</div>
					<input type="submit" value="UPDATE USER" class="btn btn-primary" /> <input
						type="reset" value="Reset" class="btn btn-danger" />
					<div>
						<a href="Login.jsp">Already Registered??</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>