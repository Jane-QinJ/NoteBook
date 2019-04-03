<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
    <h1>一张试卷</h1>
    <a href="<c:url value="test/input"/>">继续添加</a>
    <table border="1">
        <tr>
            <th>序号</th>
            <th>题目</th>
            <th>A</th>
            <th>B</th>
            <th>C</th>
            <th>D</th>
          
        </tr>
        <!-- JSTL标签，请参考本书的相关内容 -->
       
        <c:forEach items="${juanzi}" var="q">
            <tr>
                <td>${q.id }</td>
                <td>
                	${q.ask }
                </td>
                <td>
                	${q.optiona }
                </td>
                <td>${q.optionb }</td>
                <td>${q.optionc }</td>
                <td>${q.optiond }                
                </td>
               
            </tr>
        </c:forEach>
    </table>
</body>
</html>