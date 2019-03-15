<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
<!-- action 的提交地址.action 是扩展名，默认为.action；action 的扩展名和 web.xml 中配 -->
<!-- 置的 struts2 的核心过滤器相匹配；也就是如果表单中提交的地址以.action 结尾，那么在配 -->
<!-- 置 filter 的 url-pattern 时一定是: <url-pattern>*.action</url-pattern>; -->

	<form action="teacher" method="post">
		Username:<input type="text" name="name">
		Password:<input type="password" name="password">
		<input type="submit">
	</form>
</body>
</html>