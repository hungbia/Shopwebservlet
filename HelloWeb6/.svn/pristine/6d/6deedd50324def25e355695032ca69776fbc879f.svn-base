<%@page import="com.trungtamjava.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
	<form action="/HelloWeb6/admin/category/search" method="post">
		<input name="keyword" type="text" placeholder="Từ Khóa tìm Kiếm">
		<button type="submit" class="btn btn-success">Search</button>
	</form>
	<h1 style="text-align: center;">Bảng danh category</h1>
	<div class="container"></div>
	<div class="row">
		<div class="col-md-6 col-sm-5 col-xs-6"></div>
		<div class="col-md-6 col-sm-7 col-xs-6"></div>
	</div>
	<table class="table table-bordered">
		<thead>
			<tr class="success">
				<td>ID</td>
				<td>Name</td>
				<td>ACtion</td>
			</tr>
		</thead>
		<c:forEach items="${category}" var="ca">
			<tr class="active">
				<td>${ca.id}</td>
				<td>${ca.name}</td>
				<td><a href="/HelloWeb6/admin/category/delete?id=${ca.getId()}">Xóa</a>
					<a href="/HelloWeb6/admin/category/update?id=${ca.getName()}">sửa</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>