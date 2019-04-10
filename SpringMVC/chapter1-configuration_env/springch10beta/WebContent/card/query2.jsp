<%@page import="com.domain.Card"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	修改多条名片，表格，p176
	<%
		List<Card> allcards = new ArrayList<Card>();
		allcards.add(new Card(1,"a1","123456"));
		allcards.add(new Card(2,"a2","123456"));
		allcards.add(new Card(3,"a3","123456"));
		request.setAttribute("allcards", allcards);
		
	%>
	<table border="1">

		<c:forEach items="${allcards}" var="card">
			<tr>
				<td>${card.id }</td>
				<td>${card.name }</td>
				<td>${card.tel }</td>
				<td>修改</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>