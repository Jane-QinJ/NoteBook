<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href="<%=basePath%>">
</head>
<body>
(1)编写View:表单：添加一道试题和四个选项，正确答案，提交案例ch5，数据合法性的验证
(2)控制类三个请求：打开表单，添加，查询
(3)编写View:多行多列，一张试卷
	<form:form modelAttribute="question" method="post" action="test/save">
		<fieldset>
		<legend>添加一个题</legend>
		<p>
			<label>题目：</label>
			<form:input path="ask"/>
			<br>
			A<form:input path="optiona"/>
			<br>B<form:input path="optionb"/>
			<br>C<form:input path="optionc"/>
			<br>D<form:input path="optiond"/>
			正确答案<form:input path="correct_ans"/>
		</p>
		<p id="buttons">
			<input id="reset" type="reset">
			<input id="submit" type="submit" value="添加">
			
		</p>
		</fieldset>
	</form:form>
</body>
</html>