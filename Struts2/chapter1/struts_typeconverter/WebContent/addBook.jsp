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
		<s:textfield name="book.bookName" label="����"/>
		<s:textfield name="book.bookPrice" label="����"/>
		<s:textfield name="book.bookPublishDate" label="��������"/>
		<s:textfield name="book.bookCout" value="1" label="����" />
		
		<s:submit name="submit" value="�ύ"/>
		<s:reset name="reset" value="����"/>
	</s:form>
	
	<s:if test="book.bookName != ''">
		��ӵ���Ŀ��Ϣ����: <br>
		BookName: <s:property value="book.bookName" /> <br>
		BookPrice: <s:property value="book.bookPrice" /><br>
		BookPublishDate <s:property value="book.bookPublishDate"/><br>
		BookCount: <s:property value="book.bookCount"/>
	
	</s:if>
	
</body>
</html>