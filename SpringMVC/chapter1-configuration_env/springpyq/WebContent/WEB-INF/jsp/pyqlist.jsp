<%@page import="domain.Pyq"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	取出从Controller中的共享数据pyqlist -->
	<%List<Pyq> pyqlist = (List<Pyq>)request.getAttribute("pyqlist"); %>
<!-- 	List中有多个pyq对象，用for取出（之后用El表达式） -->
	<%
		out.print("<table>");
		for(int i = 0; i < pyqlist.size();i++){
			Pyq temp = pyqlist.get(i);
			out.print("<tr>");
			out.print("<td>"+temp.getAuthor()+"</td>");
			out.print("<td>"+temp.getContent()+"</td>");
			out.print("</tr>");
		}
	%>
</body>
</html>