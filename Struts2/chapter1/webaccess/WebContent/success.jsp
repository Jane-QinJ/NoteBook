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
	<%= request.getAttribute("r1") %> <br>
<!-- 	OGNL表达式，不是根对象，要加# -->
	<s:property value="#request.r1"/> <br>
	
	<s:property value="name"/> <br>
	<s:property value="#session.session"/>
	<s:debug></s:debug>
</body>
</html>