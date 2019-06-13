<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>欢迎登陆聊天室</h1>
	<form action="LoginController.jsp" method="post">
		用户名 : <input type="text" name="username" size="10"><br />
		密&nbsp;&nbsp;&nbsp;&nbsp;码 : <input type="password" name="password"
			size="11"><br/> 
			
		<input type="submit" value="登录到聊天室">
	</form>
</body>
</html>