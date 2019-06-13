<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		if (password.equals("123")) {
			session.setAttribute("loginuser", username);
			response.sendRedirect("friendList.jsp");
		} else
			response.sendRedirect("login.jsp");
	%>
</body>
</html>