<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
<!-- action ���ύ��ַ.action ����չ����Ĭ��Ϊ.action��action ����չ���� web.xml ���� -->
<!-- �õ� struts2 �ĺ��Ĺ�������ƥ�䣻Ҳ������������ύ�ĵ�ַ��.action ��β����ô���� -->
<!-- �� filter �� url-pattern ʱһ����: <url-pattern>*.action</url-pattern>; -->

	<form action="login.action" method="post">
		Username:<input type="text" name="name">
		Password:<input type="password" name="password">
		<input type="submit">
	</form>
</body>
</html>