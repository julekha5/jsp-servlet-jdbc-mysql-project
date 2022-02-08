<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<div align="center">
		<h1>Registration Form</h1>
		<form action="<%= request.getContextPath() %>/register" method="post">
			<table style="width: 80%">
				<tr>
					<td>FirstName</td>
					<td><input type="text" name="firstname" id="firstname" /></td>
				</tr>
				<tr>
					<td>LastName</td>
					<td><input type="text" name="lastname" id="lastname" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" id="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="password" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" id="email" /></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="tel" name="phone" id="phone" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><textarea type="text" name="address" id="address" rows="5" /></textarea></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
			<p class="message">
				Already registered? <a href="../LoginPageUI.jsp">Sign In</a>
			</p>
		</form>
	</div>

</body>
</html>