<%@page import="com.trungtamjava.model.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>đăng ký category</title>
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
	<!-- 	<%Category category = (Category) request.getAttribute("category");%> dung el k can dung nua-->
	<h1 style="text-align: center">Update category</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form action="/HelloWeb6/admin/category/update" method="post">
					<input name="id" value="${category.getId()}">
					<div class="form-group">
						<label>tên</label> <input class="form-control" type="text"
							name="name" value="${ category.getName()}>"
							placeholder="Nhap ten">
						<div>
							<button class="btn btn-primary" type="submit">sửa</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>