<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	background-color: #56baed;
	
	
}

.col-md-4 {
	margin: 178px 500px;
	box-shadow: 0 30px 60px 0 rgba(0, 0, 0, .3);
	padding: 0;
}

.panel {
	margin-bottom: 0px;
}
</style>
</head>

<body>


	<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
	%>
	<%=msg%>
	<%
		}
	%>



	<div class="container-fluid">

		<div class="col-md-4">

			<div class="panel panel-primary">
				<div class="panel-heading"
					style="text-align: center; font-size: 18px;">欢迎登录网上书店</div>
				<div class="panel-body">
					<form action="user/validate" method="post">
						<div class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-4 control-label">用户名:</label>
								<div class="col-sm-8">
									<input type="text" name="username" class="form-control"
										placeholder="please enter your username">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">密 码:</label>
								<div class="col-sm-8">
									<input type="password" name="password" class="form-control"
										placeholder="please enter your password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<div class="row">
										<div class="col-sm-6">
											<button type="submit" class="btn btn-primary">登录</button>
										</div>
										<div class="col-sm-6">
											<button type="reset" class="btn btn-info ">重置</button>
										</div>
									</div>
								</div>

							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>

</body>
</html>