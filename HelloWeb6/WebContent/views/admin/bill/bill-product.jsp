<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gio hang</title>
<jsp:include page="/views/admin/common/cssjs.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			<div class="col-md-9 col-sm-12">
				<h2>Thong tin don hang:</h2>
				<div>
					<p>Bill Id: ${bill.id }</p>
					<p>Nguoi mua: ${bill.buyer.name }</p>
					<p>Ngay mua: ${bill.buyDate }</p>
					<p>Tong tien: ${bill.priceTotal }</p>
				</div>
				<h2>Danh sach san pham:</h2>
				<table border="1">
					<tr>
						<td>Id</td>
						<td>San pham</td>
						<td>Anh</td>
						<td>So luong</td>
						<td>Don gia</td>
						<td>Tong tien</td>
					</tr>
					<c:forEach items="${billProducts}" var="billProduct">
						<tr>
							<td>${billProduct.id }</td>
							<td><a
								href="/HelloWeb6/client/product/detail?id=${billProduct.product.id }">${billProduct.product.name }</a></td>
							<td><img
								src="/HelloWeb6/download?image=${billProduct.product.image }"
								width="100" /></td>
							<td>${billProduct.quantity }</td>
							<td>${billProduct.unitPrice }</td>
							<td>${billProduct.unitPrice * billProduct.quantity}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>