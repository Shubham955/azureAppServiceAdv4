<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="coreTag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TShirt Search Application</title>
<coreTag:url
	value="/static Resources/css/StylingTShirtSearchApplication.css"
	var="cssUrl" />
<link rel="stylesheet" href="${cssUrl}">
</head>
<body>
	<form action="logout" method="post">
	<!-- displays signed in user's username -->
		<span>Hi ${signedInUser} <input type="submit" id="logoutButton"
			name="logoutButton" value="Logout">
		</span>
	</form>
	<br>
	<h1>TShirt Search Application</h1>
	<br>
	<div class="SearchForm">
		<form action="searchTShirt" method="post">
<!-- 		input for tshirt Colour and validation of digits in colour name -->
			<h3>TShirt Preferences</h3>
			<br> <label>Colour</label> <input type="text"
				name="tShirtColour" id="colourId" onchange="validateColour()" required><label id="colourValidationLabel"></label>
				<br> <br>
<!-- 			input for tshirt size -->
			<label>Size</label> <select name="tShirtSize" id="sizeId" required>
				<option value="">None</option>
				<option value="s">Small</option>
				<option value="m">Medium</option>
				<option value="l">Large</option>
				<option value="xl">Extra Large</option>
				<option value="xxl">Double XL</option>
			</select><br> <br> 
<!-- 			input for tshirt gender -->
			<label>Gender</label>
<!--required if written in one of the radio buttons of radio group makes whole radio group required -->
			<input type="radio" id="maleId" name="tShirtGender" value="m"
				required>Male <input type="radio" id="femaleId"
				name="tShirtGender" value="f">Female <br> <br>
<!-- 			input for result display output preference -->
			<h3>Result Output Preference</h3>
			<label id="preferenceLabel">Output Preference</label> <select
				name="outputPreference" id="outputPreferenceId" required>
				<option value="">None</option>
				<option value="price">Price</option>
				<option value="rating">Rating</option>
				<option value="both">Price and Rating</option>
			</select><br> <br> 
			
			<input type="submit" value="Submit"
				id="submitButton"><br> <br>
		</form>
	</div>
	<br>
	<br>
<!-- 	if no result found or no new file added -->
	<coreTag:if test="${empty recommendedTShirts}">
		<label id="noResultLabel"><b>${noResult}${noNewFile}</b></label>
<!--values of noResult and noNewFile after being used removed so that no unexpected situation occurs -->
		<coreTag:remove var="noResult"/>
		<coreTag:remove var="noNewFile"/>
	</coreTag:if>
	
<!-- 	results display section -->
	<div id="displayProduct">
<!-- 	if some result found as per search input -->
		<coreTag:if test="${not empty recommendedTShirts}">
			<table>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Colour</th>
					<th>Gender</th>
					<th>Size</th>
					<th>Price</th>
					<th>Rating</th>
				</tr>
<!-- iterates and displays product list -->
				<coreTag:forEach var="fetchedProduct" items="${recommendedTShirts}">
					<tr>
						<td>${fetchedProduct.id}</td>
						<td>${fetchedProduct.name}</td>
						<td>${fetchedProduct.colour}</td>
						<td>${fetchedProduct.gender}</td>
						<td>${fetchedProduct.size}</td>
						<td>${fetchedProduct.price}</td>
						<td>${fetchedProduct.rating}</td>
					</tr>
				</coreTag:forEach>
<!-- after usage recommendedTShirts removed so that no unexpected use of recommendedTShirts happens  -->
				<coreTag:remove var="recommendedTShirts" />
			</table>
			<br><br>
<!-- query asking user to wait for detection of new files -->
			<div id=newFileDetectEnquiry>
				<form action="detectNewFile">
					<label id="fileDetectionEnquiryLabel">Do you want to wait
						for next 20 seconds to see updated results fetched from new
						created Files (if any)? If you want to continue, Please press Continue else Carry on another TShirt Search.</label>  <input type="submit" value="Continue"
						name="continueDetectFile" id="continueDetectFileButton">
<!-- hidden inputs used to send user input search details to new file alert controller -->
						<input type="hidden" name="tShirtSearchColour" value="${tShirtColour}" >
						<input type="hidden" name="tShirtSearchSize" value="${tShirtSize}" >
						<input type="hidden" name="tShirtSearchGender" value="${tShirtGender}" >
						<input type="hidden" name="outputPreference" value="${outputPreference}" >
				</form>
			</div>
		</coreTag:if>
	</div>
<!-- Java script file -->
	<coreTag:url
	value="/static Resources/js/ScriptTShirtSearch.js"
	var="jsUrl" />
	<script src="${jsUrl}" type="text/javascript"></script> 
</body>
</html>