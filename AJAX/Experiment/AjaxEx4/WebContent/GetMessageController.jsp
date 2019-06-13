<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="org.json.*" %>

<!DOCTYPE html>
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
out.println(array.toString());

%>