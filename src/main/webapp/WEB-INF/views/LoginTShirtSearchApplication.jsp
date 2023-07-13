<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="coreTag" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Login TShirt Search Application</title>
<link href='<coreTag:url value="/static Resources/css/StylingLoginTShirtSearchApplication.css" />' rel="stylesheet">
</head>
<body>
	<div id="loginHeading">
		<h3>Login</h3>
	</div>
	<br>
	<form action="loginCheck" method="post">
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
		
<!-- if wrong credentials entered  -->
		<coreTag:if test="${'false'==userVerified}">
			<coreTag:remove var="userVerified" />
			<label id="validationStatement">Wrong credentials</label>
			<br>
		</coreTag:if>

		<br> <a href="./forgotPassword">Forgotten your password?</a> <br>
		<br>
		<div id="loginBottom">
			<input id="loginButton" type="submit" name="LoginPageCommand"
				value="Login >>">
		</div>
	</form>
</body>
</html>