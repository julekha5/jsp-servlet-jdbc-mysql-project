<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" href="../css/login.css">
</head>
<body>	
	<div class="register-page ">
		<div class="form">
		    <h1>Registration Form</h1>	    
			<form action="<%=request.getContextPath()%>/register" method="post">
				<input type="text" name="firstname" placeholder="Enter firstname" />
				<input type="text" name="lastname" placeholder="Enter lastname" />		
				<input type="text" name="username" placeholder="Enter username" /> 
				<input type="password" name="password" placeholder="Enter password" />
				<input type="email" name="email" placeholder="Enter email" />
				<input type="tel" name="phone" placeholder="Enter phone number" />
				<input type="text" name="address" placeholder="Enter address" />		
				<button type="submit">Register</button>
				<p class="message">
					Already registered?<a href="../views/LoginPageUI.jsp">Log In</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>