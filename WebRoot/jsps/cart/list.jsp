<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>购物车列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<style type="text/css">
* {
	font-size: 11pt;
}
body{
	padding: 10px;
	box-sizing: border-box;
	background: url(< c : url value = '/images/mycart.jpg'/ >);
	background-size: 100% 100%;
}
.cart-title{
	border-left: 5px solid orange;
	padding-left: 20px;
	font-size: 26px;
	letter-spacing: 5px;
}
div {
	margin: 20px;
	border: solid 2px gray;
	width: 150px;
	height: 150px;
	text-align: center;
}

li {
	margin: 10px;
}

#buy {
	background: url(<c:url value='/images/all.png'/>) no-repeat;
	display: inline-block;
	background-position: 0 -902px;
	margin-left: 30px;
	height: 36px;
	width: 146px;
}
th{
	text-align: center;
}
#buy:HOVER {
	background: url(< c : url value = '/images/all.png'/ >) no-repeat;
	display: inline-block;
	background-position: 0 -938px;
	margin-left: 30px;
	height: 36px;
	width: 146px;
}
.img{
	width: 40px;
	height: 60px;
}
.book-name{
	font-weight: 600;
}
table.table>tbody>tr>td{
	vertical-align: middle;
}
.content td{
	text-align: center;
}
</style>
</head>

<body>
	<h1 class="cart-title">我的购物车</h1>
	<c:choose>
		<c:when
			test="${empty sessionScope.cart or fn:length(sessionScope.cart.cartItems) eq 0 }">
			<img src="<c:url value='/images/cart.png'/>" width=300 />
		</c:when>
		<c:otherwise>
			<!-- <table border="1" width="100%" cellspacing="0" background="black"> -->
			<table class="table table-hover">
				<tr>
					<td class="clear-cart" colspan="7" align="right"
						style="font-size: 15pt; font-weight: 900"><a
						href="<c:url value='/CartServlet?method=clear'/>">清空购物车</a></td>
				</tr>
				<tr>
					<th>图片</th>
					<th>书名</th>
					<th>作者</th>
					<th>单价</th>
					<th>数量</th>
					<th>小计</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${sessionScope.cart.cartItems}" var="cartItem">
					<tr class="content">
						<td>
							<img class="img" src="<c:url value='/${cartItem.book.image}'/>" />
						</td>
						<td class="book-name">${cartItem.book.bname}</td>
						<td>${cartItem.book.author}</td>
						<td>${cartItem.book.price}元</td>
						<td>${cartItem.count}</td>
						<td>${cartItem.subtotal}元</td>
						<td><a
							href="<c:url value='/CartServlet?method=delete&bid=${cartItem.book.bid}'/>">删除</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="7" align="right"
						style="font-size: 15pt; font-weight: 900">
						合计：${sessionScope.cart.total}元</td>
				</tr>
				<tr>
					<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
						<a id="buy" href="<c:url value='/OrderServlet?method=add'/>"></a>
					</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>
