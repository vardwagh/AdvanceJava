<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<%@include file="layout.jsp"%>
	<div class="container">
		<div class="tab-content">
			<div class="tab-pane fade active in">

				<p style="color: red;">${message}</p>
				<div class="col-lg-6">
					<form action="/DemoSpringMVC/login" method="post">
						<div class="form-group ">
							<label for="name">Name:</label> <input type="text"
								class="form-control" name="name" />
						</div>
						<div class="form-group">
							<label for="password">Password:</label> <input type="password"
								class="form-control" name="password" />
						</div>
						<input type="submit" class="btn btn-success" value="Login" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>