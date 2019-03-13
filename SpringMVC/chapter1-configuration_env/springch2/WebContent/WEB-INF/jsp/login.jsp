<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Login
<%-- 	El表达式${ }，或原始的jsp语句 --%>
	<%=request.getAttribute("key1") %>
	<%=session.getAttribute("key2") %>
</body>
</html>