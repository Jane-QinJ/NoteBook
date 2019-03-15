<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page  import="domain.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Register
	Spring2.2.2 用形参接受请求参数
	<br>View p26
	<form action="user/register" method="post">
<!-- value 意义所在	$读取model中临时保存的数据，当表单回退时，数据保留，避免重填 -->

<!-- 对该效果的等价改写，第4章新文本框标签 -->
		Username:<input type="text" name="uname" value="${user.uname }"> <br> 
		Password:<input
			type="password" name="upass"value="${user.upass}"> <br> 
			Retry:<input
			type="password" name="repass"> <br>
			<input type="submit" value="submit">
	</form>
	
	<br>
		<!-- 	提示信息 "uname" -- String ,Integer -->
<!-- 		要将Bean转换为UserForm类型 -->
		<%
		
		UserForm tmp=(UserForm)request.getAttribute("user"); //bean
		out.print(tmp.getUname());
		out.print(tmp.getUpass());
		%>
		
<%-- 		<%=request.getAttribute("upass")%> --%>
<br>
		View用EL表达式读取
	
	${ user.uname}
	${ error}
	${ user.upass}
</body>
</html>