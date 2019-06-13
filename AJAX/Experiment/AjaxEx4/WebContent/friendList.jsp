<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>friendList</title>
<script type="text/javascript">
	window.resizeTo(200,600);
	
	//移入时颜色、指针变化
	function abc(obj){
		obj.style.color="red";
		obj.style.cursor="hand";
	}
	//移除时颜色变化
	function abc2(obj){
		
		obj.style.color="";
		
		
	}
	
	//跳出一个聊天的页面 将username参数传入
	function abc3(obj){
		var username=obj.innerText;
		//username = encodeURI(encodeURI(username));
		username = encodeURI(username);
		window.open("chatRoom.jsp?username="+username,"_blank");
	}
	
</script>
</head>
<body>
	<h1>好友列表</h1><br>
	<ol>
		<li id="li1" onmouseover="abc(this)" onclick="abc3(this);" onmouseout="abc2(this)">张三</li>
		<li id="li2" onmouseover="abc(this)" onclick="abc3(this);" onmouseout="abc2(this)">李四</li>
		<li id="li3" onmouseover="abc(this)" onclick="abc3(this);" onmouseout="abc2(this)">王五</li>
	</ol>
</body>
</html>