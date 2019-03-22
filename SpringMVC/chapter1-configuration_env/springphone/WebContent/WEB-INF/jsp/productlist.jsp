<%@page import="java.util.List"%>
<%@page import="controller.Phone"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<Phone> array = (List<Phone>)request.getAttribute("goodslist");
	out.print("<table>");
	for(int i = 0; i<array.size();i++)
	{
		Phone tmp = array.get(i);
			out.print("<tr>");
			
			out.print("<td>"
			+tmp.getPhone_name()+"</td>");
				
			out.print("td"+tmp.getPrice()+"</td>");
			out.print("<td>"+tmp.getStock()+"</td>");
			out.print("</tr>");
}
	out.print("</table>");
%>
</body>
</html>