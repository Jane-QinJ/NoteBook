<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
request.setCharacterEncoding("utf-8");
String sender = request.getParameter("sender");
String getter = request.getParameter("getter");
System.out.println(sender);


//System.out.println("连数据库");
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost/chat?user=root&password=123123";
Connection conn = DriverManager.getConnection(url);
Statement stmt = conn.createStatement();
String sql = "select * from messages where getter='" + getter + "' and sender ='" + sender + "'";
//System.out.println(sql);
ResultSet rs = stmt.executeQuery(sql);
/*
while(rs.next()){
	System.out.println(rs.getString("sender") + "对" + rs.getString("getter") + "说：" + rs.getString("content"));
	
}*/
//json数组  
JSONArray array = new JSONArray();  
 
// 获取列数  
ResultSetMetaData metaData = rs.getMetaData();  
int columnCount = metaData.getColumnCount();  
System.out.println(columnCount); 

// 遍历ResultSet中的每条数据  
 while (rs.next()) {  
     JSONObject jsonObj = new JSONObject();  
      
     // 遍历每一列  
     for (int i = 1; i <= columnCount; i++) {  
         String columnName =metaData.getColumnLabel(i);  
         String value = rs.getString(columnName);  
         jsonObj.put(columnName, value);  
     }   
     array.put(jsonObj);   
 }  
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>>