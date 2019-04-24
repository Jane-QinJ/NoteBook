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
	<s:form action="addBookList" method="post">
		<s:iterator value="new int[2]" status="status">
			<s:textfield name="%{'books['+#status.index+'].bookName'}" label="BookName"/>
			<s:textfield name="%{'books['+#status.index+'].bookPrice'}" label="BookPrice"/>
			<s:textfield name="%{'books['+#status.index+'].bookPublishDate'}" label="BookPublishDate"/>
			<s:textfield name="%{'books['+#status.index+'].bookCount'}" label="BookCount"/>
			<s:label value="----------------"></s:label>
		</s:iterator>
		<s:submit name="submit" value="Submit"></s:submit>
		<s:submit name="reset" value="Reset"></s:submit>
	</s:form>
<!-- 	private String bookName; -->
<!-- 	private double bookPrice; -->
<!-- 	private Date bookPublishDate; -->
<!-- 	private int bookCount; -->
	<s:if test="books!=null">
		Added books info as following:<br>
		<s:iterator value="books">
			BookName :<s:property value="bookName"/><br>
			BookPrice:<s:property value="bookPrice"/><br>
			BookPublishDate:<s:property value="bookPublishDate"/><br>
			BookCount<s:property value="bookCount"/><br>
			<s:label value="--------------------"></s:label>
		</s:iterator>
	</s:if>
</body>
</html>