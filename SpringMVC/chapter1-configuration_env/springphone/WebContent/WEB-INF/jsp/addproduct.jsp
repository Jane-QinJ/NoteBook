<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href="<%=basePath%>"> 
<!-- 增加base  改为绝对路径-->
</head>
<body>

<!-- 有保护作用，无法直接访问 -->

	<form:form modelAttribute="phone" method="post" action="goods/save">
    手机名称：<form:input path="phone_name" />
    价格：<form:input path="price" />
    库存：<form:input path="stock" />
		<input type="submit" value="提交" />
	</form:form>
</body>
</html>