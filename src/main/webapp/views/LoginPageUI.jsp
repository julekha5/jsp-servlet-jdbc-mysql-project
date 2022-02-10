<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE UI</title>
<link rel="stylesheet" href="../css/login.css">
</head>
<body>
	<div class="login-page">
		<div class="form">
		    <h1>Login </h1>
			<form action="<%=request.getContextPath()%>/login" method="post">		
				<input type="text" name="username" placeholder="Enter username" /> 
				<input type="password" name="password" placeholder="Enter password" />
				<button type="submit">Login</button>
				<p class="message">
					Not registered? <a href="../views/UserRegistration.jsp">Create an
						account</a>
				</p>
			</form>
		</div>
	</div>

</body>

</html>