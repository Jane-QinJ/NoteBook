<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
        function cli(id){
            //confirm方法弹出一个对话框,可以选择确定与取消操作
            //同时该方法有返回值,true和false,两个布尔值
            var flag = confirm("确定删除吗?");
            if(flag){
                alert("你点击了确定");
                //进行后台处理,路径跳转
                window.location.href="user/del?id="+id;
            }else{
                alert("你点击了取消");
            }
        }
</script>
<!----------------------- -->
<!--作者：齐佳乐 -->
<!--来源：CSDN -->
<!--原文：https://blog.csdn.net/konaji/article/details/50476300 -->
<!--版权声明：本文为博主原创文章，转载请附上博文链接！-->
<body>
    <h1>用户列表</h1>
    <a href="<c:url value="user/input"/>">继续添加</a>
    <table border="1">
        <tr>
            <th>用户名</th>
            <th>兴趣爱好</th>
            <th>朋友</th>
            <th>职业</th>
            <th>户籍</th>
            <th>个人描述</th>
            <th> </th>
        </tr>
        <!-- JSTL标签，请参考本书的相关内容 -->
        <%int i=0; %>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.userName }</td>
                <td>
                	<c:forEach items="${user.hobby }" var="hobby">
                		${hobby }
                	</c:forEach>
                </td>
                <td>
                	<c:forEach items="${user.friends }" var="friend">
                		${friend }
                	</c:forEach>
                </td>
                <td>${user.carrer }</td>
                <td>${user.houseRegister }</td>
                <td>${user.remark }                
                </td>
                <td>
				<%="<a href='user/select?id="+i+"'>"+"修改</a>" 	%>  
<%="<a href='user/del?id="+i+"'>"+"jsp删除</a>" 	%>
<%="<a href='javascript:cli("+i+")' >"+"js删除</a>" 	%>
				<% i++; %>              
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>