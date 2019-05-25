<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>
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


				<h2 style="color: green; text-align: center;">${message}</h2>
				<br /> <br />
				<div class="col-lg-4" style="border-right: 2px solid red;">
					<form:form action="/DemoSpringMVC/add" method="post"
						commandName="employee">
						<div class="form-group ">
							<label for="name">Employee Name:</label>
							<form:hidden path="emp_id" value="${emp_id}" />
							<form:input class="form-control" path="name" />
							<form:errors path="name" cssClass="error" />
						</div>
						<div class="form-group ">
							<label for="name">Department:</label>
							<form:select class="form-control" path="dept">
								<form:options items="${depts}" />
							</form:select>
							<form:errors path="dept" cssClass="error" />
						</div>
						<div class="form-group ">
							<label for="name">Salary:</label>
							<form:input class="form-control" path="sal" />
							<form:errors path="sal" cssClass="error" />
						</div>
						<div class="form-group ">
							<label for="name">Joining Date:</label>
							<form:input type="date" class="form-control" path="joiningDate" />
							<form:errors path="joiningDate" cssClass="error" />
						</div>
						<div class="form-group ">
							<label for="name">Skills:</label>
							<form:select class="form-control" path="skills"
								items="${skillsList}" multiple="true" />
							<form:errors path="skills" cssClass="error" />

						</div>
						<input type="submit" class="btn btn-success" value="Add Employee" />
					</form:form>
				</div>
				<div class="col-lg-8">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Emp Id</th>
								<th>Name</th>
								<th>Dept</th>
								<th>Salary</th>
								<th>Action</th>
							</tr>
						</thead>
						<c:forEach var="employee" items="${employeeList}">
							<tr>
								<td>${employee.emp_id }</td>
								<td>${employee.name }</td>
								<td>${employee.dept }</td>
								<td>${employee.sal }</td>
								<td><a class="btn btn-default"
									href="/DemoSpringMVC/edit/${employee.emp_id}">Edit</a> <a
									class="btn btn-danger"
									href="/DemoSpringMVC/delete?id=${employee.emp_id }">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>