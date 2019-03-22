<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="my/converter" method="post">
    		请输入商品信息（格式为：apple,10.58,200）：
<!--     		goods传递给convertercontroller -->
    		<input type="text" name="goods"/><br>  
    		<input type="submit" value="提交"/>
    </form>
</body>
</html>