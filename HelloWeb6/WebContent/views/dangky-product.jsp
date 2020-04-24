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
	color: gray;
	text-align: center;
}

p {
	font-family: verdana;
	font-size: 20px;
}
</style>
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
	<h1 style="text-align: center">đăng ký product</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form action="/HelloWeb6/product/dang-ky" method="post">
					<div class="form-group">
						<label>tên sản phẩm</label> <input class="form-control"
							type="text" name="name" placeholder="Nhap ten">
						<div>
							<div class="form-group">
								<label>giá sản phẩm</label> <input class="form-control"
									type="text" name="price" placeholder="nhập giá">
							</div>
							<div class="form-group">
								<label>categoryid</label> <input class="form-control"
									type="text" name="categoryId" placeholder="nhập categoryid">
							</div>
							<input class="btn btn-primary" type="submit" value="Đắng ký">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>