<%@page import="domain.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.Book"%>
<%@page import="java.util.ArrayList"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<base href="<%=basePath%>">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	a{
	text-decoration:none;
	color:white;
	}
	.del{
	color:red; 
	font-size:32px;
	position:relative;
	left:16px;
	bottom:5px;
	}
</style>
</head>
<body>

	<%
		Cart cart = (Cart) session.getAttribute("cart");
		ArrayList<Book> bookList = cart.showCart();
		Double totalPrice = cart.getTotalPrice();
	%>
	<%--修改为表单 --%>
	<div class="container">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<div style="text-align:center; font-size:18px;" class="panel-title">购物车</div>
				</div>
				<div class="panel-body">
					<div class="form-horizontal">
						<form action="updateServlet" method="post">
							<table class="table table-striped">
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Delete</th>
								</tr>
								<a href="welcome.jsp">返回购物大厅</a>
								<%
									for (int i = 0; i < bookList.size(); i++) {
										Book book = bookList.get(i);
								%>
								<div>
									<tr>
										<td><%=book.getId()%><input type="hidden" name="id"
											value="<%=book.getId()%>"></td>
										<td><%=book.getName()%></td>
										<td><%=book.getPrice()%></td>

										<td><input type="text" class="form-control"
											name="quantity" value="<%=book.getQuantity()%>"></td>
										<td><a class="del" href="deleteServlet?id=<%=book.getId()%>">-</a>
										</td>
									</tr>


									<%
										}
									%>
									<tr>
										<td colspan="5">总金额：  <%=totalPrice%></td>

									</tr>
									<tr>
										<td colspan="4"><button type="submit"
												class="btn btn-danger pull-center">刷新</button></td>
										<td><button class="btn btn-danger ">
												<a href="clearServlet">清空购物车</a>
											</button></td>
									</tr>
							</table>
							<div style="text-align:center;">
		<button class="btn btn-danger pull-left"><a style="color:white;" href="welcome.jsp">返回购物车</a></button>
	</div>
							<h3>
								<button class="btn btn-danger pull-right">
									<a href="showOrder.jsp">提交订单</a>
								</button>
							</h3>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>