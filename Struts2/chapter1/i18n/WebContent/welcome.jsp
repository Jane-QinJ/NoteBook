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
1. 占位符{0}   s:param 传参 <br>
	<s:text name="msg.welcome">
<!-- 		通过在资源文件中添加占位符，在视图用s:param给资源文件的占位符传递参数 -->
		<s:param>
			<s:property value="username"/>
		</s:param>
	</s:text>
<%-- 	<s:property value="username"/> --%>
<br>
=============<br>
2. ognl $ {username } <br>
	<s:text name="msg.welcome.ognl">
		
	</s:text>
	
</body>
</html>