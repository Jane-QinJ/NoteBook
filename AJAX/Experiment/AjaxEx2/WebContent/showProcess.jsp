<%@ page contentType="text/xml;charset=gb2312" %>

	<%
		String province = request.getParameter("province");
		System.out.println(province);
		System.out.println(new String(province.getBytes("iso-8859-1"),"utf-8"));
		province = new String(province.getBytes("iso-8859-1"),"utf-8");
		if(province.equals("山西")){
			out.println("<province><city>太原</city><city>晋中</city><city>临汾</city></province>");
			
		}else if(province.equals("湖北")){
			out.println("<province><city>武汉</city><city>咸宁</city><city>黄石</city></province>");
		}
	
	%>
