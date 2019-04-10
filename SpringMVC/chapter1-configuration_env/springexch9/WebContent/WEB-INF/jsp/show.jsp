<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	show.jsp 和 return 一致 <br>
	<%
		Map<String,String> m = new HashMap<String,String>();
		//p136HashMap多选框， 或第10章的一条数据（？）
		m.put("k1","zhao");
		m.put("k2","qian");
		m.put("k3","sun");
		m.put("k4","li");
		request.setAttribute("mkey", m);
	%>
	
	EL输出 ， P135 <br>
	${name[0] } <br>
	<!-- 	大小写区分 -->
	${requestScope.name[0] } <br>
	${requestScope.name[1] }
	${requestScope.name[2] }
	<br>
	======================
	<br>
	${address[0] }
	${address[1] }
	<br>
	model中取:${requestScope.address[2] }
	<br>--------Map输出<br>
	1&nbsp; ${mkey} <br>
	2&nbsp; ${mkey.k1} <br>
	3&nbsp; ${mkey["k1"]} <br>
	4&nbsp; ${mkey['k1']} <br>

	<br />=======for 改写 九九乘法表 p141

	<!-- 	for(i=1;i<=9;i++)等价 -->
	<!-- 		for(j=1;j<=i;j++)等价 -->

	<table>

		<c:forEach var="i" begin="1" end="9">
			<tr>
				<!-- 		注意： i要取值，要用EL -->
				<c:forEach var="j" begin="1" end="${i }">
					<td>${i }*${j }=${i*j } &nbsp; &nbsp;</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>