<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("utf-8");
out.println("aaa");
String sender = request.getParameter("sender");
String getter = request.getParameter("getter");
String con = request.getParameter("con");

System.out.println("连数据库");
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost/chat?user=root&password=123123";
Connection conn = DriverManager.getConnection(url);

conn.setAutoCommit(false);

String sql = "insert into messages values (null, ?, ?, ?,now(),0)";
PreparedStatement pstmt = conn.prepareStatement(sql);
Statement stmt = conn.createStatement();


pstmt.setString(1, sender);
pstmt.setString(2, getter);
pstmt.setString(3, con);
pstmt.executeUpdate();

conn.commit();
conn.setAutoCommit(true);

pstmt.close();
conn.close();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>