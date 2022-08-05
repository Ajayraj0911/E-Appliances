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
	<jsp:include page="MainMenu.jsp"></jsp:include>
	<%
	String emailError = (String) request.getAttribute("emailError");
	String passwordError = (String) request.getAttribute("passwordError");
	String genderError = (String) request.getAttribute("genderError");
	String genderValue = (String) request.getAttribute("genderValue");
	String contactError = (String) request.getAttribute("contactError");
	%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h1>SIGN UP</h1>

				<form method="post" action="SignupController">

					<div class="form-group">
						FirstName : <input type="text" name="firstName"
							value="${firstNameValue}" class="form-control"
							placeholder="Enter First Name" /> ${firstNameError}
					</div>

					<div class="form-group">
						LastName : <input type="text" name="lastName"
							value="${lastNameValue}" class="form-control"
							placeholder="Enter Last Name" /> ${lastNameError}
					</div>

					<div class="form-group">
						Email : <input type="text" name="email" value="${emailValue}"
							class="form-control" placeholder="Enter Email" /> <span
							class="error"><%=emailError == null ? "" : emailError%></span>
					</div>

					<div class="form-group">
						Password : <input type="password" name="password"
							class="form-control" value="${passwordValue}"
							placeholder="Enter Password" /><span class="error"><%=passwordError == null ? "" : passwordError%></span>
					</div>

					<div class="form-group">
						Contact:<input type="text" class="form-control" name="contact" placeholder="Enter Contact number"
							value="${contactValue }" />${contactError }
					</div>
						<div class="form-group">
							Gender : Male <input type="radio" name="gender" value="male"
								<%=genderValue != null && genderValue.equals("male") ? "checked" : ""%> />

							Female:<input type="radio" name="gender" value="female"
								<%=genderValue != null && genderValue.equals("female") ? "checked" : ""%> />

							<span class="error"><%=genderError == null ? "" : genderError%></span>
						</div>
						<input type="submit" value="Signup" class="btn btn-primary" /> <input
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