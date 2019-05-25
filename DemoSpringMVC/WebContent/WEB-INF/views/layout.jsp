<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Layout</title>
</head>
<body>

	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="/DemoSpringMVC/welcome">3RI
				Technologies</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="${activeHome}"><a href="/DemoSpringMVC/welcome">Home</a></li>
			<li class="${activeLogin}"><a href="/DemoSpringMVC/login">Login</a></li>
			<li class="${activeEmp}"><a href="/DemoSpringMVC/employee">Employee</a></li>
			<li class="${activeDept}"><a href="/DemoSpringMVC/dept">Department</a></li>
			<li class="${activeAllEmp}"><a href="/DemoSpringMVC/allemployee">All Employee</a></li>
			<li class="${activeContact}"><a href="/DemoSpringMVC/contact">Contact Us</a></li>
		</ul>
	</div>
	</nav>

</body>
</html>