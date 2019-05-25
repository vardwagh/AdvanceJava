<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employees</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<%@include file="layout.jsp"%>
	<div class="container">
		<div class="tab-content">
			        
			<div class="tab-pane fade active in">
				<div class="col-lg-3"> 
					<table class="table table-striped table-bordered" >
						<thead class="thead-dark" >
							<tr>
								<th class="text-center " colspan="3">ADMIN</th> 	
							</tr>
							<tr class="bg-primary">
								<th>Emp Id</th>
								<th>Name</th>
								<th>Salary</th>
							</tr>
						</thead>
						<c:forEach var="employee" items="${employeeListAdmin}">
							<tr>
								<td>${employee.emp_id }</td>
								<td>${employee.name }</td>
								<td>${employee.sal }</td>								
							</tr>
						</c:forEach>
					</table>
				</div>
				
			</div>
			
			<div class="tab-pane fade active in">
				<div class="col-lg-3"> 
					<table class="table table-striped table-bordered" >
						<thead class="thead-dark" >
							<tr>
								<th class="text-center " colspan="3">HR</th> 	
							</tr>
							<tr class="bg-primary">
								<th>Emp Id</th>
								<th>Name</th>
								<th>Salary</th>
							</tr>
						</thead>
						<c:forEach var="employee" items="${employeeListHr}">
							<tr>
								<td>${employee.emp_id }</td>
								<td>${employee.name }</td>
								<td>${employee.sal }</td>								
							</tr>
						</c:forEach>
					</table>
				</div>
				
			</div>
			
			
			<div class="tab-pane fade active in">
				<div class="col-lg-3"> 
					<table class="table table-striped table-bordered" >
						<thead class="thead-dark" >
							<tr>
								<th class="text-center " colspan="3">QA</th> 	
							</tr>
							<tr class="bg-primary">
								<th>Emp Id</th>
								<th>Name</th>
								<th>Salary</th>
							</tr>
						</thead>
						<c:forEach var="employee" items="${employeeListQa}">
							<tr>
								<td>${employee.emp_id }</td>
								<td>${employee.name }</td>
								<td>${employee.sal }</td>								
							</tr>
						</c:forEach>
					</table>
				</div>
				
			</div>
			
			
			<div class="tab-pane fade active in">
				<div class="col-lg-3"> 
					<table class="table table-striped table-bordered" >
						<thead class="thead-dark" >
							<tr>
								<th class="text-center " colspan="3">PROD</th> 	
							</tr>
							<tr class="bg-primary">
								<th>Emp Id</th>
								<th>Name</th>
								<th>Salary</th>
							</tr>
						</thead>
						<c:forEach var="employee" items="${employeeListprod}">
							<tr>
								<td>${employee.emp_id }</td>
								<td>${employee.name }</td>
								<td>${employee.sal }</td>								
							</tr>
						</c:forEach>
					</table>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>