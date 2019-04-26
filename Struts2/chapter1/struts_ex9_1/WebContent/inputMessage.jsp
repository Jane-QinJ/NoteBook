<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:actionmessage/>
	<s:form action="helloWorld">
		<s:textfield name="message" label="Message"/>
		<!--name去掉，就不会提交给action处理-->
		<s:submit />
	</s:form>
</body>
</html>