<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="sxau.rjxy.bean.S" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
1.访问值栈中action的普通属性
	<s:property value="name"/>
	<br>
2.访问值栈中action的对象属性
	<s:property value="user.age"/>
	<br>
4. 访问值栈中对象的普通方法：
	<s:property value="password.length()"/>
	<br>
	
5. 访问值栈中对象的普通方法：
	<s:property value="cat.miaomiao()"/>
	<br/>
	
6. 访问action中的普通方法：
	<s:property value="m()"/>
	<br/>
	
7. 访问静态方法：(*)
<!-- 注意,两个@是约定..也就是必须这么写.第一个@后面跟的是类的全名.第二个@后面跟的是对应的方法名.当然,这个方法必须是静态的 -->

<!--  这个访问静态方法在struts2.1以后的版本里面需要设置一个属性,否则系统默认是不支持访问静态方法的(struts2.0版本默认是支持访问静态方法的).具体的方法是在struts.xml里面添加这么一句 -->

<!--  <constant name="struts.ognl.allowStaticMethodAccess" value="true"></constant> -->
	<s:property value="@sxau.rjxy.bean.S@t()"/>
	<br/>
8. 访问静态属性：
	<s:property value="@sxau.rjxy.bean.S@STR"/>
	<br/>
9. Math
	<s:property value="@@max(5,10)"/>
	<br/>
	<s:debug/>
	
</body>
</html>