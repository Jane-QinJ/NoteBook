<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:a href="login?request_locale=en">英语</s:a>
	<s:a href="login?request_locale=zh">汉语</s:a>
	<s:form action="login">
		<s:textfield name="username" key="info.username"></s:textfield>
<!-- 		getText()要继承ActionSupport方法才有    
			 %可以调方法，防止只输出字符串 -->
		<s:textfield name="password" label="%{getText('info.password')}"></s:textfield>
		<s:submit key="info.submit"></s:submit>
	</s:form>
</body>
</html>