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
  	请输入坐标点：
  	<s:form action="point" method="post">
	  	<s:textfield name="" label="点"></s:textfield>
	  	<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>