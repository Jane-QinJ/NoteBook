<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
<!-- 	ʹ��javabean��װ������Ҫ��user.name -->
		Username: <input type="text" name="user.name"/>
		Password: <input type="password" name="user.pwd"/>
		<input type="submit" value="��¼"/>
		<s:token></s:token>
	</form>
</body>
</html>