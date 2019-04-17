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
</head>
<body>

	<form:form action="food/save" modelAttribute="food" method="post">
		Food Name:<form:input path="name" /><br>
		Quantity:<form:input path="quantity" /><br>
		Address:<form:input path="address" /><br>
		<br>
		<input type="submit"/>
	</form:form>
</body>
</html>