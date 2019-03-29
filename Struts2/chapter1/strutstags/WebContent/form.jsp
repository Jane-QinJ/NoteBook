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
	<h3>Struts Tags</h3>
	<s:form action="tags_form" method="post">
		<s:hidden name="userVO.userId"/>	
		<s:textfield name="userVO.username" label="用户名" required="true"/>
		<s:password name="userVO.password" label="密码" requiredLabel="true"/>	
		<s:password name="userVO.confirmpassword" label="重复密码" requiredLabel="true" requiredPosition="left"/>
		<s:textfield name="userVO.age" label="年龄" />
		<s:textfield name="userVO.email" label="Email"/>
		<s:textfield name="usedVO.birthday" label="生日"/>
		
		<s:radio name="userVO.gender" label="性别" list="#{'M':'男','F':'女'}"/>
		
		<s:checkboxlist name="userVO.hobby" label="爱好" list="{'篮球','编程','唱歌','书法'}"/>
		
		<s:select name="userVO.education" label="学历" 
		headerKey="-1" headerValue="--请选择学历--"
		list="{'高中','大学','硕士','博士'}"/>
		
		<s:combobox name="userVO.position" label="职位"
		headerKey="-1" headerValue="--请选择职位--"
		list="{'工程师','项目经理','技术总监','技术支持'}"/>
		
		<s:textarea name="userVO.explain" label="个人说明" cols="30" rows="8"/>
		
		<s:submit value="提交" />
		<s:reset value="重置"/>
	</s:form>
	
	</body>
</html>