<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1 style="text-align: center">đăng ký category 1</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form action="/HelloWeb6/category/dang-ky" method="post">
					<div class="form-group">
						<label>tên</label> <input class="form-control" type="text"
							name="name" placeholder="Nhap ten">
						<div>
							<input class="btn btn-primary" type="submit" value="Đắng ký">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>