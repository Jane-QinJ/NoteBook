<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String username = request.getParameter("username");
username = java.net.URLDecoder.decode(username.toString(),"utf-8");
System.out.println(username);
String loginuser = (String)session.getAttribute("loginuser");

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="my.js"></script>
	<script type="text/javascript">

	window.resizeTo(600,600);
	window.setInterval("getMsg()",10000);
	
	//定义一个ajax引擎
	
	function sendMsg(){	
		var myXmlHttpRequest=getXmlHttpObject();
		//怎么判断创建ok
		if(myXmlHttpRequest){
			
			var url = "SendMessageController.jsp";
			var data ="con=" + $("con").value + "&getter=<%= username%>&sender=<%= loginuser%>";
			window.alert(data);
			myXmlHttpRequest.open("post",url,true);
			//指定回调函数.chuli是函数名
			myXmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			myXmlHttpRequest.onreadystatechange = function (){
				if(myXmlHttpRequest.readyState==4){
					window.alert(myXmlHttpRequest.status);
					
				}
			};
			myXmlHttpRequest.send(data); 
		}
	}
	
	
	//每隔一定时间 从 服务器得到属于自己的 消息
	function getMsg(){
		var myXmlHttpRequest=getXmlHttpObject();
		//怎么判断创建ok
		if(myXmlHttpRequest){
			
			var url = "GetMessageController.jsp";
			var data = "getter=<%= loginuser%>&sender=<%= username%>";
			window.alert(data);
			myXmlHttpRequest.open("post",url,true);
			//指定回调函数.chuli是函数名
			myXmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			myXmlHttpRequest.onreadystatechange = function (){
				if(myXmlHttpRequest.readyState==4){
					window.alert(myXmlHttpRequest.status);
					window.alert(myXmlHttpRequest.responseText);
					var mydata = eval("(" + myXmlHttpRequest.responseText + ")");
					window.alert(mydata.length);
				}
			}
			myXmlHttpRequest.send(data); 
		}
		
			
		
	}
	
	</script>
</head>
<body>
<center>
    我的聊天室(<%= loginuser%>在和<font color="red"><%= username%></font>聊天) <br>
    <textarea rows="10" id="mytextares" cols="50"></textarea><br/>
    <input type="text" id="con">
    <input type="button" onclick="sendMsg();" value="发送"><br>
    <input type="button" onclick="getMsg();" value="获取">
   </center>
</body>
</html>