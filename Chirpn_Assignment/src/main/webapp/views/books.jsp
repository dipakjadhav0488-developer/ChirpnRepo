<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books Details</title>
</head>
<body>

	<h2>Save Books Details</h2>


	<font color='green'>${succMsg}</font>
	<font color='red'>${errMsg}</font>
	<form:form action="saveBook" 
			   method="POST"
			   modelAttribute="book">
		<table>

			<tr>
				<td>Email: </td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>First Name: </td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name: </td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>User Name: </td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>Mobile Number: </td>
				<td><form:input path="mobileNumber" /></td>
			</tr>
			<tr>
				<td>Book Name: </td>
				<td><form:input path="bookName" /></td>
			</tr>
			<tr>
				<td>Book Price: </td>
				<td><form:input path="bookPrice" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>