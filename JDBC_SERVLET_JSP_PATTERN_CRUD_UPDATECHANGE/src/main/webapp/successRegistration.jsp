<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.sistemi.informativi.key.Key"%>
<%@page import="com.sistemi.informativi.page.Page"%>
<!DOCTYPE html>
<!-- Per una servlet la http session è un oggetto esplicito ovvero
va esplicitamente inizializzata prima di poter essere usata. -->
<%@ page import = "com.sistemi.informativi.dto.CompanyDTO" %>
<% CompanyDTO companyDTO = (CompanyDTO)session.getAttribute(Key.companyDTO); %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Pagina di avvenuta registrazione</title>
	</head>
	<body>
	<%= "Registrazione avvenuta correttamente per la company " + companyDTO.getBusinessName() %>
	<br><br>
	<a href="<%= Page.home %>">Back Home</a>			 
	</body>
</html>