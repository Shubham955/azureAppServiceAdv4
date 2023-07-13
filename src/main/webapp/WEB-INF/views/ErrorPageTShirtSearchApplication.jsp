<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="coreTag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<link href="<coreTag:url value="/static Resources/css/StylingErrorPage.css" />" rel="stylesheet" > 
</head>
<body>
	<h1>Oops! Sorry</h1>
    <h3>Some exception has occurred</h3>
    <div class="ApplicationLink"><a href="./${redirectUrl}">Take me back to ${exceptionOrigin}</a></div>
</body>
</html>