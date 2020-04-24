<%@page import="com.trungtamjava.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chi tiết người dùng</title>
</head>
<body>
	<%
		User user = (User) request.getAttribute("u");
	%>
	<h1>dữ liệu cá nhân</h1>
	<div>
		<label>ID</label> <label><%=user.getId()%></label>
	</div>
	<div>
		<label>Name</label> <label><%=user.getName()%></label>
	</div>
	<div>
		<label>Age</label> <label><%=user.getAge()%></label>
	</div>

</body>
</html>