<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	main.jsp, p154, CSS JS略
	1.布局  2.导航菜单
	
	<a href="addcard.jsp" 
	  target="center">添加名片</a>
<!-- 	先查询，之后有删除链接 -->
	<a href="query1.jsp"
	target="center">删除名片</a>  
	
	<a href="query2.jsp"
	target="center">修改名片</a>
	<a href="query3.jsp"
	target="center">查询名片</a>
	<div style="width:100%;height:600">p154 子窗口iframe布局<br>
		<iframe name="center" frameborder="1"
		style="width:100%;height:600"></iframe>
	</div>
	
</body>
</html>