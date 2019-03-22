<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addGoods" method="post">
    	商品名称：<input type="text" name="goodsname"/><br>
    	商品价格：<input type="text" name="goodsprice"/><br>
    	商品数量：<input type="text" name="goodsnumber"/><br>
    	<input type="submit" value="提交"/>
    </form>
</body>
</html>