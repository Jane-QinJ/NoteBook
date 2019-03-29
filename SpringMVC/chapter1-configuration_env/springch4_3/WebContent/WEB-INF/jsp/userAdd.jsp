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
	<form:form modelAttribute="user" method="post" action="user/save">
		<fieldset>
			<legend>添加一个用户</legend>
			<p>
				<label>Username:</label>
				<form:input path="userName" />
			</p>
			<p>
				<label>Hobby:</label>
				<form:checkboxes items="${hobbys }" path="hobby" />
			</p>
			<p>
				<label>Friends</label>
				<form:checkbox path="friends" value="张三" />
				张三
				<form:checkbox path="friends" value="李四" />
				李四
				<form:checkbox path="friends" value="王五" />
				王五
				<form:checkbox path="friends" value="赵六" />
				赵六
			</p>

			<p>
				<label>Career:</label>
				<form:select path="carrer">
					<option />Please choose your career:
				<form:options items="${carrers }" />
				</form:select>
			</p>
			<p>
				<label>户籍:</label>
				<form:select path="houseRegister">
					<option/>请选择户籍
					<form:options items="${houseRegisters }" />
				</form:select>
			</p>
			<p>
				<label>个人描述:</label>
				<form:textarea path="remark" rows="5"/>
			</p>
			<p id="buttons">
				<input id="reset" type="reset">
				<input id="submit" type="submit" value="Add">
			</p>
		</fieldset>
	</form:form>
</body>
</html>