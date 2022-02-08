<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE UI</title>
</head>
<body>
	<div align="center">
		<h1>Login Form</h1>
		<form action="<%= request.getContextPath() %>/login" method="post">
			<table style="width: 80%">
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
			<p class="message">Not registered? <a href="../UserRegistarion.jsp">Create an account</a></p>
		</form>
	</div>
</body>

</html>