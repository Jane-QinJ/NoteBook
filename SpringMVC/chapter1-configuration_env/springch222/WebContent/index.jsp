<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	index.jsp Spring2.2.2 用形参接收请求参数 View p26
	<form action="user/register" method="post">
<!-- value 意义所在	$读取model中临时保存的数据，当表单回退时，数据保留，避免重填 -->

<!-- 对该效果的等价改写，第4章新文本框标签 -->
		Username:<input type="text" name="uname" value="${uname }"> <br> 
		Password:<input
			type="password" name="upass"value="${upass}"> <br> 
			Retry:<input
			type="password" name="repass"> <br>
			<input type="submit" value="submit">
	</form>
	
	<br>
	
</body>
</html>