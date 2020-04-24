<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		Object msg = request.getAttribute("msg");
	%>
	<p><%=msg%></p>
	<h1>Login</h1>
	<form action="/HelloWeb6/dang-nhap" method="post">
		<div class="form-group">
			<label>Username:</label> <input class="form-control" type="text"
				name="ten" placeholder="Nhap ten">
		</div>
		<div class="form-group">
			<label>Mat khau:</label> <input class="form-control" type="password"
				name="pass" placeholder="Nhap mk">
			<div>
				<button class="btn btn-primary" type="submit">Dang nhap</button>
			</div>
		</div>
	</form>
</body>
</html>