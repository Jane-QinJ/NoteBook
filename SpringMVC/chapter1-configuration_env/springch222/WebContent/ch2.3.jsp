<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	2.3 p33
	<a href="index/login/">法第一个请求</a> /index/login
	第1步，执行forward:/index/isLogin //只能带请求名
	第2步，执行redirect:/index/isRegister //只能带请求名
	第3步，执行return "register";  //没有前缀，默认转发，只能带网页文件名
	
	最后url: index/isRegister
</body>
</html>