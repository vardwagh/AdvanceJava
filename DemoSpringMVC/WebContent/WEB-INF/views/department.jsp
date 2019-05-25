<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department</title>
</head>
<body>
	<%@include file="layout.jsp"%>
	<div class="container">
		<div class="tab-content">
			<div class="tab-pane fade active in">
				<div class="col-lg-4" style="border-right: 2px solid red;">
					<form:form action="/DemoSpringMVC/dept" method="post"
						commandName="dept">
						<div class="form-group ">
							<label for="name"> Department Name:</label>
							<form:hidden path="id" value="${id}" />
							<form:input path="dept" class="form-control" />
							<form:errors path="dept" cssClass="error" />
						</div>
						<div class="form-group ">
							<label for="name"> Employee Count:</label>
							<form:input path="empCount" class="form-control" />
							<form:errors path="empCount" cssClass="error" />
						</div>
						<input type="submit" class="btn btn-success"
							value="Add Department">

					</form:form>
				</div>
				<div class="col-lg-8">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Department Id</th>
								<th>Department Name</th>
								<th>Employee Count</th>
								<th>Action</th>
							</tr>
						</thead>
						<c:forEach var="dept" items="${deptList}">
							<tr>
								<td>${dept.id }</td>
								<td>${dept.dept }</td>
								<td>${dept.empCount}</td>
								<td><a class="btn btn-default"
									href="/DemoSpringMVC/deptedit/${dept.id}">Edit</a> <a
									class="btn btn-danger"
									href="/DemoSpringMVC/deptdelete?id=${dept.id }">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>