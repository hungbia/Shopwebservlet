<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search User</title>
</head>
<body>
	<!-- DOc session ra o day -->
	<!--<h1>${sessionScope.loginUsername}</h1> -->
	<jsp:include page="/views/admin/common/header.jsp"></jsp:include>

	<form action="/HelloWeb6/user/search" method="post">
		<input name="keyword" type="text" placeholder="Tu khoa">
		<button type="submit">Search</button>
	</form>
	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Age</td>
			<td>Role</td>
			<td>Username</td>
			<td>Password</td>
			<td>Image</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.id}</td>
				<td>${u.name}</td>
				<td>${u.age}<c:if test="${u.age < 18}">
						Tre em
					</c:if> <c:choose>
						<c:when test="${u.age > 18 }">
							Nguoi lon
						</c:when>
						<c:otherwise>
							Tre em
						</c:otherwise>
					</c:choose>
				</td>
				<td>${u.role}</td>
				<td>${u.username}</td>
				<td>${u.getPassword()}</td>
				<td><img src="${u.getImage()}" width="100" /></td>
				<td><a href="/HelloWeb6/admin/user/delete?id=${u.id}">Xoa</a> <a
					href="/HelloWeb6/admin/user/update?id=${u.id}">Sua</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>