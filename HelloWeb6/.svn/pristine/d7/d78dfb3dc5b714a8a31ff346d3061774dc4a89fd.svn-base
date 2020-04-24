<%@page import="com.trungtamjava.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>tim ngươi dùng</h1>

	<h2>bảng</h2>
	<p>bảng danh sách người dùng</p>
	<table class="table table-bordered">

		<thead>
			<tr class="success">
				<th>id</th>
				<th>tên</th>
				<th>age</th>
			</tr>
		</thead>
		<c:forEach items="${users}" var="u">
			<td>${u.id }</td>
			<td>${u.name }</td>
			<td>${u.age }</td>
			<td>${u.role }</td>
			<td>${u.username }</td>
			<td>${u.password }</td>
			<td><img src="${u.image }" width="100" /></td>
			<td><a href="/HelloWed/admin/user/delete?id=${u.id }">xoa</a> <a
				href="/HelloWed/admin/user/update?id=${u.id }">sua</a></td>
		</c:forEach>
	</table>

</body>
</html>