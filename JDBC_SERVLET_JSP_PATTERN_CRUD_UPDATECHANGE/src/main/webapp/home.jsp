<%@page import="com.sistemi.informativi.page.Page"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
		<link rel="icon" href="https://media.licdn.com/dms/image/C4D0BAQELTzC6BB1cDg/company-logo_200_200/0/1606302807294?e=2147483647&v=beta&t=GzPDKsbXrADl3jhhKv6lXmP_acyYVt3htUh3ECOT4hU" ></link>
	</head>
	
	<body>	
		<div style="margin: 50px auto; color:red; border: 3px solid red; width:50%">
			<h1 align="center">Actions</h1>
			<h3 align="center">Click &#8594; <a href="<%= Page.companyRegistration %>">Registrate a new company</a></h3>
			<h3 align="center">Click &#8594; <a href="companies">Open companies table</a></h3>
		</div>
	</body>

	<style>
		a {
		text-decoration: none;
		font-size: 20px;
		color: black;
		}
	</style>
</html>