<%@page import="com.trungtamjava.model.Product"%>
<%@page import="com.trungtamjava.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: black;
}

h1 {
	color: lime;
	text-align: center;
}

p {
	font-family: verdana;
	font-size: 20px;
}
</style>
<meta charset="UTF-8">
<title>tim category</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<body style="background-color: activeborder;">
	<%
		Product product = (Product) request.getAttribute("products");
	%>
	<h1 style="text-align: center">Update category</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form action="/HelloWeb6/admin/product/update" method="post">
					<input name="id" value="<%=product.getId()%>">
					<div class="form-group">
						<label>Tên sản phẩm</label> <input class="form-control"
							type="text" name="name" value="<%=product.getName()%>"
							placeholder="Nhap tên sản phẩm">
					</div>
					<div class="form-group">
						<label>giá sản phẩm</label> <input class="form-control"
							type="text" name="price" value="<%=product.getPrice()%>"
							placeholder="Nhap giá sản phẩm">
					</div>
					<div class="form-group">
						<label>CategoryID</label> <input class="form-control" type="text"
							name="categoryId" value="<%=product.getCategory().getId()%>"
							placeholder="nhập CategoryID">
						<div>
							<input class="btn btn-primary" type="submit" value="Sửa">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>