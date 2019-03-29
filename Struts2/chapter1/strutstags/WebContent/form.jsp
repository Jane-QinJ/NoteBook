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
		<s:textfield name="userVO.username" label="�û���" required="true"/>
		<s:password name="userVO.password" label="����" requiredLabel="true"/>	
		<s:password name="userVO.confirmpassword" label="�ظ�����" requiredLabel="true" requiredPosition="left"/>
		<s:textfield name="userVO.age" label="����" />
		<s:textfield name="userVO.email" label="Email"/>
		<s:textfield name="usedVO.birthday" label="����"/>
		
		<s:radio name="userVO.gender" label="�Ա�" list="#{'M':'��','F':'Ů'}"/>
		
		<s:checkboxlist name="userVO.hobby" label="����" list="{'����','���','����','�鷨'}"/>
		
		<s:select name="userVO.education" label="ѧ��" 
		headerKey="-1" headerValue="--��ѡ��ѧ��--"
		list="{'����','��ѧ','˶ʿ','��ʿ'}"/>
		
		<s:combobox name="userVO.position" label="ְλ"
		headerKey="-1" headerValue="--��ѡ��ְλ--"
		list="{'����ʦ','��Ŀ����','�����ܼ�','����֧��'}"/>
		
		<s:textarea name="userVO.explain" label="����˵��" cols="30" rows="8"/>
		
		<s:submit value="�ύ" />
		<s:reset value="����"/>
	</s:form>
	
	</body>
</html>