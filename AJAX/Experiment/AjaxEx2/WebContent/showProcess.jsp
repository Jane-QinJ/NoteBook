<%@ page contentType="text/xml;charset=gb2312" %>

	<%
		String province = request.getParameter("province");
		System.out.println(province);
		System.out.println(new String(province.getBytes("iso-8859-1"),"utf-8"));
		province = new String(province.getBytes("iso-8859-1"),"utf-8");
		if(province.equals("ɽ��")){
			out.println("<province><city>̫ԭ</city><city>����</city><city>�ٷ�</city></province>");
			
		}else if(province.equals("����")){
			out.println("<province><city>�人</city><city>����</city><city>��ʯ</city></province>");
		}
	
	%>
