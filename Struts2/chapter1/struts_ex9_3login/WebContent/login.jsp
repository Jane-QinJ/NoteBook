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
	<s:actionmessage/>
	<s:actionerror/>
	<s:form action="login">
		<s:textfield name="message" label="Message"/>
		<s:submit />
	</s:form>
	<s:a action="others">Click here, visit others Action!</s:a>
</body>
</html>