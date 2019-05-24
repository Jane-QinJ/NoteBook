# EX1 使用ajax完成用户名的验证
ajax: 数据的交互

- register.html
```
<script type="text/javascript">
	/**
	 * [getXmlHttpObject 创建AJAX引擎]
	 * @return {[xmlHttpRequest]} [ajax请求对象]
	 */
	function getXmlHttpObject(){
		
		var xmlHttpRequest;
		//不同浏览器获取对象xmlhttprequest对象方法不同
		if(window.ActiveXObject){
			xmlHttpRquest = new ActiveXObject("Microsoft.XMLHTTP");
		}else{
			xmlHttpRequest = new XMLHttpRequest();
			
		}
		return xmlHttpRequest;
	}
	
	/**
	 * [$ 用于按id获取传入元素]
	 * @param  {[id]}  [参数为要获取元素的id]
	 * @return {[document.getElementById(id)]}    [返回目标元素]
	 */
	function $(id){
		return document.getElementById(id);
	}
	
	/**
	 * [chuli 回调函数]
	 * @return {[$('myres').value=myXmlHttpRequest.responseText;]} [myres为表单中的一个空input栏，将xmlhttprequest的返回值赋值给表单中的一个空input栏，用于显示jsp处理后生成的text]
	 */
	function chuli(){
		//readyState4 描述一种"已加载"状态；此时，响应已经被完全接收。
		//也就是完全接受后， onreadystatechange事件触发器 触发chuli函数
		if(myXmlHttpRequest.readyState==4){
			$('myres').value=myXmlHttpRequest.responseText;
		}
	}
	var myXmlHttpRequest="";
	

	/**
	 * [checkName 验证用户名是否存在]
	 * @return {[type]} [description]

	 *(1) open方法
语法： open(method,URL,async);
第一个参数method指示打开的方式，要么是GET要么是POST，通过GET方式工作时数据附加在URL地址后面，但是附加的数据不能太长，通过POST方式可以传递很长的数据。第二个参数URL是一个接收数据的服务器网页，第三个参数async表示工作方式是否是异步方式，如果为true就是异步方式，为false为同步方式。
	 *
	 *(2) send方法
语法： send(s);
该方法向服务器传递s字符串数据，如果method使用GET方法，一般都不传递数据，这时可以设置s为null。如果是Post方法传递数据，传递的数据就作为该方法的参数
	 */
	function checkName(){
		//创建ajax引擎
		 myXmlHttpRequest = getXmlHttpObject();
		 
		 //怎么判断创建ok
		 if(myXmlHttpRequest){
			 var url = "registerProcess.jsp?username=" + $("username").value;
			 //打开请求
			 myXmlHttpRequest.open("get",url,true);
			 //指定回调函数  只有当回调函数条件被触发，才返回对应的值，异步
			 myXmlHttpRequest.onreadystatechange=chuli;
			 
			 //向服务器发送数据 get填入null即可
			 myXmlHttpRequest.send(null);
		 }
	}
	
	
</script>

<body>
	<form action="" method = "post">
		Username: <input type="text" onkeyup="checkName();" name="username1" id="username"/>
		<input type="button" onclick="checkName();" value="验证用户名"/>
		<input style="border-width:0;color:red" type="text" id="myres">
	</form>
</body>
```

- registerProcess.jsp

```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	String username = request.getParameter("username");
	if(username.equals("qin")){
		out.println("用户名不可用");
	}else{
		out.println("用户名可用");
	}
	%>
```

## Ajax程序异步执行过程
(1) 用户通过用户界面发出需求；
(2) JavaScript开始调用XMLHttpRequest对象并设置传递给服务器的参数；
(3) XMLHttpRequest对象通过网络连接Web服务器并发出HTTP请求；
(4) Web服务器接收到请求和传递来参数后与数据库进行数据交换；
(5) Web服务器通过网络把数据按XML或者JSON或者别的形式传回给客户端；
(6) XMLHttpRequest对象接收到数据后回调预先设置好的事件函数；
(7) 事件函数解析数据后把结果显示在用户界面。
这里的事件函数就是XMLHttpRequest对象的onreadystatechange事件函数，这个事件函数指向程序中一个自定义的函数体。

![ajax_process](https://github.com/Jane-QinJ/NoteBook/blob/master/AJAX/images/2_ajax_process.png)

使用ajax与服务器通信的的步骤
1. 创建一个XMLHttpRequest对象
2. 通过xmlHttpRequest对象的方法发送请求到服务器的某个页面，使用xmlHttpRequest.open(), xmlHttpRequest.send()
3. 服务器端接收 ajax的请求,做相应处理(操作数据库)，然后返回结果
4. 客户端通过xmlHttpRequest的属性 接收数据，然后就完成局部刷新当前页面任务-- reponseText , responseXML 

## issues

**Q1:取返回值时,取到的是一整个页面**

```
$('myres').value=myXmlHttpRequest.responseText;
```

![google network debug](https://github.com/Jane-QinJ/NoteBook/blob/master/AJAX/images/ex1_reponseText.png)

**S1:理解responseText, 返回的是*纯文本***


responseText 会将目标页面的所有字符以纯文本输出，包括html标签

XMLHttpRequest对象的responseText属性
该属性的值是服务器返回的字符串数据，当服务器的ContentType设置为"text/plain"或者"text/html"时，可以通过该属性得到服务器传递给客户端的文本数据。
