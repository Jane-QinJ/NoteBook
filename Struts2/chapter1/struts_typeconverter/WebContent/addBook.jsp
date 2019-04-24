<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
	<s:actionerror/>
	<s:form action="addBook">
		<s:textfield name="book.bookName" label="书名"/>
		<s:textfield name="book.bookPrice" label="单价"/>
		<s:textfield name="book.bookPublishDate" label="出版日期"/>
		<s:textfield name="book.bookCout" value="1" label="数量" />
		
		<s:submit name="submit" value="提交"/>
		<s:reset name="reset" value="重置"/>
	</s:form>
	
	<s:if test="book.bookName != ''">
		添加的书目信息如下: <br>
		BookName: <s:property value="book.bookName" /> <br>
		BookPrice: <s:property value="book.bookPrice" /><br>
		BookPublishDate <s:property value="book.bookPublishDate"/><br>
		BookCount: <s:property value="book.bookCount"/>
	
	</s:if>
	
</body>
</html>