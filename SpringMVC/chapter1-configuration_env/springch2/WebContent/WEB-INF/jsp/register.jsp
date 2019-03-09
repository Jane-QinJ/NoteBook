<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 Register
<!--  EL表达式或原始JSP语句 接受数据 -->
	<%= request.getAttribute("keym") %>
<!-- 	action待配置 -->
	<form action="/user/reg_submit">
		Username:<input type="text" name="uname">
		Password:<input type="password" name="upwd">
		Confirm Password:<input type="text" name="reset_pwd">
		<input type="submit">
	</form>
</body>
</html>