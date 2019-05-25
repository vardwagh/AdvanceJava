<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<%@include file="layout.jsp"%>
	<div class="container">
		<div class="tab-content">
			<div class="tab-pane fade active in">
				Message:${message } <br /> ${creditCard.rawCardNumber}
				${creditCard.bankIdNo} ${creditCard.accountNo}
				${creditCard.checkCode}

			</div>
		</div>
	</div>
</body>
</html>