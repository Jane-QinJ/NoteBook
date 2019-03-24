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

	<form:form modelAttribute="pyq" method="post" action="pyq/save">
		Author:<form:input path="author"></form:input>
		<br>Content:<form:input path="content"></form:input>
		<input type="submit" value="提交">
		
	</form:form>
	
</body>
</html>