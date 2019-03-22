<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 增加base  改为绝对路径-->
</head>
<body>
<!-- 有保护作用，无法直接访问 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<form:form modelAttribute="phone" method="post" action="save">
    手机名称：<form:input path="phone_name" />
    价格：<form:input path="price" />
    库存：<form:input path="stock" />
		<input type="submit" value="提交" />
	</form:form>
</body>
</html>