<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	String username = request.getParameter("username");
	if(username.equals("qin")){
		out.println("用户名不可用");
	}else{
		out.println("用户名可用");
	}
	%>
