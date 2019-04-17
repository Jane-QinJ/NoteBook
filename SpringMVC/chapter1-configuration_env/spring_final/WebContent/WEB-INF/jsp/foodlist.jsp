<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<table border="1">
<!-- 	注意EL的写法 -->
		<c:forEach items="${foodlist}" var="food"> 
			<tr>
				<td>${food.name }</td>
				<td>${food.quantity }</td>
				<td>${food.address }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>