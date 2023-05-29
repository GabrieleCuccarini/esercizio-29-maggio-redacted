<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.sistemi.informativi.vo.CompanyVO"%>
<%@page import="com.sistemi.informativi.key.Key"%>
<%@page import="com.sistemi.informativi.page.Page"%>
<%@page import="java.util.ArrayList"%>


<%/* recupero dell'ArrayList students dalla sessione effettuando il cast da Object 
(session.getAttribute("students") a ArrayList<StudentVo> */
 ArrayList<CompanyVO> companies = (ArrayList<CompanyVO>)session.getAttribute(Key.companies); %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Companies</title>
		<link rel="icon" href="https://media.licdn.com/dms/image/C4D0BAQELTzC6BB1cDg/company-logo_200_200/0/1606302807294?e=2147483647&v=beta&t=GzPDKsbXrADl3jhhKv6lXmP_acyYVt3htUh3ECOT4hU" ></link>
	</head>
	
	<body>
 
		<table align="center" border="1" style="margin-top:1rem;">
	 			<tr>	 
					<td><b>Vat Number</b></td>
					<td><b>Business name</b></td>
					<td><b>Address Location</b></td>
					<td><b>Employees Number</b></td>
					<td><b>Action(D)</b></td>
					<td><b>Action(U)</b></td>
				</tr>
		<% for (int i = 0; i < companies.size(); i++) {;%>
	 
			<form method="post" action="toupdate">
	 
				<tr>
					<%
					String vatNumber = companies.get(i).getVatNumber();
					String businessName = companies.get(i).getBusinessName();
					String addressLocation = companies.get(i).getAddressLocation();
					int employeesNumber = companies.get(i).getEmployeesNumber();
					
					%>
					 
					<td><input type="text" readonly name="vatNumber" value="<%=vatNumber%>"/></td>
					<td><input type="text" readonly name="businessName" value="<%=businessName%>"/></td>
					<td><input type="text" readonly name="addressLocation" value="<%=addressLocation%>"/></td>
					<td><input type="text" readonly name="employeesNumber" value="<%=employeesNumber%>"/></td>
					<td style="background-color: red"><a style="text-decoration: none; color:white;" href="delete?vatNumber=<%=vatNumber%>">Delete</a></td>
					<td style="background-color: blue"><input style="color:white; border:none; background-color: blue" type="submit" value="Update"></td>
				</tr>
			 
			</form>
	 
		<%};%>
 
		</table>
 
		<table align="center" style="margin-top:1rem;">
			<tr>
				<td><a href="<%= Page.home %>">Back Home</a></td>			 
			</tr>
		</table>
 
	</body>
	
<style>
		a {
		text-decoration:none;
		color: red;
		}
</style>

	
</html>