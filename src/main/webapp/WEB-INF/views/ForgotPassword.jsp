<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="coreTag" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
<link href="<coreTag:url value="/static Resources/css/StylingForgotPassword.css" />" rel="stylesheet">
</head>
<body>
	<div id="resetPasswordHeading">
		<h3>Reset Password</h3>
	</div>
	<br>
	<form action="resetPassword" method="post">
		<table>
			<tr>
				<td><label>Username:</label></td>
				<td style="color: red">*</td>
				<td><input type="text" name="inputUsername" required></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td style="color: red">*</td>
				<td><input type="password" name="inputPassword" required></td>
			</tr>
		</table>

	<!-- if wrong username entered -->
		<coreTag:if test="${'false'==passwordChanged}">
			<coreTag:remove var="passwordChanged" />
			<label id="validationStatement">Wrong Username</label>
			<br>
		</coreTag:if>
		
		<br>
		<div id="resetPasswordBottom">
			<input id="resetPasswordButton" type="submit"
				name="resetPasswordCommand" value="Reset >>">
		</div>
	</form>
</body>
</html>