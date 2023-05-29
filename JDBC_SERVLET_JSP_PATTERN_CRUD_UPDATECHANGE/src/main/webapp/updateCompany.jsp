<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.sistemi.informativi.dto.CompanyDTO"%>
<%@page import="com.sistemi.informativi.page.Page"%>
<% CompanyDTO companyDTO = (CompanyDTO)session.getAttribute("companyDTO"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Update</title>
	<link rel="icon" href="https://media.licdn.com/dms/image/C4D0BAQELTzC6BB1cDg/company-logo_200_200/0/1606302807294?e=2147483647&v=beta&t=GzPDKsbXrADl3jhhKv6lXmP_acyYVt3htUh3ECOT4hU" ></link>
</head>

<body>
	<h1 align="center">Update Company "<%=companyDTO.getBusinessName()%>"</h1>
	<form align="center" method="post" action="update">
		<label for="vatNumber">VAT Number</label> 
		<input type="text" readonly name="vatNumber" value="<%=companyDTO.getVatNumber()%>" /> 
		<br><br> 
		<label for="businessName">Business Name</label> 
		<input type="text" name="businessName" value="<%=companyDTO.getBusinessName()%>"  />
		<br><br>
		<label for="addressLocation">Address Location</label> <input
			type="text" name="addressLocation"
			value="<%=companyDTO.getAddressLocation()%>"  /> 
		<br><br> 
		<label for="employeesNumber">Employees Number</label> 
		<input type="text" name="employeesNumber" value="<%=companyDTO.getEmployeesNumber()%>"
			style="width: 200px;" /> 
		<br><br>
		<input class="submitButton" type="submit" value="Update">
	</form>

	<table align="center" style="margin-top: 1rem;">
		<tr>
			<td><a href="<%= Page.home %>">Back Home</a></td>
		</tr>
	</table>

</body>

	<style>
	
		.submitButton {
			background-color: blue;
			color: white;
		}
		
		label {
			font-weight: bold;
		}
		
		a {
		text-decoration:none;
		color: red;
		}
		
	</style>
	
</html>