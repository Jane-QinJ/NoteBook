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
1.����ֵջ��action����ͨ����
	<s:property value="name"/>
	<br>
2.����ֵջ��action�Ķ�������
	<s:property value="user.age"/>
	<br>
4. ����ֵջ�ж������ͨ������
	<s:property value="password.length()"/>
	<br>
	
5. ����ֵջ�ж������ͨ������
	<s:property value="cat.miaomiao()"/>
	<br/>
	
6. ����action�е���ͨ������
	<s:property value="m()"/>
	<br/>
	
7. ���ʾ�̬������(*)
<!-- ע��,����@��Լ��..Ҳ���Ǳ�����ôд.��һ��@������������ȫ��.�ڶ���@��������Ƕ�Ӧ�ķ�����.��Ȼ,������������Ǿ�̬�� -->

<!--  ������ʾ�̬������struts2.1�Ժ�İ汾������Ҫ����һ������,����ϵͳĬ���ǲ�֧�ַ��ʾ�̬������(struts2.0�汾Ĭ����֧�ַ��ʾ�̬������).����ķ�������struts.xml���������ôһ�� -->

<!--  <constant name="struts.ognl.allowStaticMethodAccess" value="true"></constant> -->
	<s:property value="@sxau.rjxy.bean.S@t()"/>
	<br/>
8. ���ʾ�̬���ԣ�
	<s:property value="@sxau.rjxy.bean.S@STR"/>
	<br/>
9. Math
	<s:property value="@@max(5,10)"/>
	<br/>
	<s:debug/>
	
</body>
</html>